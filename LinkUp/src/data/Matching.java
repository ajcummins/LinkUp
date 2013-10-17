package data;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Matching {
	//Database connection
		private java.sql.Connection con;
		
		//User Constructor
		public Matching(java.sql.Connection inCon)
		{
			con = inCon;
		}
		
		//method to produce a match for the user
		public String find_match(int userid, int age_low, int age_high, int gender) throws Exception
		{
			
			int match_id = -1;
			String username = null;
			//determine next available userID
			java.sql.PreparedStatement stmt = null;
			
			 try 
		        {   
		        	stmt = con.prepareStatement("SELECT user_id FROM linkup.profile_info WHERE gender = " + gender +" AND age BETWEEN "+ age_low +" AND " + age_high);
		            stmt.executeQuery();
		            ResultSet result = stmt.getResultSet();
		            result.next();
		            match_id = result.getInt(1);
		        	
		        } 
		        catch (Exception e) 
		        {
		            e.printStackTrace();
		        } 
			if(match_id >= 0 ){
				 try 
			        {   
			        	stmt = con.prepareStatement("SELECT username FROM linkup.profile_info WHERE user_id = " + match_id);
			            stmt.executeQuery();
			            ResultSet result = stmt.getResultSet();
			            result.next();
			            username = result.getString(1);
			           return username;
			        	
			        } 
			        catch (Exception e) 
			        {
			            e.printStackTrace();
			        }
				 
				 
			}else{
				return "There are not matchs at this time.";
			}
			return "There are not matchs at this time.";
		}
}
