package edu.ycp.cs481.linkup.persistence;

import java.sql.Connection;
import java.sql.ResultSet;

import edu.ycp.cs481.linkup.model.User;
import edu.ycp.cs481.linkup.model.UserProfile;

public class MysqlDatabase implements IDatabase {

	
	// FIXME: add a Java Swing Window that when initiating the website it asks for credentials to the database.
	private static final String DB_USERNAME = "ajcummins";
	private static final String DB_PASSWORD = "root";
	
	public MysqlDatabase() {
	}
	
	@Override
	public UserProfile loadUserProfile(int profileId) throws PersistenceException {
		// TODO Auto-generated method stub
		
		try {
			SQLconnection sqlConn = new SQLconnection();
			Connection conn = sqlConn.createConnection(DB_USERNAME, DB_PASSWORD);
			try {
				// use the connection
			} finally {
				sqlConn.stopConnection();
			}
			
			return null;
		} catch (Exception e) {
			throw new PersistenceException("Error loading user profile", e);
		}
	}

	@Override
	public void createUser(User inUser) throws PersistenceException {
		
		int max = 0;
		int userID = 0;
		java.sql.PreparedStatement stmt = null;
		SQLconnection sqlConn = null;
		
		// Try to create the Sql Connection
		try {
			sqlConn = new SQLconnection();
			Connection conn = sqlConn.createConnection(DB_USERNAME, DB_PASSWORD);
			
			// Find the Max UserID so we can add after it
			try {
				// use the connection
				stmt = conn.prepareStatement("SELECT MAX(user_id) FROM linkup.user");
	            stmt.executeQuery();
	            ResultSet result = stmt.getResultSet();
	            result.next();
	            max = result.getInt(1);
	            userID = max + 1; 
	            // Using the newly found userId add the User
	            try
	            {
	            	//using con create an entry into the appropriate table to add a user
	            	//FIXME : add the other proper fields here
	            	stmt = conn.prepareStatement("INSERT INTO linkup.user(user_id,first_name"
	            			+ ",last_name,email,birth_date,username,security_question,security_answer,password) VALUES (?,?,?,?,?,?,?,?,?)");
	                stmt.setString(1, ""+ userID);
	                stmt.setString(2, "fName"+ userID);
	                stmt.setString(3, "lName"+ userID);
	                stmt.setString(4, "email"+ userID);
	                stmt.setString(5, ""+userID+"-"+userID+"-"+userID);
	                stmt.setString(6, ""+ inUser.getUsername());
	                stmt.setString(7, ""+ userID);
	                stmt.setString(8, "Sec_Answer"+ userID);
	                stmt.setString(9, ""+ inUser.getPassword());
	                
	                stmt.executeUpdate();
	            }
	            catch(Exception e)
	            {
	            	throw new PersistenceException("Error Creating User", e);
	            }
	            finally
	            {
	            	if (stmt != null) {
	                    try {
	                       stmt.close();
	                    } catch (Exception e) {
	                    	throw new PersistenceException("Error Closing Statement",e);
	                    }
	                }
	            }
			}
			catch (Exception e) {
				throw new PersistenceException("Error Excecuting Create User Query",e);
			}
			
			
		} catch (Exception e) {
			throw new PersistenceException("Error loading user profile", e);
		}
		finally {
			sqlConn.stopConnection();
		}
				
		
		
	}

	

}
