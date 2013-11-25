package edu.ycp.cs481.linkup.ui.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;






import javax.servlet.http.HttpSession;

import edu.ycp.cs481.linkup.controller.CreateUserController;
import edu.ycp.cs481.linkup.controller.IndexController;
import edu.ycp.cs481.linkup.controller.LoadUserProfile;
import edu.ycp.cs481.linkup.model.User;
import edu.ycp.cs481.linkup.model.UserProfile;
import edu.ycp.cs481.linkup.persistence.BadCredentialsException;
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
				
				
				if(inUser == "" || inPass == "")
				{
					req.setAttribute("error", " Not all fields have been filled out");
					req.getRequestDispatcher("/_view/index.jsp").forward(req, resp);
				}
				else
				{
					req.setAttribute("info", "Successfully logged in!");
					//Challenge of credentials passed
					
					//Forward to the profile page and Pass the user object
					//FIXME: forward the user object to the userProfile....
					
					HttpSession thisSession = req.getSession(true);
					thisSession.setAttribute("loggedInUser", testUser);
					thisSession.setAttribute("login.isDone", true);

					
					
					//go to profile page
					resp.sendRedirect("userProfile");			
				}
				
				
			} catch (BadCredentialsException e) {
				// Credentials Did not match
				req.setAttribute("error", " Username / Password Combination not Found");
				req.getRequestDispatcher("/_view/index.jsp").forward(req, resp);
			} catch (PersistenceException e) {
				throw new ServletException("Error communicating with database", e);
			}
			
		}
	}

}
