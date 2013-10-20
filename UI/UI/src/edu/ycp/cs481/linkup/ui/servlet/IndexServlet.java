package edu.ycp.cs481.linkup.ui.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;





import edu.ycp.cs481.linkup.controller.CreateUserController;
import edu.ycp.cs481.linkup.controller.IndexController;
import edu.ycp.cs481.linkup.controller.LoadUserProfile;
import edu.ycp.cs481.linkup.model.User;
import edu.ycp.cs481.linkup.model.UserProfile;
import edu.ycp.cs481.linkup.persistence.DuplicateUserException;
import edu.ycp.cs481.linkup.persistence.PersistenceException;

public class IndexServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.getRequestDispatcher("/_view/index.jsp").forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO: get username and password, use a controller to create new user account, forward to view
		String inUser = req.getParameter("inUser");
		String inPass = req.getParameter("inPass");

		
		// Check if null | Check if password and confirmpassword are the same | Validate that there is no other Usernames like this one
		if(inUser == null || inPass == null)
		{
			//Some type of error
			req.setAttribute("error", "You Have Empty Fields");
			req.getRequestDispatcher("/_view/index.jsp").forward(req, resp);
		}
		else
		{
						
			IndexController controller = new IndexController();
			try {
				
				User testUser = controller.checkUserCredentials(inUser,inPass);
				req.setAttribute("info", "Successfully logged in!");
				
				if(testUser != null)
				{
					//Challenge of credentials passed
					//req.getRequestDispatcher("/_view/userProfile/" +asdf ".jsp").forward(req, resp);
				}
				else
				{
					//Challenge of credentials failed
					req.setAttribute("error", "Your Username or Password was incorrect");
					req.getRequestDispatcher("/_view/index.jsp").forward(req, resp);
				}
				
				// redirect
			} catch (PersistenceException e) {
				throw new ServletException("Error communicating with database", e);
			}
			
			req.getRequestDispatcher("/_view/index.jsp").forward(req, resp);
		}
	}

}
