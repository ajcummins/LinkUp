package edu.ycp.cs481.linkup.ui.servlet;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import edu.ycp.cs481.linkup.controller.LookingForController;
import edu.ycp.cs481.linkup.controller.ProfileController;
import edu.ycp.cs481.linkup.controller.RatingController;
import edu.ycp.cs481.linkup.model.LookingFor;
import edu.ycp.cs481.linkup.model.Path;
import edu.ycp.cs481.linkup.model.Rating;
import edu.ycp.cs481.linkup.model.UserProfile;
import edu.ycp.cs481.linkup.persistence.PersistenceException;

public class RatingServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private int user_id;
	private int rating_id;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.getRequestDispatcher("/_view/Rating.jsp").forward(req, resp);
		
					
		//Get userid from the url passed
		Path urlPath = new Path(req.getPathInfo());
		System.out.println("Path = " + req.getPathInfo());
		user_id = Integer.parseInt(urlPath.getUserIDFromPath());
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO: get profile info 
		
		
		
		String username = req.getParameter("username"); //get username of the person they are rating
														//check to make sure username is in database
														//get that usernames User_ID
		String comment = req.getParameter("comment");
		

		
		
		//testing to see if gets info
		System.out.println("user id: " + user_id 
					+ "\nrating: " + comment
					+ "\nusername: " + username);
		
			Rating tempRating = new Rating(user_id,username, comment);
			
			
			
			RatingController controller = new RatingController();
		
			try {
				controller.Rating(tempRating);
			} catch (PersistenceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			resp.sendRedirect("lookingFor/"+ user_id);
			//req.getRequestDispatcher("/_view/lookingFor.jsp").forward(req, resp);
		
			
			
			
			
			
	}
	
}


