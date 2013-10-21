package edu.ycp.cs481.linkup.ui.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ycp.cs481.linkup.controller.LoadUserProfile;
import edu.ycp.cs481.linkup.controller.ProfileController;
import edu.ycp.cs481.linkup.model.UserProfile;
import edu.ycp.cs481.linkup.persistence.PersistenceException;
import edu.ycp.cs481.linkup.persistence.SQLconnection;

public class ProfileViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	private static String DB_USERNAME = "ajcummins";
	private static String DB_PASSWORD = "root";
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		String location1 = null;
		String gender1 = null;
		String looking_for1 = null;
		
			// Forward to a view for rendering
			//req.getRequestDispatcher("/_view/userProfile.jsp").forward(req, resp);
			
			
			int userid = 2;
			//userid = Integer.parseInt(req.getParameter("user_id"));

			
				java.sql.PreparedStatement stmt = null;
				String  religion =null; String books=null; String movies=null; String music=null;String basic_info=null;
				String likes=null; String dislikes=null; 
				int location=0; int gender=0;int age=0;int looking_for=0;
				String first_name = null; String last_name = null;
				
				try 
		        {   
				 SQLconnection sqlConn = new SQLconnection();
				 Connection con = sqlConn.createConnection(DB_USERNAME, DB_PASSWORD);	
				 
				 //GET F NAME!!!
				 stmt = con.prepareStatement("SELECT first_name FROM linkup.user WHERE user_id = " + userid);
		            stmt.executeQuery();
		            ResultSet result12 = stmt.getResultSet();
		            result12.next();
		            first_name = result12.getString(1); //gets first name
				 
		            //GET L NAME!!!
					 stmt = con.prepareStatement("SELECT last_name FROM linkup.user WHERE user_id = " + userid);
			            stmt.executeQuery();
			            ResultSet result13 = stmt.getResultSet();
			            result13.next();
			            last_name = result13.getString(1); //gets first name
				 
				 
				 
				
				 //LOCATION
				 	stmt = con.prepareStatement("SELECT location FROM linkup.profile_info WHERE user_id = " + userid);
		            stmt.executeQuery();
		            ResultSet result = stmt.getResultSet();
		            result.next();
		            location = result.getInt(1); //gets location
		            
		        	
		            if(location == 0){
		            	 location1 = "PA";
		            }else if(location == 1){
		            	location1 = "DE";
		            }else if(location == 2){
		            	location1 = "MD";
		            }else if(location == 3){
		            	location1 = "NJ";
		            }
		  
		            
		            //GENDER
		           stmt = con.prepareStatement("SELECT gender FROM linkup.profile_info WHERE user_id = " + userid);
		            stmt.executeQuery();
		            ResultSet result2 = stmt.getResultSet();
		            result2.next();
		            gender = result2.getInt(1);
		            
		            
		            if(gender == 1){
		            	 gender1 = "Male";
		            }else if(gender == 2){
		            	gender1 = "Female";
		            }
		            
		            //AGE
		            stmt = con.prepareStatement("SELECT age FROM linkup.profile_info WHERE user_id = " + userid);
		            stmt.executeQuery();
		            ResultSet result3 = stmt.getResultSet();
		            result3.next();
		            age = result3.getInt(1);
		        	
		            //RELIGION
		            stmt = con.prepareStatement("SELECT religion FROM linkup.profile_info WHERE user_id = " + userid);
		            stmt.executeQuery();
		            ResultSet result4 = stmt.getResultSet();
		            result4.next();
		            religion = result4.getString(1);
		        	
		            //BOOKS
		            stmt = con.prepareStatement("SELECT books FROM linkup.profile_info WHERE user_id = " + userid);
		            stmt.executeQuery();
		            ResultSet result5 = stmt.getResultSet();
		            result5.next();
		            books = result5.getString(1);
		        	
		            //MOVIEs
		            stmt = con.prepareStatement("SELECT movies FROM linkup.profile_info WHERE user_id = " + userid);
		            stmt.executeQuery();
		            ResultSet result6 = stmt.getResultSet();
		            result6.next();
		            movies = result6.getString(1);
		        	
		            //MUSIC
		            stmt = con.prepareStatement("SELECT music FROM linkup.profile_info WHERE user_id = " + userid);
		            stmt.executeQuery();
		            ResultSet result7 = stmt.getResultSet();
		            result7.next();
		            music = result7.getString(1);
		            
		            //basic_info
		            stmt = con.prepareStatement("SELECT basic_info FROM linkup.profile_info WHERE user_id = " + userid);
		            stmt.executeQuery();
		            ResultSet result8 = stmt.getResultSet();
		            result8.next();
		            basic_info = result8.getString(1);
		            
		            //LIKEs
		            stmt = con.prepareStatement("SELECT likes FROM linkup.profile_info WHERE user_id = " + userid);
		            stmt.executeQuery();
		            ResultSet result9 = stmt.getResultSet();
		            result9.next();
		            likes = result9.getString(1);
		            
		            //dislikes
		            stmt = con.prepareStatement("SELECT dislikes FROM linkup.profile_info WHERE user_id = " + userid);
		            stmt.executeQuery();
		            ResultSet result10 = stmt.getResultSet();
		            result10.next();
		            dislikes = result10.getString(1);
		           
		            //looking_for
		            stmt = con.prepareStatement("SELECT looking_for FROM linkup.profile_info WHERE user_id = " + userid);
		            stmt.executeQuery();
		            ResultSet result11 = stmt.getResultSet();
		            result11.next();
		            looking_for = result11.getInt(1);
		            
		            if(looking_for == 1){
		            	looking_for1 = "Relationship";
		            }else if(looking_for == 2){
		            	looking_for1 = "Friendship";
		            }else if(looking_for == 3){
		            	looking_for1 = "Cuddle Buddy";
		            }else if(looking_for == 4){
		            	looking_for1 = "Nothing Serious";
		            }
		            
		            
		            System.out.println("Location: " + location1);
		        	
		            
		        } 
		        catch (Exception e) 
		        {
		            e.printStackTrace();
		        }
				
				
				//merrr
				System.out.println("Age: " + age);
				
				
				
				req.getSession().setAttribute("first_name", first_name);
				req.getSession().setAttribute("last_name", last_name);
			
				req.getSession().setAttribute("location", location1);
				
				
				req.getSession().setAttribute("gender", gender1);
				req.getSession().setAttribute("age", age);
				req.getSession().setAttribute("religion", religion);
				req.getSession().setAttribute("books", books);
				req.getSession().setAttribute("music", music);
				req.getSession().setAttribute("movies", movies);
				req.getSession().setAttribute("basic_info", basic_info);
				req.getSession().setAttribute("likes", likes);
				req.getSession().setAttribute("dislikes", dislikes);
				req.getSession().setAttribute("looking_for", looking_for1);
				
				req.getRequestDispatcher("/_view/userProfile.jsp").forward(req, resp);
	
				
			
			
		
	}
		
		protected void doPost(HttpServletRequest req, HttpServletResponse resp)
				throws ServletException, IOException {
			
			req.getRequestDispatcher("/_view/userMatch.jsp").forward(req, resp);
			//req.getRequestDispatcher("/_view/userMatch.jsp");
				
	}
		
		

}