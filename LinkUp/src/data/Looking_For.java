package data;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Looking_For {
	
	
	//Database connection
	private java.sql.Connection con;
	
	//User Constructor
	public Looking_For(java.sql.Connection inCon)
	{
		con = inCon;
	}
	
	//method add looking for information for a user who has not specified what they are looking for yet
	public void add_user_looking_for(int userid, int age_low, int age_high, int gender,
			String religion, int religion_weight, int seriousness, int seriousness_weight) throws Exception
	{
		
		//determine next available userID
		java.sql.PreparedStatement stmt = null;
		
        try
        {
        	//using con create an entry into the appropriate table to add a user's looking for information
        	stmt = con.prepareStatement("INSERT INTO linkup.looking_for(user_id,age_low"
        			+ ",age_high,gender,religion,religion_weight,seriousness,seriousness_weight) VALUES (?,?,?,?,?,?,?,?)");
            stmt.setInt(1, userid);
            stmt.setInt(2, age_low);
            stmt.setInt(3, age_high);
            stmt.setInt(4, gender);
            stmt.setString(5, religion);
            stmt.setInt(6, religion_weight);
            stmt.setInt(7, seriousness);
            stmt.setInt(8, seriousness_weight);
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
	public void update_user_looking_for(int userid, int age, int age_weight, int sex,
			String religion, int religion_weight, int seriousness, int seriousness_weight) throws Exception
	{
		
		//determine next available userID
		java.sql.PreparedStatement stmt = null;
		
        try
        {
        	//using con create an entry into the appropriate table to add a user's looking for information
        	stmt = con.prepareStatement("UPDATE linkup.looking_for"
        									+"SET (age = ?, age_weight = ?, gender = ?, religion = ?,"
        									+ "religion_weight = ?, seriousness = ?, seriousness_weight = ?)"
        									+ "WHERE user_id = ?;");
        									//+ "WHERE user_id = '" + userid);
            stmt.setInt(1, age);
            stmt.setInt(2, age_weight);
            stmt.setInt(3, sex);
            stmt.setString(4, religion);
            stmt.setInt(5, religion_weight);
            stmt.setInt(6, seriousness);
            stmt.setInt(7, seriousness_weight);
            stmt.setInt(8,  userid);
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
	
	// Getters for the variables
		public int getUserID(String inUser, String inPass)
		{
			//Using userID
			return 0;
		}
		public String get_age()
		{
			// Use con to get from Database
			return null;
		}
		public String get_age_weight()
		{
			// Use con to get from Database
			return null;
		}
		public String get_sex()
		{
			// Use con to get from Database
			return null;
		}
		public String get_religion()
		{
			// Use con to get from Database
			return null;
		}
		public String get_religion_weight()
		{
			// Use con to get from Database
			return null;
		}
		public String get_seriousness()
		{
			// Use con to get from Database
			return null;
		}
		public String get_seriousness_weight()
		{
			// Use con to get from Database
			return null;
		}
		
		
		
		// Setters for the variables
		public void set_user_id(int userid)
		{
			//Using con create a statement and update the user's Username via userID
		}
		public void set_age(int age)
		{
			//Using con create a statement and update the user's Password via userID
		}
		public void set_age_weight(int age_weight)
		{
			//Using con create a statement and update the user's SecQ via userID
		}
		public void set_religion(String religion)
		{
			//Using con create a statement and update the user's SecA via userID
		}
		public void set_religion_weight(int religion_weight)
		{
			//Using con create a statement and update the user's Email via userID
		}
		public void set_seriousness(int seriousness)
		{
			//Using con create a statement and update the user's Email via userID
		}
		public void set_seriousness_weight(int seriousness_weight)
		{
			//Using con create a statement and update the user's Email via userID
		}
	
}
