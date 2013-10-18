package edu.ycp.cs481.linkup.persistence;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import edu.ycp.cs481.linkup.model.LookingFor;
import edu.ycp.cs481.linkup.model.User;
import edu.ycp.cs481.linkup.model.UserProfile;

public class MysqlDatabase implements IDatabase {

	
	
	//if else, boolean
	private static String DB_USERNAME = "ajcummins";
	private static String DB_PASSWORD = "root";
	
	public MysqlDatabase() {
		this.setDatabaseCredentials();
	}
	
	@Override
	public UserProfile loadUserProfile(int profileId) throws PersistenceException {
		
		// SET DB_USERNAME/PASSWORD
		
		
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
		
		int userID = 0;
//		java.sql.PreparedStatement stmt = null;
		SQLconnection sqlConn = null;

		// Outer try/finally (to ensure SQLconnection is cleaned up properly)
		try {
			// Inner try/catch to handle SQLException
			try {
				// Try to create the Sql Connection
				sqlConn = new SQLconnection();
				Connection conn = sqlConn.createConnection(DB_USERNAME, DB_PASSWORD);
				// use the connection

				// Find the Max UserID so we can add after it
				userID = getMaxUserId(conn); 

				// Using the newly found userId add the User
				insertUser(conn, userID, inUser);
            }
            catch(SQLException e)
            {
            	String state = e.getSQLState();
            	if (state.startsWith("23"))
            	{
            		// Integrity violation: probably the user already exists
            		throw new DuplicateUserException("User " + inUser.getUsername() + " already exists");
            	}
            	else
            	{
            		throw new PersistenceException("Error creating user", e);
            	}
            }
		}
		finally {
			if (sqlConn != null) {
				sqlConn.stopConnection();
			}
		}
				
		
		
	}

	private int getMaxUserId(Connection conn) throws SQLException {
		java.sql.PreparedStatement stmt2 = null;
		ResultSet result = null;
		
		try {
			int userID;
			int max;
			stmt2 = conn.prepareStatement("SELECT MAX(user_id) FROM linkup.user");
			stmt2.executeQuery();
			result = stmt2.getResultSet();
			result.next();
			max = result.getInt(1);
			userID = max + 1;
			return userID;
		} finally {
			DBUtil.closeQuietly(result);
			DBUtil.closeQuietly(stmt2);
		}
	}

	private void insertUser(Connection conn, int userID, User inUser) throws SQLException {
		java.sql.PreparedStatement stmt = null;
		
		try {
	    	stmt = conn.prepareStatement("INSERT INTO linkup.user(user_id,first_name"
	    			+ ",last_name,email,birth_date,username,security_question,security_answer,password) VALUES (?,?,?,?,?,?,?,?,?)");
	        stmt.setString(1, ""+ userID);
	        stmt.setString(2, ""+ inUser.getFirstName());
	        stmt.setString(3, ""+ inUser.getLastName());
	        stmt.setString(4, ""+ inUser.getEmail());
	        stmt.setString(5, ""+ inUser.getDOB());
	        stmt.setString(6, ""+ inUser.getUsername());
	        stmt.setString(7, ""+ inUser.getSecQues());
	        stmt.setString(8, ""+ inUser.getSecAns());
	        stmt.setString(9, ""+ inUser.getPassword());
	        
	        stmt.executeUpdate();
		} finally {
			DBUtil.closeQuietly(stmt);
		}
	}
	
	
	//---------------------------------------------------------------------//
	//this is looking for insert statement for first time adding
	//Database connection
	//Checking for added java.sql.Connection con
		private java.sql.Connection con;
		@Override
		public void add_user_looking_for(LookingFor inlooking) throws PersistenceException {
			java.sql.PreparedStatement stmt = null;
			
	        try
	        {
	        	//using con create an entry into the appropriate table to add a user's looking for information
	        	stmt = con.prepareStatement("INSERT INTO linkup.looking_for(user_id,age_low"
	        			+ ",age_high,gender,religion,religion_weight,seriousness,seriousness_weight) VALUES (?,?,?,?,?,?,?,?)");
	            stmt.setInt(1, inlooking.getUserid());
	            stmt.setInt(2, inlooking.getAgeLow());
	            stmt.setInt(3, inlooking.getAgeHigh());
	            stmt.setInt(4, inlooking.getGender());
	            stmt.setString(5, inlooking.getReligion());
	            stmt.setInt(6, inlooking.getReligionWeight());
	            stmt.setInt(7, inlooking.getseriousness());
	            stmt.setInt(8, inlooking.getseriousnessWeight());
	            stmt.executeUpdate();
	        }
	        catch (Exception e) 
	        {
	            e.printStackTrace();
	        }
	        finally
	        {
	        	if (stmt != null) {
	                try {
	                   stmt.close();
	                } catch (SQLException ex) {
	                }
	            }
	        }
			
		}
		
		
		
