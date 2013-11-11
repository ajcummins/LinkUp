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
					+ "\nlooking for: " + looking_for);
					//+ "\nPICTURE: "+ picture);
		
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


