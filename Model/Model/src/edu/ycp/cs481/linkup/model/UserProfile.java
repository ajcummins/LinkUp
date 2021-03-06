package edu.ycp.cs481.linkup.model;

public class UserProfile {
	//private String name;
	
	public UserProfile(int userid, int location, int gender, int age, int religion, String books, String movies, String music,
			String basic_info, String likes, String dislikes, int race, int seriousness, int children, int married, int pets, int income) {
		this.userid = userid;
		this.location = location;
		this.gender = gender;
		this.age = age;
		this.religion = religion;
		this.books = books;
		this.movies = movies;
		this.music = music;
		this.basic_info = basic_info;
		this.likes = likes;
		this.dislikes = dislikes;
		this.race = race;
		this.seriousness = seriousness;
		this.children = children;
		this.married = married;
		this.pets = pets;
		this.income = income;
	
	}
	
	//commentttttttttttttttttttttttt
	
	private String inUser;
	private int userid;
	private int location;
	private int gender;
	private int age;
	private int religion;
	private String books;
	private String movies;
	private String  music;
	private String basic_info;
	private String likes;
	private String dislikes;
	private int race;
	private int seriousness;
	private int children;
	private int married;
	private int pets;
	private int income;
	
	
	
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
	
	public void setReligion(int inReligion)
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
	public void setRace(int inRace)
	{
		race = inRace;
		//looking_for = Integer.parseInt(inLooking_For);
	}
	
	
	public void setChidlren(int inChildren)
	{
		children = inChildren;
	}
	
	public void setMarried(int inMarried)
	{
		married = inMarried;
	}
	
	public void setPets(int inPets)
	{
		pets = inPets;
	}
	public void setIncome (int inIncome)
	{
		income = inIncome;
	}
	public void setSeriousness (int inSeriousness)
	{
		seriousness = inSeriousness;
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
	
	public int getReligion()
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
	public int getRace()
	{
		return race;
	}
	public int getChildren()
	{
		return children;
	}
	public int getMarried()
	{
		return married;
	}
	public int getPets()
	{
		return pets;
	}
	public int getIncome()
	{
		return income;
	}
	public int getSeriousness()
	{
		return seriousness;
	}
	
	
}
