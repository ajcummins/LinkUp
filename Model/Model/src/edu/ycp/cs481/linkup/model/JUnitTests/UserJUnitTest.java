package edu.ycp.cs481.linkup.model.JUnitTests;

import edu.ycp.cs481.linkup.model.User;
import junit.framework.TestCase;

public class UserJUnitTest extends TestCase{

	private User user1;
	private User user2;
	
	protected void setUp() throws Exception {
		user1 = new User("first", "last", 1, "username", "password", "email", "1990", "1", "answer");
		user2 = new User("michelle", "moore", 2, "mmoore9", "hello", "mmoore9", "2013", "2", "dogs");
	}
	public void setGetUserID() throws Exception{
		user1.setUserID(1);
		assertEquals(1, user1.getUserID());
		
		user2.setUserID(2);
		assertEquals(2, user2.getUserID());	
	}
	
	public void setGetUserName() throws Exception{
		user1.setUsername("username");
		assertEquals("username", user1.getUsername());
		user2.setUsername("mmoore9");
		assertEquals("mmoore9", user2.getUsername());
	}
	
	public void setGetPassword() throws Exception{
		user1.setPassword("password");
		assertEquals("password", user1.getPassword());
		user2.setPassword("hello");
		assertEquals("hello", user2.getPassword());
	}
	
	public void setGetFirstName(){
		user1.setFirstName("first");
		assertEquals("first", user1.getFirstName());
		user2.setFirstName("michelle");
		assertEquals("michelle", user2.getFirstName());
	}
	
	public void setGetLastName(){
		user1.setLastName("last");
		assertEquals("last", user1.getLastName());
		user2.setLastName("moore");
		assertEquals("moore", user2.getLastName());
	}
	
	public void setGetEmail(){
		user1.setEmail("email");
		assertEquals("email", user1.getEmail());
		user2.setEmail("mmoore9");
		assertEquals("mmoore9", user2.getEmail());
	}
	
	public void setSecQues(){
		user1.setSecQues("1");
		assertEquals("1", user1.getSecQues());
		user2.setSecQues("2");
		assertEquals("2", user2.getSecQues());
	}
	
	public void setSecAns(){
		user1.setSecAns("answer");
		assertEquals("answer", user1.getSecQues());
		user2.setSecAns("dogs");
		assertEquals("dogs", user2.getSecQues());
	}
	
	public void testGetUserID() throws Exception{
		assertEquals(1, user1.getUserID());
		assertEquals(2, user2.getUserID());	
	}
	
	public void testGetUserName() throws Exception{
		assertEquals("username", user1.getUsername());
		assertEquals("mmoore9", user2.getUsername());
	}
	
	public void testGetPassword() throws Exception{
		assertEquals("password", user1.getPassword());
		assertEquals("hello", user2.getPassword());
	}
	
	public void testGetFirstName(){
		assertEquals("first", user1.getFirstName());
		assertEquals("michelle", user2.getFirstName());
	}
	
	public void testGetLastName(){
		assertEquals("last", user1.getLastName());
		assertEquals("moore", user2.getLastName());
	}
	
	public void testGetEmail(){
		assertEquals("email", user1.getEmail());
		assertEquals("mmoore9", user2.getEmail());
	}
	
	public void testSecQues(){
		assertEquals(1, user1.getSecQues());
		assertEquals(2, user2.getSecQues());
	}
	
/*	public void testSecAns(){
		assertEquals("answer", user1.getSecQues());
		assertEquals("dogs", user2.getSecQues());
	}*/
	
	
	
}
