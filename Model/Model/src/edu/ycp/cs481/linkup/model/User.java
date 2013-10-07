package edu.ycp.cs481.linkup.model;


public class User 
{
	
	private String firstName;
	private String lastName;
	
	private int userID;
	private String username;
	private String password;
	
	private String email;
	
	private int birthMonth;
	private int birthDay;
	private int birthYear;
	
	private int secQuestion;
	private String secAnswer;
	
	public User()
	{
		
	}
	
	public void setUsername(String inUsername)
	{
		username = inUsername;
	}
	
	public void setPassword(String inPassword)
	{
		password = inPassword;
	}
	
	
	public String getUsername()
	{
		return username;
	}
	
	public String getPassword()
	{
		return password;
	}
	
	/*
	
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
		// create user code here
        		
	}
	
	
		
	// Getters for the variables
	public int getUserID()
	{
		return userID;
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
	public void setUserID(String inUser, String inPass)
	{
		//Using Login info get userID
		
	}
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
	*/
	
}
