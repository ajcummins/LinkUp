package edu.ycp.cs481.linkup.model.JUnitTests;

import edu.ycp.cs481.linkup.model.LookingFor;
import junit.framework.TestCase;

public class lookingForJUnitTest extends TestCase {
	
	private LookingFor user;
	private LookingFor user2;
	
	protected void setUp() throws Exception {
		user = new LookingFor(1, 21, 30, 1, 1, 1, 1, 1, 1,1,1,1,1);
		user2 = new LookingFor(2, 22, 50, 2, 2, 2, 2, 2, 2,2,2,2,2);
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
	
	public void testGetState() throws Exception{
		assertEquals(1, user.getState());
		assertEquals(2, user2.getState());
	}
	
	public void testGetReligionWeight() throws Exception{
		assertEquals(1, user.getReligionWeight());
		assertEquals(2, user2.getReligionWeight());
	}
	
	public void testGetPets() throws Exception{
		assertEquals(1, user.getPets());
		assertEquals(2, user2.getPets());
	}
	
	public void testGetSeriousnessWeight() throws Exception{
		assertEquals(1, user.getseriousnessWeight());
		assertEquals(2, user2.getseriousnessWeight());
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
	
	public void testsetReligion() throws Exception {
		user.setState(1);
		assertEquals(1, user.getState());
		
		user2.setState(2);
		assertEquals(2, user2.getState());
	}
	
	public void testsetReligionWeight() throws Exception {
		user.setReligionWeight(1);
		assertEquals(1, user.getReligionWeight());
		
		user2.setReligionWeight(2);
		assertEquals(2, user2.getReligionWeight());
	}
	
	public void testsetSeriousness() throws Exception {
		user.setPets(1);
		assertEquals(1, user.getPets());
		
		user2.setPets(2);
		assertEquals(2, user2.getPets());
	}
	
	public void testsetSeriousnessWeight() throws Exception {
		user.setseriousnessWeight(1);
		assertEquals(1, user.getseriousnessWeight());
		
		user2.setseriousnessWeight(2);
		assertEquals(2, user2.getseriousnessWeight());
	}
}
