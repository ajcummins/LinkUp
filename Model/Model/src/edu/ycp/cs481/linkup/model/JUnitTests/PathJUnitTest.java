package edu.ycp.cs481.linkup.model.JUnitTests;

import edu.ycp.cs481.linkup.model.Matching;
import edu.ycp.cs481.linkup.model.Messages;
import edu.ycp.cs481.linkup.model.Path;
import junit.framework.TestCase;

public class PathJUnitTest extends TestCase{

	private Path user;
	private Path user2;
	
	protected void setUp() throws Exception {
		user = new Path("hello/1");
		user2 = new Path("bye/2/3");
	}
	
	public void testsetPath() throws Exception {
		user.setPath("hello/1");
		assertEquals("hello/1", user.getPath());
		
		user2.setPath("bye/2/3");
		assertEquals("bye/2/3", user2.getPath());
	}
	
	public void testGetUserIDFromPath() throws Exception {
		assertEquals("1", user.getUserIDFromPath());
	}
	
	public void testGetLoggedInUserIDFromPath() throws Exception {
		assertEquals("2", user2.getLoggedInUserIDFromPath());
	}
	
	public void testGetMatchUserIDFromPath() throws Exception {
		assertEquals("3", user2.getMatchUserIDFromPath());
	}
		
}
