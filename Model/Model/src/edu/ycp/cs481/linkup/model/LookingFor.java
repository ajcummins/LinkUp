package edu.ycp.cs481.linkup.model;

public class LookingFor {

	
	private String inUser;
	private int userid;
	
	private int age;
	private int age_weight;
	
	private int gender;
	
	private String religion;
	private int religion_weight;
	
	private int seriousness;
	private int seriousness_weight;
	
	public LookingFor()
	{
		
	}
	
	public void setUserid(int inUserid)
	{
		userid = inUserid;
	}
	
	public void setAge(int inAge)
	{
		age = inAge;
	}
	
	public void setAge_Weight(int inAgeWeight)
	{
		age_weight = inAgeWeight;
	}
	
	public void setGender(int inGender)
	{
		gender = inGender;
	}
	
	public void setReligion(String inReligion)
	{
		religion = inReligion;
	}
	
	public void setReligionWeight(int inReligionWeight)
	{
		religion_weight = inReligionWeight;
	}
	
	public void setseriousness(int inseriousness)
	{
		seriousness = inseriousness;
	}
	
	public void setseriousnessWeight(int inseriousnessWeight)
	{
		seriousness_weight = inseriousnessWeight;
	}
	
	public int getUserid()
	{
		return userid;
	}
	
	public int getAge()
	{
		return age;
	}
	
	public int getAge_Weight()
	{
		return age_weight;
	}
	
	public int getGender()
	{
		return gender;
	}
	
	public String getReligion()
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
