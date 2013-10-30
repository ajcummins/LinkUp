package edu.ycp.cs481.linkup.ui.servlet;

import java.io.IOException;
import java.io.PrintWriter;
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
		
		String match = get_match(user_id, req, resp);
		req.setAttribute("match", match);
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
				int match = -1;
				String soulMate = null;
				int lookingReligion = -1;
				try 
		        {   
				 SQLconnection sqlConn = new SQLconnection();
				 Connection con = sqlConn.createConnection(DB_USERNAME, DB_PASSWORD);	
				 
				 //start here
				
				 stmt = con.prepareStatement("SELECT gender FROM linkup.looking_for WHERE user_id = " + user_id);
		            stmt.executeQuery();
		            ResultSet result = stmt.getResultSet();
		            result.next();
		            lookingGender = result.getInt(1);
		            
		            stmt = con.prepareStatement("SELECT age_low FROM linkup.looking_for WHERE user_id = " + user_id);
		            stmt.executeQuery();
		            ResultSet result2 = stmt.getResultSet();
		            result2.next();
		            lookingAgeLow = result2.getInt(1);
		            
		            stmt = con.prepareStatement("SELECT age_high FROM linkup.looking_for WHERE user_id = " + user_id);
		            stmt.executeQuery();
		            ResultSet result3 = stmt.getResultSet();
		            result3.next();
		            lookingAgeHigh = result3.getInt(1);
		            
		            stmt = con.prepareStatement("SELECT religion FROM linkup.looking_for WHERE user_id = " + user_id);
		            stmt.executeQuery();
		            ResultSet result4 = stmt.getResultSet();
		            result4.next();
		            lookingReligion = result4.getInt(1);
		        	
		        } 
		        catch (Exception e) 
		        {
		            e.printStackTrace();
		        }
				 
				int number = 0;
				try{
					
					SQLconnection sqlConn = new SQLconnection();
					 Connection con = sqlConn.createConnection(DB_USERNAME, DB_PASSWORD);
					String sql = ("SELECT COUNT(*) FROM linkup.profile_info WHERE religion = "+ lookingReligion + " AND gender = " + lookingGender +" AND age BETWEEN "+ lookingAgeLow +" AND " + lookingAgeHigh);
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
				int i = 0;
				try{ 
					SQLconnection sqlConn = new SQLconnection();
					 Connection con = sqlConn.createConnection(DB_USERNAME, DB_PASSWORD);
					//end here
					 stmt = con.prepareStatement("SELECT user_id FROM linkup.profile_info WHERE religion = "+ lookingReligion + " AND gender = " + lookingGender +" AND age BETWEEN "+ lookingAgeLow +" AND " + lookingAgeHigh);
			            stmt.executeQuery();
			            ResultSet result = stmt.getResultSet();
			            while(result.next()){
			            	//System.out.println("result is: " +result.getInt(1));
			            	match = result.getInt(1);
			            	matchs[i] = match;
			            	i++;
			            	System.out.println("match is: " + matchs[i]);
			            }
			        	
			        } 
			        catch (Exception e) 
			        {
			            e.printStackTrace();
			        } 
					
				
				/*try{ 
				SQLconnection sqlConn = new SQLconnection();
				 Connection con = sqlConn.createConnection(DB_USERNAME, DB_PASSWORD);
				//end here
				 stmt = con.prepareStatement("SELECT user_id FROM linkup.profile_info WHERE gender = " + lookingGender +" AND age BETWEEN "+ lookingAgeLow +" AND " + lookingAgeHigh);
		            stmt.executeQuery();
		            ResultSet result = stmt.getResultSet();
		            result.next();
		            match = result.getInt(1);
		        	
		        } 
		        catch (Exception e) 
		        {
		            e.printStackTrace();
		        } */
				String[] soulMates = new String[100];
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
				
				int k;
				String matchList = "";
				for(k = 0; k < number; k++){
					if(k == 0){
						matchList = matchList + soulMates[k];
					}else{
						matchList = matchList + ", " + soulMates[k];
					}
				}
				req.setAttribute("match", matchList);
				req.getRequestDispatcher("/_view/userMatch.jsp").forward(req, resp);
			}else{
				req.setAttribute("match", "There are no users that fit the qualities that you are looking for at this time. :(");
				req.getRequestDispatcher("/_view/userMatch.jsp").forward(req, resp);
			}
		}
	}
	
	String get_match(int user_id, HttpServletRequest req, HttpServletResponse resp)	{
		int lookingGender = 1;
		int lookingAgeLow = 0;
		int lookingAgeHigh = 100;
	

			java.sql.PreparedStatement stmt = null;
			int match = -1;
			String soulMate = null;
			int lookingReligion = -1;
			try 
	        {   
			 SQLconnection sqlConn = new SQLconnection();
			 Connection con = sqlConn.createConnection(DB_USERNAME, DB_PASSWORD);	
			 
			 //start here
			
			 stmt = con.prepareStatement("SELECT gender FROM linkup.looking_for WHERE user_id = " + user_id);
	            stmt.executeQuery();
	            ResultSet result = stmt.getResultSet();
	            result.next();
	            lookingGender = result.getInt(1);
	            
	            stmt = con.prepareStatement("SELECT age_low FROM linkup.looking_for WHERE user_id = " + user_id);
	            stmt.executeQuery();
	            ResultSet result2 = stmt.getResultSet();
	            result2.next();
	            lookingAgeLow = result2.getInt(1);
	            
	            stmt = con.prepareStatement("SELECT age_high FROM linkup.looking_for WHERE user_id = " + user_id);
	            stmt.executeQuery();
	            ResultSet result3 = stmt.getResultSet();
	            result3.next();
	            lookingAgeHigh = result3.getInt(1);
	            
	            stmt = con.prepareStatement("SELECT religion FROM linkup.looking_for WHERE user_id = " + user_id);
	            stmt.executeQuery();
	            ResultSet result4 = stmt.getResultSet();
	            result4.next();
	            lookingReligion = result4.getInt(1);
	        	
	        } 
	        catch (Exception e) 
	        {
	            e.printStackTrace();
	        }
			 
			int number = 0;
			try{
				
				SQLconnection sqlConn = new SQLconnection();
				 Connection con = sqlConn.createConnection(DB_USERNAME, DB_PASSWORD);
				String sql = ("SELECT COUNT(*) FROM linkup.profile_info WHERE religion = "+ lookingReligion + " AND gender = " + lookingGender +" AND age BETWEEN "+ lookingAgeLow +" AND " + lookingAgeHigh);
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
			int i = 0;
			try{ 
				SQLconnection sqlConn = new SQLconnection();
				 Connection con = sqlConn.createConnection(DB_USERNAME, DB_PASSWORD);
				//end here
				 stmt = con.prepareStatement("SELECT user_id FROM linkup.profile_info WHERE religion = "+ lookingReligion + " AND gender = " + lookingGender +" AND age BETWEEN "+ lookingAgeLow +" AND " + lookingAgeHigh);
		            stmt.executeQuery();
		            ResultSet result = stmt.getResultSet();
		            while(result.next()){
		            	//System.out.println("result is: " +result.getInt(1));
		            	match = result.getInt(1);
		            	matchs[i] = match;
		            	i++;
		            	System.out.println("match is: " + matchs[i]);
		            }
		        	
		        } 
		        catch (Exception e) 
		        {
		            e.printStackTrace();
		        } 
				
			
			/*try{ 
			SQLconnection sqlConn = new SQLconnection();
			 Connection con = sqlConn.createConnection(DB_USERNAME, DB_PASSWORD);
			//end here
			 stmt = con.prepareStatement("SELECT user_id FROM linkup.profile_info WHERE gender = " + lookingGender +" AND age BETWEEN "+ lookingAgeLow +" AND " + lookingAgeHigh);
	            stmt.executeQuery();
	            ResultSet result = stmt.getResultSet();
	            result.next();
	            match = result.getInt(1);
	        	
	        } 
	        catch (Exception e) 
	        {
	            e.printStackTrace();
	        } */
			String[] soulMates = new String[100];
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
			
			int k;
			String matchList = "";
			for(k = 0; k < number; k++){
				if(k == 0){
					matchList = matchList + soulMates[k];
				}else{
					matchList = matchList + ", " + soulMates[k];
				}
			}
			return matchList;
		}else{
			return "There are no users that fit the qualities that you are looking for at this time. :(";
		}
	
	}
}

