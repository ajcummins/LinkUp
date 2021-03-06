package edu.ycp.cs481.linkup.ui.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.client.api.Request;

import edu.ycp.cs481.linkup.controller.LoadUserProfile;
import edu.ycp.cs481.linkup.controller.LookingForController;
import edu.ycp.cs481.linkup.controller.MessageController;
import edu.ycp.cs481.linkup.controller.ProfileController;
import edu.ycp.cs481.linkup.controller.SendMessageController;
import edu.ycp.cs481.linkup.model.LookingFor;
import edu.ycp.cs481.linkup.model.Messages;
import edu.ycp.cs481.linkup.model.Path;
import edu.ycp.cs481.linkup.model.User;
import edu.ycp.cs481.linkup.model.UserProfile;
import edu.ycp.cs481.linkup.persistence.PersistenceException;
import edu.ycp.cs481.linkup.persistence.SQLconnection;

public class ReplyMessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	private static String DB_USERNAME = "ajcummins";
	private static String DB_PASSWORD = "root";
	private int userid;	
	private int Loginuserid;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		
		Path urlPath1 = new Path(req.getPathInfo());
		Loginuserid = Integer.parseInt(urlPath1.getLoggedInUserIDFromPath());
		System.out.print("This is the user that is logged in: " + Loginuserid);
				
		//Get userid from the url passed
		Path urlPath = new Path(req.getPathInfo());
		userid = Integer.parseInt(urlPath.getMatchUserIDFromPath());
			
		MessageController controller = new MessageController();
		String username = null;
		try {
			username = controller.MessagingUserName(userid);
		} catch (PersistenceException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		req.getSession().setAttribute("sendid", username);		
		req.getRequestDispatcher("/_view/replyMessage.jsp").forward(req, resp);
				
		
	}
		
		protected void doPost(HttpServletRequest req, HttpServletResponse resp)
				throws ServletException, IOException {
			
			String message = null;
			message = req.getParameter("message");
			
			if(message == null){
				//Some type of error
				req.setAttribute("error", "You have remaining Empty Fields");
				req.getRequestDispatcher("/_view/lookingFor.jsp").forward(req, resp);
			}
			else
			{
				System.out.println("user to: " + userid 
						+ "\nuser from: " + Loginuserid
						+ "\nmessage: " + message);
				Messages mes = new Messages(userid, Loginuserid, message);

				SendMessageController controller = new SendMessageController();
				try {
					controller.ReplyMessages(mes);

				} catch (PersistenceException e) {
					e.printStackTrace();
					throw new ServletException("Error communicating with database", e);
				}
				resp.sendRedirect("matchMessages/"+ Loginuserid);				
			}				
	}
}