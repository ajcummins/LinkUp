package edu.ycp.cs481.linkup.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import edu.ycp.cs481.linkup.model.LookingFor;
import edu.ycp.cs481.linkup.model.Matching;
import edu.ycp.cs481.linkup.model.Messages;
import edu.ycp.cs481.linkup.model.Rating;
import edu.ycp.cs481.linkup.model.User;
import edu.ycp.cs481.linkup.model.UserProfile;

public class MysqlDatabase implements IDatabase {

	
	
	//if else, boolean
	private static String DB_USERNAME = "ajcummins";
	private static String DB_PASSWORD = "root";
	
	public MysqlDatabase() {
		//this.setDatabaseCredentials();
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
	public int createUser(User inUser) throws PersistenceException {
		
		int userID = 0;
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
				
				return userID;
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
			System.out.println("userid" + inlooking.getUserid()
					+ "\nage low: " + inlooking.getAgeLow() 
					+ "\nage high: " + inlooking.getAgeHigh()
					+ "\ngender: " + inlooking.getGender()
					+ "\nreligion: " + inlooking.getReligion()
					+ "\nreligion weight: " + inlooking.getReligionWeight()
					+ "\nseriousness: " + inlooking.getseriousness()
					+ "\nseriousness weight: " + inlooking.getseriousnessWeight()
					+ "\nlocation: " + inlooking.getLocation());
	        try
	        {
	        	SQLconnection sqlConn = new SQLconnection();
				Connection con = sqlConn.createConnection(DB_USERNAME, DB_PASSWORD);
	        	//using con create an entry into the appropriate table to add a user's looking for information
	        	stmt = con.prepareStatement("INSERT INTO linkup.looking_for(user_id,age_low"
	        			+ ",age_high,gender,religion,religion_weight,seriousness,seriousness_weight, location) VALUES (?,?,?,?,?,?,?,?,?)");
	            stmt.setInt(1, inlooking.getUserid());
	            stmt.setInt(2, inlooking.getAgeLow());
	            stmt.setInt(3, inlooking.getAgeHigh());
	            stmt.setInt(4, inlooking.getGender());
	            stmt.setInt(5, inlooking.getReligion());
	            stmt.setInt(6, inlooking.getReligionWeight());
	            stmt.setInt(7, inlooking.getseriousness());
	            stmt.setInt(8, inlooking.getseriousnessWeight());
	            stmt.setInt(9, inlooking.getLocation());
	            stmt.executeUpdate();
	        }
	        catch (Exception e) 
	        {
	            e.printStackTrace();
	        }
	        finally
	        {
	        	DBUtil.closeQuietly(stmt);
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
		

			@Override
			public void add_profile_info(UserProfile inProfile)
					throws PersistenceException {
				//determine next available userID
				java.sql.PreparedStatement stmt = null;
				
		        try
		        {
		        	SQLconnection sqlConn = new SQLconnection();
					Connection con = sqlConn.createConnection(DB_USERNAME, DB_PASSWORD);
		        	//using con create an entry into the appropriate table to add a user's looking for information
		        	stmt = con.prepareStatement("INSERT INTO linkup.profile_info(user_id,location, gender, age, religion"
		        			+ ",books, movies, music, basic_info, likes, dislikes, looking_for) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)");
		            stmt.setInt(1, inProfile.getUserid());
		            stmt.setInt(2, inProfile.getLocation());
		            stmt.setInt(3, inProfile.getGender());
		            stmt.setInt(4, inProfile.getAge());
		            stmt.setInt(5, inProfile.getReligion());
		            stmt.setString(6, inProfile.getBooks());
		            stmt.setString(7, inProfile.getMovies());
		            stmt.setString(8, inProfile.getMusic());
		            stmt.setString(9, inProfile.getBasic_Info());
		            stmt.setString(10, inProfile.getLikes());
		            stmt.setString(11, inProfile.getDislikes());
		            stmt.setInt(12 , inProfile.getLooking_For());
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
			
			//method to produce a match for the user
			//public String find_match(int userid, int age_low, int age_high, int gender) throws Exception
			public String find_match(Matching inMatching) throws PersistenceException
			{
				
				int match_id = -1;
				String username = null;
				java.sql.PreparedStatement stmt = null;
				
				 try 
			        {   
					 SQLconnection sqlConn = new SQLconnection();
					 Connection con = sqlConn.createConnection(DB_USERNAME, DB_PASSWORD);	
					 stmt = con.prepareStatement("SELECT user_id FROM linkup.profile_info WHERE gender = " + inMatching.getGender() +" AND age BETWEEN "+ inMatching.getAgeLow() +" AND " + inMatching.getAgeHigh());
			            stmt.executeQuery();
			            ResultSet result = stmt.getResultSet();
			            result.next();
			            match_id = result.getInt(1);
			        	
			        } 
			        catch (Exception e) 
			        {
			            e.printStackTrace();
			        } 
				if(match_id >= 0 ){
					 try 
				        {   
				        	stmt = con.prepareStatement("SELECT username FROM linkup.profile_info WHERE user_id = " + match_id);
				            stmt.executeQuery();
				            ResultSet result = stmt.getResultSet();
				            result.next();
				            username = result.getString(1);
				           return username;
				        	
				        } 
				        catch (Exception e) 
				        {
				            e.printStackTrace();
				        }
					 
					 
				}else{
					return "There are not matchs at this time.";
				}
				return "There are not matchs at this time.";
			}

			@Override
			public User checkUserCredentials(String inUsername, String inPassword) throws PersistenceException
			{
				
				SQLconnection sqlConn = null;
				User loggedInUser = null;
				
				// Outer try/finally (to ensure SQLconnection is cleaned up properly)
				try {
					// Inner try/catch to handle SQLException
					try {
						// Try to create the Sql Connection
						sqlConn = new SQLconnection();
						Connection conn = sqlConn.createConnection(DB_USERNAME, DB_PASSWORD);
						// use the connection
						
						loggedInUser = getUser(conn,inUsername,inPassword);
						
						
						
		            }
		            catch(SQLException e)
		            {

						String state = e.getSQLState();
		            	if (state.startsWith("57"))
		            	{
		            		// Integrity violation: probably the user already exists
		            		throw new DuplicateUserException("TEST ERROR");
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
				
				return loggedInUser;
				
			}
			
						
			private User getUser(Connection conn, String inUsername, String inPassword) throws PersistenceException {
				java.sql.PreparedStatement stmt = null;
				ResultSet result = null;
				User user = new User();
				boolean validCredentials = false;
				
				try {
			    	stmt = conn.prepareStatement("SELECT * FROM linkup.user WHERE username = '" + inUsername 
			    								+ "' AND password = '" + inPassword + "'");
			    	stmt.executeQuery();
			    	result = stmt.getResultSet();
			    	
			    	
			    	result.next();
			    	user.setUserID(result.getInt("user_id"));
			    	user.setFirstName(result.getString("first_name"));
			    	user.setLastName(result.getString("last_name"));
			    	user.setEmail(result.getString("email"));
			    	user.setDOB(result.getString("birth_date"));
			    	user.setUsername(result.getString("username"));
			    	user.setSecQues(result.getString("security_question"));
			    	user.setSecAns(result.getString("security_answer"));
			    	user.setPassword(result.getString("password"));
			    	
			    	
				} catch (SQLException e) {
					String state = e.getSQLState();
					if(state.startsWith("S1000"))
					{
						throw new BadCredentialsException("User not found with these Credentials");
					}
					else
					{
						throw new PersistenceException("Error Checking User Credentials",e);
					}
				}
				finally {
					DBUtil.closeQuietly(result);
					DBUtil.closeQuietly(stmt);
				}
				
				return user;
			}

			
			//GET PROFILE INFO
			@Override
			public String[] get_profile_info(UserProfile inProfile)
					throws PersistenceException {
				//determine next available userID
				java.sql.PreparedStatement stmt = null;
				
				int location =0; int age = 0; int gender = 0; int looking_for = 0;
				String religion = null; String books = null; String movies =null; String music = null;
				String likes = null; String dislikes = null; String basic_info = null;
		        try
		        {
		        	SQLconnection sqlConn = new SQLconnection();
					Connection con = sqlConn.createConnection(DB_USERNAME, DB_PASSWORD);
		        	//using con create an entry into the appropriate table to add a user's looking for information
		        	stmt = con.prepareStatement("SELECT location, gender, religion"
		        			+ ",books, movies, music, basic_info, likes, dislikes, looking_for FROM linkup.profile_info WHERE (user_id='2')");
		        	stmt.executeQuery();
		        	ResultSet result = stmt.getResultSet();
		        	result.next();
		        	location = result.getInt(location);
		        	//System.out.println(location);
		        	//
		        	age = result.getInt(age);
		        	gender = result.getInt(gender);
		        	looking_for = result.getInt(looking_for);
		        	books = result.getString(books);
		        	music = result.getString(music);
		        	movies = result.getString(movies);
		        	basic_info = result.getString(basic_info);
		        	likes = result.getString(likes);
		        	dislikes = result.getString(dislikes);
		        	
		        	String age1 = String.valueOf(age);
		        	String gender1 = String.valueOf(gender);
		        	String location1 = String.valueOf(location);
		        	String looking_for1 = String.valueOf(looking_for);
		        	
		        	
		        	String[] ResultArray = new String[11];
		        	ResultArray[0] = books;
		        	ResultArray[1] = music;
		        	ResultArray[2] = movies;
		        	ResultArray[3] = basic_info;
		        	ResultArray[4] = likes;
		        	ResultArray[5] = dislikes;
		        	ResultArray[6] = age1;
		        	ResultArray[7] = location1;
		        	ResultArray[8] = gender1;
		         	ResultArray[9] = looking_for1;
		        	
		        	
		        	return ResultArray;
		        
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
				return null;
				
			}

			 @Override
             public Messages getMessages(Messages inMessage)
                             throws PersistenceException {
                     String[] noMessages = new String[1];
                     noMessages[0] = "No Messages at this time :(";
                     int toID = 1;//inMessage.getToID();
                             java.sql.PreparedStatement stmt = null;                                                                         
                             
                             //get number of messages for user
                             int number = 0;
                             try{
                                     
                                     SQLconnection sqlConn = new SQLconnection();
                                      Connection con = sqlConn.createConnection(DB_USERNAME, DB_PASSWORD);
                                     String sql = ("SELECT COUNT(*) FROM linkup.match_messages WHERE user_to = " + toID);
                                     PreparedStatement prest = con.prepareStatement(sql);
                              ResultSet rs = prest.executeQuery();
                              while (rs.next()) {
                              number = rs.getInt(1);
                              }
                              System.out.println("Number of records: " + number);
                              con.close();        
                             } catch (SQLException e) {
                                     // TODO Auto-generated catch block
                                     e.printStackTrace();
                             }finally{
                                      int newnum = 0;
                             }
                             
                             
                     
                     return null;
     }
			
		public void add_rating(Connection con, int rating_id, Rating inRating)throws SQLException {
				//determine next available userID
			
			//SQLconnection sqlConn = null;
				java.sql.PreparedStatement stmt = null;
				System.out.println("RATING ID IN ADD RATING : " + rating_id);
				//System.out.println("USER ID IN ADD RATING: "+ user_id);
				
		        try
		        {
		
		        	stmt = con.prepareStatement("INSERT INTO linkup.rating_system(rating_id,user_id,comment) VALUES (?,?,?)");
		            stmt.setInt(1, rating_id);
		            stmt.setString(2, "" +  inRating.getUserID());
		            stmt.setString(3, "" + inRating.getComment());
		            
		            stmt.executeUpdate();
		         
		        }finally {
					DBUtil.closeQuietly(stmt);
				}
		        
		        
			
		
			
		}
		
		public int createRating(Rating inRating) throws PersistenceException {
			
			int rating_id = 0;
			SQLconnection sqlConn = null;

			// Outer try/finally (to ensure SQLconnection is cleaned up properly)
			try {
				// Inner try/catch to handle SQLException
				try {
					// Try to create the Sql Connection
					sqlConn = new SQLconnection();
					Connection con = sqlConn.createConnection(DB_USERNAME, DB_PASSWORD);
					// use the connection

					// Find the Max UserID so we can add after it
					rating_id = getMaxRatingID(con); 
					System.out.println("CreateRating rating_id1: " + rating_id);
					// Using the newly found userId add the User
					add_rating(con, rating_id, inRating);
					
					System.out.println("CreateRating rating_id: " + rating_id);
					return rating_id;
				
	            }
	            catch(SQLException e)
	            {
	            	throw new PersistenceException("Error creating user", e);
	            }
			}
			finally {
				if (sqlConn != null) {
					sqlConn.stopConnection();
					
				}
			}
			
			
			
			
		}
		
		private int getMaxRatingID(Connection con) throws SQLException{
			java.sql.PreparedStatement stmt2 = null;
			ResultSet result = null;
			
			try {
				int rating_id;
				int max;
				stmt2 = con.prepareStatement("SELECT MAX(rating_id) FROM linkup.rating_system");
				stmt2.executeQuery();
				result = stmt2.getResultSet();
				result.next();
				max = result.getInt(1);
				rating_id = max + 1;
				System.out.println("MAX RATING ID: " + rating_id);
				return rating_id;
			} finally {
				DBUtil.closeQuietly(result);
				DBUtil.closeQuietly(stmt2);
			}
		}

		

			
		
}
