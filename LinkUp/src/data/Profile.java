package data;


import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Profile {

	private java.sql.Connection con;
	
	//Constructor
	public Profile(java.sql.Connection inCon)
	{
		con = inCon;
	}

	
		//method add looking for information for a user who has not specified what they are looking for yet
		public void add_profile_info(int userid, String username, String location, String gender, int age, String religion, String books,
				String movies, String music, String basic_info, String likes, String dislikes, String looking_for) throws Exception
		{
			
			//determine next available userID
			java.sql.PreparedStatement stmt = null;
			
	        try
	        {
	        	//using con create an entry into the appropriate table to add a user's looking for information
	        	stmt = con.prepareStatement("INSERT INTO linkup.profile_info(user_id,username, location, gender, religion"
	        			+ ",books, movies, music, basic_info, likes, dislikes, looking_for) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)");
	            stmt.setInt(1, userid);
	            stmt.setString(2, username);
	            stmt.setString(3, location);
	            stmt.setString(4, gender);
	            stmt.setString(5, religion);
	            stmt.setString(6, books);
	            stmt.setString(7, movies);
	            stmt.setString(8, music);
	            stmt.setString(9, basic_info);
	            stmt.setString(10, likes);
	            stmt.setString(11, dislikes);
	            stmt.setString(12, looking_for);
	            stmt.executeUpdate();
	        }
	        catch (Exception e) 
	        {
	            e.printStackTrace();
	        }
	        finally
	        {
	        	if (stmt != null) {
	                try {
	                   stmt.close();
	                } catch (SQLException ex) {
	                }
	            }
	        }
	        		
		}
		
		
		//method for a user to update the information about what they are looking for
		/*public void update_profile_inf(int userid, String username, String location, String gender, int age, String religion, String books,
				String movies, String music, String basic_info, String likes, String dislikes, String looking_for) throws Exception
		{
			
			//determine next available userID
			java.sql.PreparedStatement stmt = null;
			
	        try
	        {
	        	//using con create an entry into the appropriate table to add a user's looking for information
	        	stmt = con.prepareStatement("UPDATE linkup.looking_for"
	        									+"SET (age = ?, age_weight = ?, sex = ?, religion = ?,"
	        									+ "religion_weight = ?, seriousness = ?, seriousness_weight = ?)"
	        									+ "WHERE user_id = ?;");
	        									//+ "WHERE user_id = '" + userid);
	            stmt.setInt(1, userid);
	            stmt.setString(2, username);
	            stmt.setString(3, location);
	            stmt.setString(4, gender);
	            stmt.setString(5, religion);
	            stmt.setString(6, books);
	            stmt.setString(7, movies);
	            stmt.setString(8, music);
	            stmt.setString(9, basic_info);
	            stmt.setString(10, likes);
	            stmt.setString(11, dislikes);
	            stmt.setString(12, looking_for);
	            stmt.executeUpdate();
	        }
	        catch (Exception e) 
	        {
	            e.printStackTrace();
	        }
	        finally
	        {
	        	if (stmt != null) {
	                try {
	                   stmt.close();
	                } catch (SQLException ex) {
	                }
	            }
	        }
	        		
		}
		
		
		*/
		

	}


