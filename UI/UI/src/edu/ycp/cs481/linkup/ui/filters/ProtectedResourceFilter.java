package edu.ycp.cs481.linkup.ui.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpUtils;

import edu.ycp.cs481.linkup.model.User;



public class ProtectedResourceFilter implements Filter{

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		
		// Get the Session
		HttpSession thisSession = request.getSession(true);
		
		// Does the session indicate that the user is logged in?
	
		System.out.println("Got here 1");
		Object userVerified =  thisSession.getAttribute("login.isDone");
		System.out.println("Got here 2");
		if (userVerified != null)
		{
			User thisUser = (User) thisSession.getAttribute("loggedInUser");
			
			if(thisUser != null)
			{
				// user object was returned successfully
				// If the user is logged in and available then grant the resource
				System.out.println("request.getRequestURI = "+ request.getRequestURI());
				//response.sendRedirect(arg0);
			}
			else
			{
				// user object was not returned successfully but login.isDone was true
				// set login.isDone to false
				thisSession.setAttribute("login.isDone", false);
				// save original target
				thisSession.setAttribute("login.origTarget", request.getRequestURL());
				// ask user to login again...
				//response.sendRedirect("index");
				req.getRequestDispatcher("/_view/index.jsp").forward(req, resp);
				
			}
			
			
		}
		else
		{
			System.out.println("Got here 3");
			// User is not logged in, save request and redirect to login
			
			// Save Request
			thisSession.setAttribute("login.origTarget", request.getRequestURI());
						
			// Redirect to login
			//response.sendRedirect("index");
			req.getRequestDispatcher("/_view/index.jsp").forward(req, resp);
		}
		
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		
		//Get init parameter
		String testParam = config.getInitParameter("test-param");
		
		//Print the init parameter
		System.out.println("Test Param: " + testParam);
		
	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
		// release any used resources...
		
	}

}
