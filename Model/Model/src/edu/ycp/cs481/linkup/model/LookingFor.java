package edu.ycp.cs481.linkup.model;

public class LookingFor {

	
	//private String inUser;
	private int userid;
	
	private int ageLow;
	private int ageHigh;
	
	private int gender;
	
	private int religion;
	private int religion_weight;
	
	private int seriousness;
	private int seriousness_weight;
	
	public LookingFor(int userid, int ageLow, int ageHigh, int gender, int religion, int religion_weight, int seriousness, int seriousness_weight)
	{
		this.userid = userid;
		this.ageLow = ageLow;
		this.ageHigh = ageHigh;
		this.gender = gender;
		this.religion = religion;
		this.religion_weight = religion_weight;
		this.seriousness = seriousness;
		this.seriousness_weight = seriousness_weight;
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
	
	public void setReligion(int inReligion)
	{
		this.religion = inReligion;
	}
	
	public void setReligionWeight(int inReligionWeight)
	{
		this.religion_weight = inReligionWeight;
	}
	
	public void setseriousness(int inseriousness)
	{
		this.seriousness = inseriousness;
	}
	
	public void setseriousnessWeight(int inseriousnessWeight)
	{
		this.seriousness_weight = inseriousnessWeight;
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
	
	public int getReligion()
	{
		return religion;
	}
	
	public int getReligionWeight()
	{
		return religion_weight;
	}
	
	public int getseriousness()
	{
		return seriousness;
	}
	
	public int getseriousnessWeight()
	{
		return seriousness_weight;
	}

	
}