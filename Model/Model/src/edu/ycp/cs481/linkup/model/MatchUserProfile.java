package edu.ycp.cs481.linkup.model;

public class MatchUserProfile {
	//private String name;
	
	public MatchUserProfile(int userid, int location2, int gender2, int age, String religion, String books, String movies, String music,
			String basic_info, String likes, String dislikes, String looking_for1, String first_name, String last_name ) {
		this.userid = userid;
		this.location = location2;
		this.gender = gender2;
		this.age = age;
		this.religion = religion;
		this.books = books;
		this.movies = movies;
		this.music = music;
		this.basic_info = basic_info;
		this.likes = likes;
		this.dislikes = dislikes;
		this.looking_for = looking_for1;
		this.firstName = first_name;
		this.lastName = last_name;
	
	}
	
	private String inUser;
	private int userid;
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
	private String looking_for;
	private String firstName;
	private String lastName;
	
	
	
	public void setUserid(int inUserid)
	{
		//userid = Integer.parseInt(user_id);
		userid = inUserid;
	}
	
	
	public void setLocation(int inLocation)
	{
		location = inLocation;
		//location = Integer.parseInt(inLocation);
	}
	
	public void setGender(int inGender)
	{
		gender = inGender;
		//gender = Integer.parseInt(inGender);
	}
	
	public void setAge(int inAge)
	{
		age = inAge;
		//age = Integer.parseInt(inAge);
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
		looking_for = inLooking_For;
		//looking_for = Integer.parseInt(inLooking_For);
	}
	
	
	public int getUserid()
	{
		return userid;
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
	public String getLooking_For()
	{
		return looking_for;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
}
