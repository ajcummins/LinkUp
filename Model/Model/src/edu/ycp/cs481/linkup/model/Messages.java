package edu.ycp.cs481.linkup.model;

public class Messages {
	
	private int toID;
	private int fromID;
	private String message;
	
	
	public Messages(int intoID, int infromID, String inmessage)
	{
		this.setToID(intoID);
		this.setFromID(infromID);
		this.setMessage(inmessage);
	}


	public int getToID() {
		return toID;
	}


	public void setToID(int toID) {
		this.toID = toID;
	}


	public int getFromID() {
		return fromID;
	}


	public void setFromID(int fromID) {
		this.fromID = fromID;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}
	
	
}