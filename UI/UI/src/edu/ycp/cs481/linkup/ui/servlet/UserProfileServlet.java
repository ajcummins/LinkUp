package edu.ycp.cs481.linkup.ui.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ycp.cs481.linkup.controller.LoadUserProfile;
import edu.ycp.cs481.linkup.model.UserProfile;
import edu.ycp.cs481.linkup.persistence.PersistenceException;

public class UserProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		try {
			// FIXME: should get user id from URL path info
			String pathInfo = req.getPathInfo(); // <-- here
			
			int profileId = 456;
			
			LoadUserProfile controller = new LoadUserProfile();
			UserProfile profile = controller.getUserProfile(profileId);
			// FIXME: should check to see if it's null
			
			// Put model objects to be displayed in request as request attributes
			req.setAttribute("UserProfile", profile);
			
			// Forward to a view for rendering
			req.getRequestDispatcher("/_view/userProfile.jsp").forward(req, resp);
		
		} catch (PersistenceException e) {
			throw new ServletException("Persistence exception getting user profile", e);
		}
		
	}

}
