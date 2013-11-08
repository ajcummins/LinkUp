package edu.ycp.cs481.linkup.model.JUnitTests;

import edu.ycp.cs481.linkup.model.Matching;
import edu.ycp.cs481.linkup.model.Messages;
import edu.ycp.cs481.linkup.model.Rating;
import junit.framework.TestCase;

public class RaitingJUnitTest extends TestCase{

	private Rating user;
	private Rating user2;
	
	protected void setUp() throws Exception {
		user = new Rating(1, 2, "hello");
		user2 = new Rating(2, 3, "bye");
	}
	
	public void getRatingID() throws Exception{
		assertEquals(1, user.getRatingID());
		assertEquals(2, user2.getRatingID());
	}
	
	public void testgetUserID() throws Exception{
		assertEquals(2, user.getUserID());
		assertEquals(3, user2.getUserID());
	}
	
	public void  testgetComment() throws Exception{
		assertEquals("hello", user. getComment());
		assertEquals("bye", user2. getComment());
	}
	
	public void testsetUserID() throws Exception {
		user.setUserID(1);
		assertEquals(1, user.getRatingID());
		
		user2.setUserID(2);
		assertEquals(2, user2.getRatingID());
	}
	
	public void testsetUsername() throws Exception {
		user.setUsername(2);
		assertEquals(2, user.getUserID());
		
		user2.setUsername(3);
		assertEquals(3, user2.getUserID());
	}
	
	public void testsetComment() throws Exception {
		user.setComment("hello");
		assertEquals("hello", user.getComment());
		
		user2.setComment("bye");
		assertEquals("bye", user2.getComment());
	}
	
}
