package edu.ycp.cs481.linkup.model;

public class UserProfile {
	//private String name;
	
	public UserProfile() {
		
	}
	
	//commentttttttttttttttttttttttt
	
	private String inUser;
	private int userid;
	private String username;
	private int location;
	private int gender;
	private int age;
	private String religion;
	private String books;
	private String movies;
	private String  music;
	private String basic_info;
	private String likes;
	private String dislikes;
	private int looking_for;
	
	
	
	public void setUserid(int inUserid)
	{
		userid = inUserid;
	}
	
	public void setUsername(String inUsername)
	{
		username = inUsername;
	}
	
	public void setLocation(int inLocation)
	{
		location = inLocation;
	}
	
	public void setGender(int inGender)
	{
		gender = inGender;
	}
	
	public void setAge(int inAge)
	{
		age = inAge;
	}
	
	public void setReligion(String inReligion)
	{
		religion = inReligion;
	}
	
	public void setBooks(String inBooks)
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
	public void setLooking_For(int inLooking_For)
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
	
	public int getLocation()
	{
		return location;
	}
	
	public int getGender()
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
	public int getLooking_For()
	{
		return looking_for;
	}
	
}
