package edu.ycp.cs481.linkup.ui.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ycp.cs481.linkup.controller.IndexController;
import edu.ycp.cs481.linkup.controller.MatchingController;
import edu.ycp.cs481.linkup.model.Matching;
import edu.ycp.cs481.linkup.model.Path;
import edu.ycp.cs481.linkup.persistence.PersistenceException;
import edu.ycp.cs481.linkup.persistence.SQLconnection;


public class MatchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static String DB_USERNAME = "ajcummins";
	private static String DB_PASSWORD = "root";
	
	int user_id;
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//req.setAttribute("match", soulMate);
		//req.getRequestDispatcher("/_view/userMatch.jsp").forward(req, resp);
		
		//Get userid from the url passed
		Path urlPath = new Path(req.getPathInfo());
		System.out.println("Path = " + req.getPathInfo());
		user_id = Integer.parseInt(urlPath.getUserIDFromPath());
		
		MatchingController controller = new MatchingController();
		String[] match = null;
		try {
			match = controller.Matching(user_id);
		} catch (PersistenceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//String[] match = get_match(user_id, req, resp);
		String table = "";
		if(match == null){
			req.setAttribute("match", "No Matches at this time. :(");
			req.getRequestDispatcher("/_view/userMatch.jsp").forward(req, resp);
		}
		else{
			for(int i = 0; i < match.length; i++){
				table = table + (i+1) + ") " + match[i] + "      <input name='submit' value='View "+ match[i] +" Profile' type='submit' /><br>";
			}
			req.setAttribute("match", table);
			req.getRequestDispatcher("/_view/userMatch.jsp").forward(req, resp);
		}
	}
	

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String buttonAction = req.getParameter("submit");
		if(buttonAction.equals("Profile")){
			System.out.print("\nthis is the user id:" + user_id);
			resp.sendRedirect("userProfile/"+ user_id);					
		}else{
			System.out.print("\nthis is the value:" + buttonAction);
			int id = getMatchID(buttonAction);
			
			resp.sendRedirect("MatchProfile/"+ user_id + "/" + id);
		}
	}
	public int getMatchID(String buttonAction)
	{
		String[] array = buttonAction.split("");
		System.out.print("\nthis is the array:" + array);
		String matchUser = "";
		int i; 
		int matchid = -1;
		for(i = 0; i < array.length; i++){
			
			if(i < 6 || i > (array.length - 9)){
				//do nothing	
			}
			else{
				//System.out.print("\n" + array[i]);
				matchUser = matchUser + array[i];
			}
		}
		
		java.sql.PreparedStatement stmt = null;
		try 
        {   
		 SQLconnection sqlConn = new SQLconnection();
		 Connection con = sqlConn.createConnection(DB_USERNAME, DB_PASSWORD);	

		 stmt = con.prepareStatement("SELECT user_id FROM linkup.user WHERE username = '" + matchUser + "';");
            stmt.executeQuery();
            ResultSet result = stmt.getResultSet();
            result.next();
            matchid = result.getInt(1);
        }catch (Exception e) 
        {
            e.printStackTrace();
        }
		System.out.print("\nthis is the usernaem:" + matchUser + "\n");
		System.out.print("\nthis is the User Id of Match:" + matchid + "\n");
		return matchid;
	}
	
	
}

