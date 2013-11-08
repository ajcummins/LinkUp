package edu.ycp.cs481.linkup.model.JUnitTests;

import edu.ycp.cs481.linkup.model.Matching;
import edu.ycp.cs481.linkup.model.Messages;
import junit.framework.TestCase;

public class MessagesJUnitTest extends TestCase{

	private Messages user;
	private Messages user2;
	
	protected void setUp() throws Exception {
		user = new Messages(1, 2, "hello");
		user2 = new Messages(2, 3, "bye");
	}
	
	public void testgetToID() throws Exception{
		assertEquals(1, user.getToID());
		assertEquals(2, user2.getToID());
	}
	
	public void testgetFromID() throws Exception{
		assertEquals(2, user.getFromID());
		assertEquals(3, user2.getFromID());
	}
	
	public void getMessage() throws Exception{
		assertEquals("hello", user.getMessage());
		assertEquals("bye", user2.getMessage());
	}
	
	public void testsetToID() throws Exception {
		user.setToID(1);
		assertEquals(1, user.getToID());
		
		user2.setToID(2);
		assertEquals(2, user2.getToID());
	}
	
	public void testsetFromID() throws Exception {
		user.setFromID(2);
		assertEquals(2, user.getFromID());
		
		user2.setFromID(3);
		assertEquals(3, user2.getFromID());
	}
	
	public void testsetMessage() throws Exception {
		user.setMessage("hello");
		assertEquals("hello", user.getMessage());
		
		user2.setMessage("bye");
		assertEquals("bye", user2.getMessage());
	}
	
}
