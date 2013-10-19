package edu.ycp.cs481.linkup.ui.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ycp.cs481.linkup.persistence.SQLconnection;


public class MatchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static String DB_USERNAME = "ajcummins";
	private static String DB_PASSWORD = "root";
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//req.setAttribute("match", soulMate);
		req.getRequestDispatcher("/_view/userMatch.jsp").forward(req, resp);
	      
	}
	

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
			
		 int lookingGender = 1;
		 int lookingAgeLow = 0;
		 int lookingAgeHigh = 100;
		
			int userid = -1;
			userid = Integer.parseInt(req.getParameter("user_id"));

			if(userid < 0)
			{
				//Some type of error
				req.setAttribute("error", "You have remaining Empty Fields");
				req.getRequestDispatcher("/_view/userMatch.jsp").forward(req, resp);
			}
			else
			{
				java.sql.PreparedStatement stmt = null;
				String soulMate = null;
				try 
		        {   
				 SQLconnection sqlConn = new SQLconnection();
				 Connection con = sqlConn.createConnection(DB_USERNAME, DB_PASSWORD);	
				 
				 //start here
				
				 stmt = con.prepareStatement("SELECT gender FROM linkup.looking_for WHERE user_id = " + userid);
		            stmt.executeQuery();
		            ResultSet result = stmt.getResultSet();
		            result.next();
		            lookingGender = result.getInt(1);
		            
		            stmt = con.prepareStatement("SELECT age_low FROM linkup.looking_for WHERE user_id = " + userid);
		            stmt.executeQuery();
		            ResultSet result2 = stmt.getResultSet();
		            result2.next();
		            lookingAgeLow = result2.getInt(1);
		            
		            stmt = con.prepareStatement("SELECT age_high FROM linkup.looking_for WHERE user_id = " + userid);
		            stmt.executeQuery();
		            ResultSet result3 = stmt.getResultSet();
		            result3.next();
		            lookingAgeHigh = result3.getInt(1);
		        	
		        } 
		        catch (Exception e) 
		        {
		            e.printStackTrace();
		        }
				 
				try{ 
				SQLconnection sqlConn = new SQLconnection();
				 Connection con = sqlConn.createConnection(DB_USERNAME, DB_PASSWORD);
				//end here
				 stmt = con.prepareStatement("SELECT username FROM linkup.profile_info WHERE gender = " + lookingGender +" AND age BETWEEN "+ lookingAgeLow +" AND " + lookingAgeHigh);
				 //stmt = con.prepareStatement("SELECT username FROM linkup.profile_info WHERE gender = " + gender +" AND age BETWEEN "+ ageLow +" AND " + ageHigh);
		            stmt.executeQuery();
		            ResultSet result = stmt.getResultSet();
		            result.next();
		            soulMate = result.getString(1);
		        	
		        } 
		        catch (Exception e) 
		        {
		            e.printStackTrace();
		        } 
				
				req.setAttribute("match", soulMate);
				req.getRequestDispatcher("/_view/userMatch.jsp").forward(req, resp);
		}
	}
}

