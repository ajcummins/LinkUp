package edu.ycp.cs481.linkup.ui.servlet;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

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
import edu.ycp.cs481.linkup.persistence.DuplicateUserException;
import edu.ycp.cs481.linkup.persistence.PersistenceException;
import edu.ycp.cs481.linkup.persistence.SQLconnection;

public class RatingServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private int user_id;
	private int rating_id;
	private static String DB_USERNAME = "ajcummins";
	private static String DB_PASSWORD = "root";


	private int userLogin;
	private String username;
	private String comment;


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.getRequestDispatcher("/_view/Rating.jsp").forward(req, resp);


		//Get userid from the url passed
				Path urlPath = new Path(req.getPathInfo());
				System.out.println("Path = " + req.getPathInfo());
				userLogin = Integer.parseInt(urlPath.getUserIDFromPath());

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO: get profile info 



		String username = req.getParameter("username"); //get username of the person they are rating
		//check to make sure username is in database
		//get that usernames User_ID
		String comment = req.getParameter("comment");


		java.sql.PreparedStatement stmt = null;
		int userid=0;

		try 
		{   
			SQLconnection sqlConn = new SQLconnection();
			Connection con = sqlConn.createConnection(DB_USERNAME, DB_PASSWORD);	


			//RATED USERS ID
			stmt = con.prepareStatement("SELECT user_id FROM linkup.user WHERE username = '" + username + "';" );
			stmt.executeQuery();
			ResultSet result = stmt.getResultSet();
			result.next();
			userid = result.getInt(1); //gets the rated users id
			System.out.println("user id: " + userid);

		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}





		//testing to see if gets info
		System.out.println("username: " + username
				+ "\nrated user id: " + userid
				+ "\ncomment: " + comment);








		Rating tempRating = new Rating(rating_id, userid, comment);



		RatingController controller = new RatingController();

		try {
			rating_id = controller.createRating(tempRating);
		} catch (PersistenceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		resp.sendRedirect("userProfile/"+ userLogin);
		






	}

}


