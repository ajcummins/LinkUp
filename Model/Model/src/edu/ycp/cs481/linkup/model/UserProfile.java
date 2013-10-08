package edu.ycp.cs481.linkup.model;

public class UserProfile {
	//private String name;
	
	public UserProfile() {
		
	}
	
	//commentttttttttttttttttttttttt
	
	private String inUser;
	private int userid;
	private String username;
	private String location;
	private String gender;
	private int age;
	private String religion;
	private String books;
	private String movies;
	private String  music;
	private String basic_info;
	private String likes;
	private String dislikes;
	private String looking_for;
	
	
	
	public void setUserid(int inUserid)
	{
		userid = inUserid;
	}
	
	public void setUsername(String inUsername)
	{
		username = inUsername;
	}
	
	public void setAge_Weight(String inLocation)
	{
		location = inLocation;
	}
	
	public void setGender(String inGender)
	{
		gender = inGender;
	}
	
	public void setReligion(int inAge)
	{
		age = inAge;
	}
	
	public void setReligionWeight(String inReligion)
	{
		religion = inReligion;
	}
	
	public void setseriousness(String inBooks)
	{
		books = inBooks;
	}
	
	public void setMovies(String inMovies)
	{
		movies = inMovies;
	}
	public void setMusic(String inMusic)
	{
		music = inMusic;
	}
	public void setBasic_Info(String inBasic_Info)
	{
		basic_info = inBasic_Info;
	}
	public void setLikes(String inLikes)
	{
		likes = inLikes;
	}
	public void setDislikes(String inDislikes)
	{
		dislikes = inDislikes;
	}
	public void setLooking_For(String inLooking_For)
	{
		looking_for = inLooking_For;
	}
	
	
	public int getUserid()
	{
		return userid;
	}
	
	public String getUsername()
	{
		return username;
	}
	
	public String getLocation()
	{
		return location;
	}
	
	public String getGender()
	{
		return gender;
	}
	
	public int getAge()
	{
		return age;
	}
	
	public String getReligion()
	{
		return religion;
	}
	
	public String getBooks()
	{
		return books;
	}
	
	public String getMovies()
	{
		return movies;
	}
	public String getMusic()
	{
		return music;
	}
	public String getBasic_Info()
	{
		return basic_info;
	}
	public String getLikes()
	{
		return likes;
	}
	public String getDislikes()
	{
		return dislikes;
	}
	public String getLooking_For()
	{
		return looking_for;
	}
	
}
