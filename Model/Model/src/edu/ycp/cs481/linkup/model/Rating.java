package edu.ycp.cs481.linkup.model;


public class Rating 
{

	private int rating_id;
	private int user_id;
	private String comment;

	
	public Rating()
	{
		
	}
	
	
	public Rating(int inRatingID, int inUserID, String inComment){
	
		rating_id = inRatingID;
		user_id = inUserID;
		comment = inComment;
		
	}




	public void setUserID(int inRatingID){
		rating_id = inRatingID;
	}
	
	public void setUsername(int inUserID){
		user_id = inUserID;
	}
	
	public void setComment(String inComment){
		comment = inComment;
	}
	
	public int getRatingID(){
		return rating_id;
	}
	
	public int getUserID(){
		return user_id;
	}
	
	public String getComment(){
		return comment;
	}
	

}
