package edu.ycp.cs481.linkup.model;

public class Matching {
private int userid;
	
	private int ageLow;
	private int ageHigh;
	
	private int gender;
	
	private String religion;
	private int religion_weight;
	
	private int seriousness;
	private int seriousness_weight;
	
	public Matching(int userid, int ageLow, int ageHigh, int gender)
	{
		this.userid = userid;
		this.ageLow = ageLow;
		this.ageHigh = ageHigh;
		this.gender = gender;
	}
	
	public void setUserid(int inUserid)
	{
		this.userid = inUserid;
	}
	
	public void setAgeLow(int inAgeLow)
	{
		this.ageLow = inAgeLow;
	}
	
	public void setAgeHigh(int inAgeHigh)
	{
		this.ageHigh = inAgeHigh;
	}
	
	public void setGender(int inGender)
	{
		this.gender = inGender;
	}
	
	public int getUserid()
	{
		return userid;
	}
	
	public int getAgeLow()
	{
		return ageLow;
	}
	
	public int getAgeHigh()
	{
		return ageHigh;
	}
	
	public int getGender()
	{
		return gender;
	}

}
