package data;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class User 
{
	
	//NOT USING PRIVATE VARS, JUST USE DATABASE VALUES OTHERWISE IT'S DOUBLE WORK
	
	//Except for userId since it doesn't change and will be used for getting all other information
	private int userID;
	
	private Profile userProfile;
	//Database connection
	private java.sql.Connection con;
	
	//User Constructor
	public User(java.sql.Connection inCon)
	{
		con = inCon;
	}
	
	// Date of Birth Class
	public class DOB
	{
		private int month;
		private int day;
		private int year;
		
		public DOB(int inMon, int inDay, int inYear)
		{
			month = inMon;
			day = inDay;
			year = inYear;
		}
	}
	
	public void createUser(String inFName,String inLName, String inUser, String inPass, String inSecQ, String inSecA, String inEmail, String inMonth, String inDay, String inYear) throws Exception
	{
		//determine next available userID
		java.sql.PreparedStatement stmt = null;
		int max = 0;
		
        try 
        {   
        	stmt = con.prepareStatement("SELECT MAX(user_id) FROM account_registration");
            stmt.executeQuery();
            ResultSet result = stmt.getResultSet();
            result.next();
            max = result.getInt(1);
            userID = max + 1; 
        	
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        } 
        
        try
        {
        	//using con create an entry into the appropriate table to add a user
        	stmt = con.prepareStatement("INSERT INTO linkup.account_registration(user_id,first_name"
        			+ ",last_name,email,birth_date,username,security_question,security_answer,password) VALUES (?,?,?,?,?,?,?,?,?)");
            stmt.setString(1, ""+ userID);
            stmt.setString(2, inFName);
            stmt.setString(3, inLName);
            stmt.setString(4, inEmail);
            stmt.setString(5, ""+inYear+"-"+inMonth+"-"+inDay);
            stmt.setString(6, inUser);
            stmt.setString(7, inSecQ);
            stmt.setString(8, inSecA);
            stmt.setString(9, inPass);
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
		//Using Login info get userID
		
		return 0;
	}
	public String getUsername()
	{
		// Use con to get from Database
		return null;
	}
	public String getPass()
	{
		// Use con to get from Database
		return null;
	}
	public String getSecQ()
	{
		// Use con to get from Database
		return null;
	}
	public String getSecA()
	{
		// Use con to get from Database
		return null;
	}
	public String getEmail()
	{
		// Use con to get from Database
		return null;
	}
	
	
	// Setters for the variables
	public void setUsername(String inUser)
	{
		//Using con create a statement and update the user's Username via userID
	}
	public void setPass(String inPass)
	{
		//Using con create a statement and update the user's Password via userID
	}
	public void setSecQ(String inSecQ)
	{
		//Using con create a statement and update the user's SecQ via userID
	}
	public void setSecA(String inSecA)
	{
		//Using con create a statement and update the user's SecA via userID
	}
	public void setEmail(String inEmail)
	{
		//Using con create a statement and update the user's Email via userID
	}
	
}
