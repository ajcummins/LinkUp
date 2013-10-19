package edu.ycp.cs481.linkup.model;

import junit.framework.TestCase;

public class MatchingJUnitTest extends TestCase{

	private Matching user;
	private Matching user2;
	
	protected void setUp() throws Exception {
		user = new Matching(1, 21, 30, 1);
		user2 = new Matching(2, 22, 50, 2);
	}
	
	public void testGetUserid() throws Exception{
		assertEquals(1, user.getUserid());
		assertEquals(2, user2.getUserid());
	}
	
	public void testGetAgeLow() throws Exception{
		assertEquals(21, user.getAgeLow());
		assertEquals(22, user2.getAgeLow());
	}
	
	public void testGetAgeHigh() throws Exception{
		assertEquals(30, user.getAgeHigh());
		assertEquals(50, user2.getAgeHigh());
	}
	
	public void testGetGender() throws Exception{
		assertEquals(1, user.getGender());
		assertEquals(2, user2.getGender());
	}
	
	public void testsetUserid() throws Exception {
		user.setUserid(1);
		assertEquals(1, user.getUserid());
		
		user2.setUserid(2);
		assertEquals(2, user2.getUserid());
	}
	
	public void testsetAgeLow() throws Exception {
		user.setAgeLow(21);
		assertEquals(21, user.getAgeLow());
		
		user2.setAgeLow(22);
		assertEquals(22, user2.getAgeLow());
	}
	
	public void testsetAgeHigh() throws Exception {
		user.setAgeHigh(30);
		assertEquals(30, user.getAgeHigh());
		
		user2.setAgeHigh(50);
		assertEquals(50, user2.getAgeHigh());
	}
	
	public void testsetGender() throws Exception {
		user.setGender(1);
		assertEquals(1, user.getGender());
		
		user2.setAgeHigh(2);
		assertEquals(2, user2.getGender());
	}
}
