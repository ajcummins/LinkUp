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
	
	
	
	public void setUserid(String inUserid)
	{
		userid = Integer.parseInt(inUserid);
		//userid = inUseid;
	}
	
	public void setUsername(String inUsername)
	{
		username = inUsername;
	}
	
	public void setLocation(String inLocation)
	{
		//location = inLocation;
		location = Integer.parseInt(inLocation);
	}
	
	public void setGender(String inGender)
	{
		//gender = inGender;
		gender = Integer.parseInt(inGender);
	}
	
	public void setAge(String inAge)
	{
		//age = inAge;
		age = Integer.parseInt(inAge);
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
	public void setLooking_For(String inLooking_For)
	{
		//looking_for = inLooking_For;
		looking_for = Integer.parseInt(inLooking_For);
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
