package edu.ycp.cs481.linkup.model;


public class User 
{
	
	private String firstName;
	private String lastName;
	
	private int userID;
	private String username;
	private String password;
	
	private String email;
	
	private String dob;
	
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
	
	public void setFirstName(String inFName) {
		firstName = inFName;
		
	}

	public void setLastName(String inLName) {
		lastName = inLName;
		
	}

	public void setEmail(String inEmail) {
		email = inEmail;
		
	}

	public void setSecQues(String inSecQues) {
		secQuestion = Integer.getInteger(inSecQues);
		
	}

	public void setSecAns(String inSecAns) {
		secAnswer = inSecAns;
		
	}

	public void setDOB(String inDOB) {
		dob = inDOB;
		
	}
	
	public String getUsername()
	{
		return username;
	}
	
	public String getPassword()
	{
		return password;
	}
	
	public String getFirstName() {
		return firstName;
		
	}

	public String getLastName() {
		return lastName;
		
	}

	public String getEmail() {
		return email;
		
	}

	public int getSecQues() {
		return secQuestion;
		
	}

	public String getSecAns() {
		return secAnswer;
		
	}

	public String getDOB() {
		return dob;
		
	}
}
