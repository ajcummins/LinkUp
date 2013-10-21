package edu.ycp.cs481.linkup.model.JUnitTests;



import edu.ycp.cs481.linkup.model.UserProfile;
import junit.framework.TestCase;

public class UserProfileJUnitTest extends TestCase {
	
	private UserProfile user;
	private UserProfile user2;
	
	protected void setUp() throws Exception {
		user = new UserProfile(11, "testing123", 2, 1, 23, "baptist", "to kill a mocking bird", "pee wee's big adventure", "led zeppelin", "im super cool", "kittens, long walks on the beach, sunsets", "rainbows", 2);
		user2 = new UserProfile(12, "testing456", 1, 2, 54, "catholic", "the sun also rises", "ferris buellers day off", "britney spears", "i am a college student", "", "people that snore", 4);
	}
	
	public void testGetUserid() throws Exception{
		assertEquals(11, user.getUserid());
		assertEquals(12, user2.getUserid());
	}
	
	public void testGetUsername() throws Exception{
		assertEquals("testing123", user.getUsername());
		assertEquals("testing456", user2.getUsername());
	}
	
	public void testGetLocation() throws Exception{
		assertEquals(2, user.getLocation());
		assertEquals(1, user2.getLocation());
	}
	public void testGetGender() throws Exception{
		assertEquals(1, user.getGender());
		assertEquals(2, user2.getGender());
	}
	
	public void testGetAge() throws Exception{
		assertEquals(23, user.getAge());
		assertEquals(54, user2.getAge());
	}
	
	public void testGetReligion() throws Exception{
		assertEquals("baptist", user.getReligion());
		assertEquals("catholic", user2.getReligion());
	}
	
	public void testGetBooks() throws Exception{
		assertEquals("to kill a mocking bird", user.getBooks());
		assertEquals("the sun also rises", user2.getBooks());
	}
	
	public void testGetMovies() throws Exception{
		assertEquals("pee wee's big adventure", user.getMovies());
		assertEquals("ferris buellers day off", user2.getMovies());
	}
	
	public void testGetMusic() throws Exception{
		assertEquals("led zeppelin", user.getMusic());
		assertEquals("britney spears", user2.getMusic());
	}
	
	public void testGetBasicInfo() throws Exception{
		assertEquals("im super cool", user.getBasic_Info());
		assertEquals("i am a college student", user2.getBasic_Info());
	}
	public void testGetLikes() throws Exception{
		assertEquals("kittens, long walks on the beach, sunsets", user.getLikes());
		assertEquals("", user2.getLikes());
	}
	public void testGetDislikes() throws Exception{
		assertEquals("rainbows", user.getDislikes());
		assertEquals("people that snore", user2.getDislikes());
	}
	public void testGetLookingFor() throws Exception{
		assertEquals(2, user.getLooking_For());
		assertEquals(4, user2.getLooking_For());
	}
	
///////////////////////////// test SETS	
	
	public void testSetUserid() throws Exception{
		user.setUserid(11);
		assertEquals(11, user.getUserid());
		
		user2.setUserid(12);
		assertEquals(12, user2.getUserid());
	}
	
	public void testSetUsername() throws Exception{
		user.setUsername("testing123");
		assertEquals("testing123", user.getUsername());
		
		user2.setUsername("testing456");
		assertEquals("testing456", user2.getUsername());
	
	}
	
	public void testSetLocation() throws Exception{
		
		user.setLocation(2);
		assertEquals(2, user.getLocation());
		
		user2.setLocation(1);
		assertEquals(1, user2.getLocation());
	}
		
	
	public void testSetGender() throws Exception{
		
		user.setGender(1);
		assertEquals(1, user.getGender());
		
		user2.setGender(2);
		assertEquals(2, user2.getGender());
	
	}
	
	public void testSetAge() throws Exception{
		user.setAge(23);
		assertEquals(23, user.getAge());
		
		user2.setAge(54);
		assertEquals(54, user2.getAge());
	;
	}
	
	public void testSetReligion() throws Exception{
		
		user.setReligion("baptist");
		assertEquals("baptist", user.getReligion());
		
		user2.setReligion("catholic");
		assertEquals("catholic", user2.getReligion());

	}
	
	public void testSetBooks() throws Exception{
		user.setBooks("to kill a mocking bird");
		assertEquals("to kill a mocking bird", user.getBooks());
		
		user2.setBooks("the sun also rises");
		assertEquals("the sun also rises", user2.getBooks());
	}
	
	public void testSetMovies() throws Exception{
		user.setMovies("pee wee's big adventure");
		assertEquals("pee wee's big adventure", user.getMovies());
		
		user2.setMovies("ferris buellers days off");
		assertEquals("ferris buellers days off", user2.getMovies());

	}
	
	public void testSetMusic() throws Exception{
		user.setMusic("led zeppelin");
		assertEquals("led zeppelin", user.getMusic());
		
		user2.setMusic("britney spears");
		assertEquals("britney spears", user2.getMusic());

	}
	
	public void testSetBasicInfo() throws Exception{
		
		user.setBasic_Info("im super cool");
		assertEquals("im super cool", user.getBasic_Info());
		
		user2.setBasic_Info("im a college student");
		assertEquals("im a college student", user2.getBasic_Info());
		
	}
	public void testSetLikes() throws Exception{
		
		user.setLikes("kittens, long walks on the beach, sunsets");
		assertEquals("kittens, long walks on the beach, sunsets", user.getLikes());
		
		user2.setLikes("");
		assertEquals("", user2.getLikes());
		
	
	}
	public void testSetDislikes() throws Exception{
		user.setDislikes("rainbows");
		assertEquals("rainbows", user.getDislikes());
		
		user2.setDislikes("people that snore");
		assertEquals("people that snore", user2.getDislikes());
		

	}
	public void testSetLookingFor() throws Exception{
		
		user.setLooking_For(2);
		assertEquals(2, user.getLooking_For());
		
		user2.setLooking_For(4);
		assertEquals(4, user2.getLooking_For());
		
	}
	
}
	
