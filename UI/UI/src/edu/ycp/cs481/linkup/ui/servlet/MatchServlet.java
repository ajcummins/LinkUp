package edu.ycp.cs481.linkup.ui.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ycp.cs481.linkup.model.Path;
import edu.ycp.cs481.linkup.persistence.SQLconnection;


public class MatchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static String DB_USERNAME = "ajcummins";
	private static String DB_PASSWORD = "root";
	
	int user_id;
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//req.setAttribute("match", soulMate);
		//req.getRequestDispatcher("/_view/userMatch.jsp").forward(req, resp);
		
		//Get userid from the url passed
		Path urlPath = new Path(req.getPathInfo());
		System.out.println("Path = " + req.getPathInfo());
		user_id = Integer.parseInt(urlPath.getUserIDFromPath());
		
		String[] match = get_match(user_id, req, resp);
		String table = "";
		if(match == null){
			req.setAttribute("match", "No Matches at this time. :(");
			req.getRequestDispatcher("/_view/userMatch.jsp").forward(req, resp);
		}
		else{
			for(int i = 0; i < match.length; i++){
				table = table + (i+1) + ") " + match[i] + "      <a href='MatchProfile/1'>View Profile</a><br>";
			}
			req.setAttribute("match", table);
			req.getRequestDispatcher("/_view/userMatch.jsp").forward(req, resp);
		}
	}
	

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
			
		System.out.print("this is the user id:" + user_id);
		resp.sendRedirect("userProfile/"+ user_id);	
	}
	
	String[] get_match(int userid, HttpServletRequest req, HttpServletResponse resp)	{
		int lookingGender = 1;
		int lookingAgeLow = 0;
		int lookingAgeHigh = 100;
		int lookingLocation = -1;
		int lookingSeriousness = -1;
		int lookingSeriousnessWeight = -1;

			java.sql.PreparedStatement stmt = null;
			int match = -1;
			String soulMate = null;
			int lookingReligion = -1;
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
	            
	            stmt = con.prepareStatement("SELECT religion FROM linkup.looking_for WHERE user_id = " + userid);
	            stmt.executeQuery();
	            ResultSet result4 = stmt.getResultSet();
	            result4.next();
	            lookingReligion = result4.getInt(1);
	            
	            stmt = con.prepareStatement("SELECT location FROM linkup.looking_for WHERE user_id = " + userid);
	            stmt.executeQuery();
	            ResultSet result5 = stmt.getResultSet();
	            result5.next();
	            lookingLocation = result5.getInt(1);
	        	System.out.print("location is : " + lookingLocation);
	        	
	        	stmt = con.prepareStatement("SELECT seriousness FROM linkup.looking_for WHERE user_id = " + userid);
	            stmt.executeQuery();
	            ResultSet result6 = stmt.getResultSet();
	            result6.next();
	            lookingSeriousness = result6.getInt(1);
	        	System.out.print("type is : " + lookingSeriousness);
	        	
	        	stmt = con.prepareStatement("SELECT seriousness_weight FROM linkup.looking_for WHERE user_id = " + userid);
	            stmt.executeQuery();
	            ResultSet result7 = stmt.getResultSet();
	            result7.next();
	            lookingSeriousnessWeight = result7.getInt(1);
	        	System.out.print("weight is : " + lookingSeriousnessWeight);
	        	
	        } 
	        catch (Exception e) 
	        {
	            e.printStackTrace();
	        }
			
			if(lookingSeriousnessWeight > 6){
				int number = 0;
				try{
					
					SQLconnection sqlConn = new SQLconnection();
					 Connection con = sqlConn.createConnection(DB_USERNAME, DB_PASSWORD);
					String sql = ("SELECT COUNT(*) FROM linkup.profile_info WHERE gender = " + lookingGender +" AND location = " + lookingLocation + " AND religion = " + lookingReligion + " AND looking_for = " + lookingSeriousness +" AND age BETWEEN "+ lookingAgeLow +" AND " + lookingAgeHigh);
					PreparedStatement prest = con.prepareStatement(sql);
				    ResultSet rs = prest.executeQuery();
				    while (rs.next()) {
				      number = rs.getInt(1);
				    }
				    System.out.println("Number of records: " + number);
				    con.close();
					
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally{
					 int newnum = 0;
				}
			if(number != 0){	
				int[] matchs = new int[number];
				String[] soulMates = new String[number];
				int i = 0;
				try{ 
					SQLconnection sqlConn = new SQLconnection();
					 Connection con = sqlConn.createConnection(DB_USERNAME, DB_PASSWORD);
					//end here
					 stmt = con.prepareStatement("SELECT user_id FROM linkup.profile_info WHERE gender = " + lookingGender +" AND location = " + lookingLocation + " AND religion = " + lookingReligion + " AND seriousness = " +lookingSeriousness +"AND age BETWEEN "+ lookingAgeLow +" AND " + lookingAgeHigh);
			            stmt.executeQuery();
			            ResultSet result = stmt.getResultSet();
			            while(result.next()){
			            	//System.out.println("result is: " +result.getInt(1));
			            	match = result.getInt(1);
			            	matchs[i] = match;
			            	System.out.println("match is: " + matchs[i]);
			            	i++;
			            }
			        	
			        } 
			        catch (Exception e) 
			        {
			            e.printStackTrace();
			        } 
					
				
				int j = 0;
				for(j = 0; j < number; j++){
				try{ 
					SQLconnection sqlConn = new SQLconnection();
					 Connection con = sqlConn.createConnection(DB_USERNAME, DB_PASSWORD);
					//end here
					 stmt = con.prepareStatement("SELECT username FROM linkup.user WHERE user_id = " + matchs[j]);
			            stmt.executeQuery();
			            ResultSet result = stmt.getResultSet();
			            result.next();
			            soulMates[j] = result.getString(1);
			            System.out.println("user name: " + soulMates[j]);
			        } 
			        catch (Exception e) 
			        {
			            e.printStackTrace();
			        } 
					
				
				}
				return soulMates;
			}else{
				return null;
			}
				
			}else{
			
			
			int number = 0;
			try{
				
				SQLconnection sqlConn = new SQLconnection();
				 Connection con = sqlConn.createConnection(DB_USERNAME, DB_PASSWORD);
				String sql = ("SELECT COUNT(*) FROM linkup.profile_info WHERE gender = " + lookingGender +" AND location = " + lookingLocation + " AND religion = " + lookingReligion + " AND age BETWEEN "+ lookingAgeLow +" AND " + lookingAgeHigh);
				PreparedStatement prest = con.prepareStatement(sql);
			    ResultSet rs = prest.executeQuery();
			    while (rs.next()) {
			      number = rs.getInt(1);
			    }
			    System.out.println("Number of records: " + number);
			    con.close();
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				 int newnum = 0;
			}
		if(number != 0){	
			int[] matchs = new int[number];
			String[] soulMates = new String[number];
			int i = 0;
			try{ 
				SQLconnection sqlConn = new SQLconnection();
				 Connection con = sqlConn.createConnection(DB_USERNAME, DB_PASSWORD);
				//end here
				 stmt = con.prepareStatement("SELECT user_id FROM linkup.profile_info WHERE gender = " + lookingGender +" AND location = " + lookingLocation + " AND religion = " + lookingReligion + " AND age BETWEEN "+ lookingAgeLow +" AND " + lookingAgeHigh);
		            stmt.executeQuery();
		            ResultSet result = stmt.getResultSet();
		            while(result.next()){
		            	//System.out.println("result is: " +result.getInt(1));
		            	match = result.getInt(1);
		            	matchs[i] = match;
		            	System.out.println("match is: " + matchs[i]);
		            	i++;
		            }
		        	
		        } 
		        catch (Exception e) 
		        {
		            e.printStackTrace();
		        } 
				
			
			int j = 0;
			for(j = 0; j < number; j++){
			try{ 
				SQLconnection sqlConn = new SQLconnection();
				 Connection con = sqlConn.createConnection(DB_USERNAME, DB_PASSWORD);
				//end here
				 stmt = con.prepareStatement("SELECT username FROM linkup.user WHERE user_id = " + matchs[j]);
		            stmt.executeQuery();
		            ResultSet result = stmt.getResultSet();
		            result.next();
		            soulMates[j] = result.getString(1);
		            System.out.println("user name: " + soulMates[j]);
		        } 
		        catch (Exception e) 
		        {
		            e.printStackTrace();
		        } 
				
			
			}
			return soulMates;
		}else{
			return null;
		}
			}
	}
}