		//-----------------------------------------------------------------//
		//generic update statements for different types of variables
		
		//update statement for an integer
		public void update_table_int(String inTableName, int inUserID, String inFieldName, int inValue){
			java.sql.PreparedStatement stmt = null;
			try
	        {
	        	//using con create an entry into the appropriate table to add a user's looking for information
	        	stmt = con.prepareStatement("UPDATE linkup." + inTableName 
	        										+ "SET " + inFieldName + " = ?"
	        										+ "WHERE user_id = ?");
	            stmt.setInt(1, inValue);
	            stmt.setInt(2, inUserID);
	            stmt.executeUpdate();
	        }
	        catch (Exception e) 
	        {
	            e.printStackTrace();
	        }
	        finally
	        {
	        	if (stmt != null) {
	                try {
	                   stmt.close();
	                } catch (SQLException ex) {
	                }
	            }
	        }
		}
		
		//update statement for a string
				public void update_table_string(String inTableName, int inUserID, String inFieldName, String inValue){
					java.sql.PreparedStatement stmt = null;
					try
			        {
			        	//using con create an entry into the appropriate table to add a user's looking for information
			        	stmt = con.prepareStatement("UPDATE linkup." + inTableName 
			        										+ "SET " + inFieldName + " = ?"
			        										+ "WHERE user_id = ?");
			            stmt.setString(1, inValue);
			            stmt.setInt(2, inUserID);
			            stmt.executeUpdate();
			        }
			        catch (Exception e) 
			        {
			            e.printStackTrace();
			        }
			        finally
			        {
			        	if (stmt != null) {
			                try {
			                   stmt.close();
			                } catch (SQLException ex) {
			                }
			            }
			        }
				}
				
		    //update statement for a date
			public void update_table_string(String inTableName, int inUserID, String inFieldName, Date inValue){
				java.sql.PreparedStatement stmt = null;
				try
		        {
		        	//using con create an entry into the appropriate table to add a user's looking for information
		        	stmt = con.prepareStatement("UPDATE linkup." + inTableName 
		        										+ "SET " + inFieldName + " = ?"
		        										+ "WHERE user_id = ?");
		            stmt.setDate(1, inValue);
		            stmt.setInt(2, inUserID);
		            stmt.executeUpdate();
		        }
		        catch (Exception e) 
		        {
		            e.printStackTrace();
		        }
		        finally
		        {
		        	if (stmt != null) {
		                try {
		                   stmt.close();
		                } catch (SQLException ex) {
		                }
		            }
		        }
			}
			
			public void setDatabaseCredentials()
			{
				//FIXME : use a javaswing window to retrieve the Database Username and Password from the user 
				//
				//DB_USERNAME = "";
				//DB_PASSWORD = "";
				dialogSecurity.main(null);
				
			}

			/*public void add_profile_info(int userid, String username, String location, String gender, int age, String religion, String books,
					String movies, String music, String basic_info, String likes, String dislikes, String looking_for) throws Exception
			{*/
				
		
		        		
			

			@Override
			public void add_profile_info(UserProfile inProfile)
					throws PersistenceException {
				//determine next available userID
				java.sql.PreparedStatement stmt = null;
				
		        try
		        {
		        	//using con create an entry into the appropriate table to add a user's looking for information
		        	stmt = con.prepareStatement("INSERT INTO linkup.profile_info(user_id,username, location, gender, religion"
		        			+ ",books, movies, music, basic_info, likes, dislikes, looking_for) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)");
		            stmt.setInt(1, inProfile.getUserid());
		            stmt.setString(2, inProfile.getUsername());
		            stmt.setInt(3, inProfile.getLocation());
		            stmt.setInt(4, inProfile.getGender());
		            stmt.setString(5, inProfile.getReligion());
		            stmt.setString(6, inProfile.getBooks());
		            stmt.setString(7, inProfile.getMovies());
		            stmt.setString(8, inProfile.getMusic());
		            stmt.setString(9, inProfile.getBasic_Info());
		            stmt.setString(10, inProfile.getLikes());
		            stmt.setString(11, inProfile.getDislikes());
		            stmt.setInt(12, inProfile.getLooking_For());
		            stmt.executeUpdate();
		        }
		        catch (Exception e) 
		        {
		            e.printStackTrace();
		        }
		        finally
		        {
		        	if (stmt != null) {
		                try {
		                   stmt.close();
		                } catch (SQLException ex) {
		                }
		            }
		        }
				// TODO Auto-generated method stub
				
			}
	

}
