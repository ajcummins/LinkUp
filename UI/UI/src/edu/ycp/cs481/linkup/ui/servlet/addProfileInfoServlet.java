package edu.ycp.cs481.linkup.ui.servlet;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ycp.cs481.linkup.controller.LookingForController;
import edu.ycp.cs481.linkup.controller.ProfileController;
import edu.ycp.cs481.linkup.model.LookingFor;
import edu.ycp.cs481.linkup.model.Path;
import edu.ycp.cs481.linkup.model.UserProfile;
import edu.ycp.cs481.linkup.persistence.PersistenceException;

public class addProfileInfoServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private int user_id;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.getRequestDispatcher("/_view/SetUpProfileInfo.jsp").forward(req, resp);
		
					
		//Get userid from the url passed
		Path urlPath = new Path(req.getPathInfo());
		System.out.println("Path = " + req.getPathInfo());
		user_id = Integer.parseInt(urlPath.getUserIDFromPath());
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO: get profile info 
		
		
		//int user_id = Integer.parseInt(req.getParameter("user_id")); //convert to int later
		int location = Integer.parseInt(req.getParameter("location"));  //convert to int later
		int gender = Integer.parseInt(req.getParameter("gender"));    //convert to int later
		int age = Integer.parseInt(req.getParameter("age"));				//convert to int later
		int religion = Integer.parseInt(req.getParameter("religion"));
		String books = req.getParameter("books");
		String movies = req.getParameter("movies");
		String music = req.getParameter("music");
		String basic_info = req.getParameter("basic_info");
		String likes = req.getParameter("likes");
		String dislikes = req.getParameter("dislikes");
		int looking_for = Integer.parseInt(req.getParameter("looking_for"));
		
		//testing to see if gets info
		System.out.println("user id: " + user_id 
					+ "\nlocation: " + location
					+ "\nreligion: " + gender
					+ "\nage: " + age
					+ "\nreligion: " + religion
					+ "\nbooks: " + books
					+ "\nmovies: " + movies
					+ "\nmusic: " + music
					+ "\nbasic info: " + basic_info
					+ "\nlikes: " + likes
					+ "\ndislikes: " + dislikes
					+ "\nlooking for: " + looking_for);
		
			UserProfile tempProfileInfo = new UserProfile(user_id, location, gender, age, religion, books, movies, music, basic_info, likes, dislikes, looking_for);
			
			
			
			ProfileController controller = new ProfileController();
			try {
				controller.Profile(tempProfileInfo);
			} catch (PersistenceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			resp.sendRedirect("lookingFor/"+ user_id);
			//req.getRequestDispatcher("/_view/lookingFor.jsp").forward(req, resp);
		
			
			
			
			
			
	}
}


