package edu.ycp.cs481.linkup.ui.servlet;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import edu.ycp.cs481.linkup.controller.DropDownListController;
import edu.ycp.cs481.linkup.controller.LookingForController;
import edu.ycp.cs481.linkup.controller.ProfileController;
import edu.ycp.cs481.linkup.model.LookingFor;
import edu.ycp.cs481.linkup.model.Path;
import edu.ycp.cs481.linkup.model.User;
import edu.ycp.cs481.linkup.model.UserProfile;
import edu.ycp.cs481.linkup.persistence.MysqlDatabase;
import edu.ycp.cs481.linkup.persistence.PersistenceException;
import edu.ycp.cs481.linkup.persistence.SQLconnection;

public class addProfileInfoServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	private static String DB_USERNAME = "ajcummins";
	private static String DB_PASSWORD = "root";
	private int user_id;
	int age = 0;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		DropDownListController controller = new DropDownListController();
		String ddlGender = null;
		String ddlLocation = null;
		String ddlRace = null;
		String ddlReligion = null;
	
		
		
		try{
			ddlGender = controller.ddlGender();
			ddlLocation = controller.ddlLocation();
			ddlRace = controller.ddlLookingFor();
			ddlReligion = controller.ddlReligion();
		}catch (PersistenceException e){
			e.printStackTrace();
		}
		
		req.setAttribute("gender2", ddlGender);
		req.setAttribute("location2", ddlLocation);
		req.setAttribute("religion2", ddlReligion);
		req.setAttribute("race2", ddlRace);
		
		req.getRequestDispatcher("/_view/SetUpProfileInfo.jsp").forward(req, resp);

					
		//Get the userID from the Session User object		
		HttpSession thisSession = req.getSession(true);
		User thisUser = (User) thisSession.getAttribute("loggedInUser");
		Boolean loggedIn = (Boolean) thisSession.getAttribute("login.isDone");
		
		if(loggedIn)
		{
			user_id = thisUser.getUserID();
		}
		else
		{
			//FIXME: Error User not logged in, need to fix w/ filters
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO: get profile info 
		
		/*final String path = "/UserPictures/";
		final Part picture1 = req.getPart("picture");
		//final String fileName = getFileName(picture);
		String picture = req.getParameter("picture"); // get untiled.jpg 
		
		OutputStream out = null;
		InputStream fileContent = null;
		final PrintWriter writer = resp.getWriter();
		
		try{
			out = new FileOutputStream(new File(path + File.separator + picture));
			fileContent = picture1.getInputStream();
			
			int read = 0;
			final byte[] bytes = new byte[1024];
			while((read = fileContent.read(bytes))!= -1){
				out.write(bytes, 0, read);
			}
			System.out.println("New File : " + picture + " created at " + path);
				
		}finally{
			 if (out != null) {
		            out.close();
		        }
		        if (fileContent != null) {
		            fileContent.close();
		        }
		        if (writer != null) {
		            writer.close();
		        }
		}
		*/
		
		
		
		SQLconnection sqlConn = null;
		try {
			sqlConn = new SQLconnection();
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		Connection con = sqlConn.createConnection(DB_USERNAME, DB_PASSWORD);
		
		
		
		
		//int user_id = Integer.parseInt(req.getParameter("user_id")); //convert to int later
		int location = Integer.parseInt(req.getParameter("location"));  //convert to int later
		int gender = Integer.parseInt(req.getParameter("gender"));    //convert to int later
		//int age = Integer.parseInt(req.getParameter("age"));				//convert to int later
		
	
		try {
			age = MysqlDatabase.getBirthdayAge(con, user_id);
			System.out.println("\nUSERSSSSSSSSSS BDAY AGEEEEE CALCULAYTED = " + age);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		/*if (req.getParameter("age") == ""){
			req.setAttribute("error", "You have remaining Empty Fields");
		
		}*/
		
		
		System.out.println("\nUSERSSSSSSSSSS BDAY AGEEEEE CALCULAYTED = " + age);
		
		int religion = Integer.parseInt(req.getParameter("religion"));
		String books = req.getParameter("books");
		String movies = req.getParameter("movies");
		String music = req.getParameter("music");
		String basic_info = req.getParameter("basic_info");
		String likes = req.getParameter("likes");
		String dislikes = req.getParameter("dislikes");
		int race = Integer.parseInt(req.getParameter("race"));
		int seriousness = Integer.parseInt(req.getParameter("seriousness"));
		int children = Integer.parseInt(req.getParameter("children"));
		int married = Integer.parseInt(req.getParameter("married"));
		int pets = Integer.parseInt(req.getParameter("pets"));
		int income = Integer.parseInt(req.getParameter("income"));
		//String picture = req.getParameter("picture"); 
		
		//File file = new File(req.getServletContext().getAttribute("FILES_DIR")+File.separator+picture);
		
		/*File file = new File("/UserPictures/" + picture);
		if(!file.exists()){
			file.mkdirs();			
		}*/
		
		
		
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
					+ "\nrace: " + race
					+ "\nchildren: " + children
					+ "\nmarried: " + married
					+ "\npets: " + pets
					+ "\nincome: " + income
					+ "\nseriousness: " + seriousness);
					//+ "\nPICTURE: "+ picture);
		
			UserProfile tempProfileInfo = new UserProfile(user_id, location, gender, age, religion, books, movies, music, basic_info, likes, dislikes, seriousness, children, married, pets, race, income);
			
			
			
			ProfileController controller = new ProfileController();
			try {
				controller.Profile(tempProfileInfo);
			} catch (PersistenceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//Add the new data to the session for easy use and then redirect
			HttpSession thisSession = req.getSession(true);
			thisSession.setAttribute("usersProfile",tempProfileInfo);
			
			resp.sendRedirect("lookingFor");
		
			
			
			
			
			
	}
	
}


