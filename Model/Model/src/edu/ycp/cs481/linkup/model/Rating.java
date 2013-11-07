package edu.ycp.cs481.linkup.model;


public class Rating 
{

	private int userID;
	private String username;
	private String comment;

	
	public Rating(){
		
	}
	
	public Rating(int inUserID, String inUsername, String inComment){
	
		userID = inUserID;
		username = inUsername;
		comment = inComment;
		
	}
	
	public void setUserID(int inUserID){
		userID = inUserID;
	}
	
	public void setUsername(String inUsername){
		username = inUsername;
	}
	
	public void setComment(String inComment){
		comment = inComment;
	}
	
	public int getUserID(){
		return userID;
	}
	
	public String getUsername(){
		return username;
	}
	
	public String getComment(){
		return comment;
	}
	

}
