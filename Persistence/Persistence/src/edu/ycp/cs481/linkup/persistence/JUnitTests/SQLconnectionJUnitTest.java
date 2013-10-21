package edu.ycp.cs481.linkup.persistence.JUnitTests;

import java.sql.Connection;

import edu.ycp.cs481.linkup.persistence.SQLconnection;
import junit.framework.TestCase;

public class SQLconnectionJUnitTest extends TestCase{

		// Private Fields
		//private LookingFor user;
		private SQLconnection SQLcon;
		private java.sql.Connection conn;
		private static String dbUser = "ajcummins";
		private static String dbPass = "root";
		
		protected void setUp() throws Exception {
			SQLcon = new SQLconnection();
			conn = SQLcon.createConnection(dbUser, dbPass);
		}
		
		public void testCreateConnection() throws Exception{
			//Currently doesn't work...
			boolean test = conn.isValid(10);
			assertEquals(true,test);
		}
		
		public void testStopConnection() throws Exception{
			SQLcon.stopConnection();
			boolean test = conn.isClosed();
			assertEquals(true,test);
		}
}
