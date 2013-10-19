package edu.ycp.cs481.linkup.ui.servlet;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ycp.cs481.linkup.controller.LookingForController;
import edu.ycp.cs481.linkup.controller.ProfileController;
import edu.ycp.cs481.linkup.model.LookingFor;
import edu.ycp.cs481.linkup.model.UserProfile;
import edu.ycp.cs481.linkup.persistence.PersistenceException;

public class addProfileInfoServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.getRequestDispatcher("/_view/SetUpProfileInfo.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO: get profile info 
		
		int user_id = Integer.parseInt(req.getParameter("user_id")); //convert to int later
		String username = req.getParameter("username");
		int location = Integer.parseInt(req.getParameter("location"));  //convert to int later
		int gender = Integer.parseInt(req.getParameter("gender"));    //convert to int later
		int age = Integer.parseInt(req.getParameter("age"));				//convert to int later
		String religion = req.getParameter("religion");
		String books = req.getParameter("books");
		String movies = req.getParameter("movies");
		String music = req.getParameter("music");
		String basic_info = req.getParameter("basic_info");
		String likes = req.getParameter("likes");
		String dislikes = req.getParameter("dislikes");
		int looking_for = Integer.parseInt(req.getParameter("looking_for"));
		
		//testing to see if gets info
		System.out.println("user id: " + user_id 
					+ "\nusername: " + username
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
		
			UserProfile tempProfileInfo = new UserProfile(user_id, username, location, gender, age, religion, books, movies, music, basic_info, likes, dislikes, looking_for);
			
			/*tempProfileInfo.setUserid(user_id);
			tempProfileInfo.setUsername(username);
			tempProfileInfo.setLocation(location);
			tempProfileInfo.setGender(gender);
			tempProfileInfo.setAge(age);
			tempProfileInfo.setReligion(religion);
			tempProfileInfo.setBooks(books); 
			tempProfileInfo.setMusic(music);
			tempProfileInfo.setBasic_Info(basic_info);
			tempProfileInfo.setLikes(likes);
			tempProfileInfo.setDislikes(dislikes);
			tempProfileInfo.setLooking_For(looking_for);
			*/
			
			ProfileController controller = new ProfileController();
			try {
				controller.Profile(tempProfileInfo);
			} catch (PersistenceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			req.getRequestDispatcher("/_view/lookingFor.jsp").forward(req, resp);
		
			
			
			
			
			
	}
}

