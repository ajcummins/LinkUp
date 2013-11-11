package edu.ycp.cs481.linkup.ui.servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ProtectedResourceHandler extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		// Get the Session
		HttpSession thisSession = req.getSession(true);
		
		// Does the session indicate that the user is logged in?
		Object userVerified = thisSession.getValue("logon.verified");
		
		if (userVerified != null)
		{
			// Grant the Requested resource based on credentials the user is logged in
			
		}
		else
		{
			// User is not logged in, save request and redirect to login
			
			// Save Request
			thisSession.putValue("login.target", HttpUtils.getRequestURL(req).toString());
			
			// Redirect to login
			req.getRequestDispatcher("/_view/index.jsp").forward(req, resp);
		}
		
		
	}

}
