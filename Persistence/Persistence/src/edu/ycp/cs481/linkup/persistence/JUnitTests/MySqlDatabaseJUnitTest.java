package edu.ycp.cs481.linkup.persistence.JUnitTests;

import java.sql.Connection;

import edu.ycp.cs481.linkup.persistence.MysqlDatabase;
import edu.ycp.cs481.linkup.persistence.SQLconnection;
import junit.framework.TestCase;

public class MySqlDatabaseJUnitTest extends TestCase {

	// Private Fields
	private SQLconnection SQLcon;
	private java.sql.Connection conn;
	private static String dbUser = "ajcummins";
	private static String dbPass = "root";
	private static String testUser = "ajcummins";
	private static String testPass = "password";
	
	protected void setUp() throws Exception {
		conn = SQLcon.createConnection(dbUser, dbPass);
	}
	
	public void testGetUser() throws Exception{
		/*
		MysqlDatabase.getUser(conn, testUser, testPass);
		assertEquals(1, user.getUserid());
		assertEquals(2, user2.getUserid());
		*/
	}
}
