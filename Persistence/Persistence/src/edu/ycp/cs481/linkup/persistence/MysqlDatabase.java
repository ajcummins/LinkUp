package edu.ycp.cs481.linkup.persistence;

import java.security.Timestamp;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;

import edu.ycp.cs481.linkup.model.LookingFor;
import edu.ycp.cs481.linkup.model.MatchUserProfile;
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
				+ "\nreligion weight: " + inlooking.getReligionWeight()
				+ "\nseriousness weight: " + inlooking.getseriousnessWeight());
		try
		{
			SQLconnection sqlConn = new SQLconnection();
			Connection con = sqlConn.createConnection(DB_USERNAME, DB_PASSWORD);
			//using con create an entry into the appropriate table to add a user's looking for information
			stmt = con.prepareStatement("INSERT INTO linkup.looking_for(user_id,age_low"
					+ ",age_high,gender,religion_weight,seriousness_weight,state,children,married,pets,race,income,income_weight) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)");
			stmt.setInt(1, inlooking.getUserid());
			stmt.setInt(2, inlooking.getAgeLow());
			stmt.setInt(3, inlooking.getAgeHigh());
			stmt.setInt(4, inlooking.getGender());
			stmt.setInt(5, inlooking.getReligionWeight());
			stmt.setInt(6, inlooking.getseriousnessWeight());
			stmt.setInt(7, inlooking.getState());
			stmt.setInt(8, inlooking.getChildern());
			stmt.setInt(9, inlooking.getMarried());
			stmt.setInt(10, inlooking.getPets());
			stmt.setInt(11, inlooking.getRace());
			stmt.setInt(12, inlooking.getIncome());
			stmt.setInt(13, inlooking.getIncome_weight());
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
		//java.sql.PreparedStatement stmt2 = null;
		Date dob=null; //birth_date = null;

		try
		{
			SQLconnection sqlConn = new SQLconnection();
			Connection con = sqlConn.createConnection(DB_USERNAME, DB_PASSWORD);
			//using con create an entry into the appropriate table to add a user's looking for information



			stmt = con.prepareStatement("INSERT INTO linkup.profile_info(user_id,location, gender, age, religion"
					+ ",books, movies, music, basic_info, likes, dislikes, seriousness, children, married, pets, race, income) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
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
			stmt.setInt(12 , inProfile.getSeriousness());
			stmt.setInt(13 , inProfile.getChildren());
			stmt.setInt(14 , inProfile.getMarried());
			stmt.setInt(15 , inProfile.getPets());
			stmt.setInt(16 , inProfile.getRace());
			stmt.setInt(17 , inProfile.getIncome());
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
	/*public String find_match(Matching inMatching) throws PersistenceException
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
	}*/

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


	public String getMessages(int user_id)
			throws PersistenceException {
		java.sql.PreparedStatement stmt = null;
		int number = 0;
		String usernameFrom = "";
		String mess = "";
		String tableData = "";
		java.sql.Timestamp time = null;
		try{

			SQLconnection sqlConn = new SQLconnection();
			Connection con = sqlConn.createConnection(DB_USERNAME, DB_PASSWORD);
			String sql = ("SELECT COUNT(*) FROM linkup.match_messages WHERE user_to = " + user_id);
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
		if(number != 0){
			String[] fromUser = new String[number];
			String[] matchMess = new String[number];
			int i = 0;
			try{ 
				SQLconnection sqlConn = new SQLconnection();
				Connection con = sqlConn.createConnection(DB_USERNAME, DB_PASSWORD);
				stmt = con.prepareStatement("SELECT user_from, message FROM linkup.match_messages WHERE user_to = " + user_id + " ORDER BY time DESC");
				stmt.executeQuery();
				ResultSet result = stmt.getResultSet();
				while(result.next()){
					//System.out.println("result is: " +result.getInt(1));
					usernameFrom = result.getString(1);
					mess = result.getString(2);
					fromUser[i] = usernameFrom;
					matchMess[i] = mess;
					System.out.println("sender id: " + fromUser[i]);
					System.out.println("\nmessage is: " + matchMess[i]);
					i++;
				}

			} 
			catch (Exception e) 
			{
				e.printStackTrace();
			}
			int j;

			for(j = 0; j < number; j++){
				tableData = tableData + "<tr><td>" +fromUser[j]+"</td><td>"+matchMess[j]+"</td><td><input name='submit' value='Reply to "+ fromUser[j] +"' type='submit' /></td></tr>";
			}
			tableData = tableData + "</table>";
		}else{
			tableData = "<tr><td></td><td></td></tr></table>";
		}
		return tableData;
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

	@SuppressWarnings("resource")
	@Override
	public void insertMessages(Messages inMessage) throws PersistenceException {
		java.sql.PreparedStatement stmt = null;
		System.out.println("userid to" + inMessage.getToID()
				+ "\nuserid from: " + inMessage.getFromID()
				+ "\nMessage: " + inMessage.getMessage());
		try
		{
			SQLconnection sqlConn = new SQLconnection();
			Connection con = sqlConn.createConnection(DB_USERNAME, DB_PASSWORD);

			int messID = getMaxMessageId(con);
			String userName = null;

			stmt = con.prepareStatement("SELECT username FROM linkup.user WHERE user_id = " + inMessage.getFromID());
			stmt.executeQuery();
			ResultSet result = stmt.getResultSet();
			result.next();
			userName = result.getString(1);


			//using con create an entry into the appropriate table to add a user's looking for information
			stmt = con.prepareStatement("INSERT INTO linkup.match_messages(message_id,user_to"
					+ ",user_from,message) VALUES (?,?,?,?)");
			stmt.setInt(1, messID);
			stmt.setInt(2, inMessage.getToID());
			stmt.setString(3, userName);
			stmt.setString(4, inMessage.getMessage());
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

	private int getMaxMessageId(Connection conn) throws SQLException {
		java.sql.PreparedStatement stmt2 = null;
		ResultSet result = null;

		try {
			int messID;
			int max;
			stmt2 = conn.prepareStatement("SELECT MAX(message_id) FROM linkup.match_messages");
			stmt2.executeQuery();
			result = stmt2.getResultSet();
			result.next();
			max = result.getInt(1);
			messID = max + 1;
			return messID;
		} finally {
			DBUtil.closeQuietly(result);
			DBUtil.closeQuietly(stmt2);
		}
	}

	public int getMatchID(String buttonAction)
	{
		String[] array = buttonAction.split("");
		System.out.print("\nthis is the array:" + array);
		String matchUser = "";
		int i; 
		int matchid = -1;
		for(i = 0; i < array.length; i++){

			if(i < 6 || i > (array.length - 9)){
				//do nothing	
			}
			else{
				//System.out.print("\n" + array[i]);
				matchUser = matchUser + array[i];
			}
		}

		java.sql.PreparedStatement stmt = null;
		try 
		{   
			SQLconnection sqlConn = new SQLconnection();
			Connection con = sqlConn.createConnection(DB_USERNAME, DB_PASSWORD);	

			stmt = con.prepareStatement("SELECT user_id FROM linkup.user WHERE username = '" + matchUser + "';");
			stmt.executeQuery();
			ResultSet result = stmt.getResultSet();
			result.next();
			matchid = result.getInt(1);
		}catch (Exception e) 
		{
			e.printStackTrace();
		}
		System.out.print("\nthis is the usernaem:" + matchUser + "\n");
		System.out.print("\nthis is the User Id of Match:" + matchid + "\n");
		return matchid;
	}

	public int getReplyID(String buttonAction)
	{
		String[] array = buttonAction.split("");
		System.out.print("\nthis is the array:" + array);
		String matchUser = "";
		int i; 
		int matchid = -1;
		for(i = 0; i < array.length; i++){

			if(i < 10){
				//do nothing	
			}
			else{
				//System.out.print("\n" + array[i]);
				matchUser = matchUser + array[i];
			}
		}

		java.sql.PreparedStatement stmt = null;
		try 
		{   
			SQLconnection sqlConn = new SQLconnection();
			Connection con = sqlConn.createConnection(DB_USERNAME, DB_PASSWORD);	

			stmt = con.prepareStatement("SELECT user_id FROM linkup.user WHERE username = '" + matchUser + "';");
			stmt.executeQuery();
			ResultSet result = stmt.getResultSet();
			result.next();
			matchid = result.getInt(1);
		}catch (Exception e) 
		{
			e.printStackTrace();
		}
		System.out.print("\nthis is the usernaem:" + matchUser + "\n");
		System.out.print("\nthis is the User Id of Match:" + matchid + "\n");
		return matchid;
	}

	public String getUserName(int user_id){
		String username = "";
		java.sql.PreparedStatement stmt = null;
		try 
		{   
			SQLconnection sqlConn = new SQLconnection();
			Connection con = sqlConn.createConnection(DB_USERNAME, DB_PASSWORD);	

			stmt = con.prepareStatement("SELECT username FROM linkup.user WHERE user_id = " + user_id);
			stmt.executeQuery();
			ResultSet result = stmt.getResultSet();
			result.next();
			username = result.getString(1);
		}catch (Exception e) 
		{
			e.printStackTrace();
		}	
		return username;
	}

	public String[] get_comment(int userid)	{
		int NumComments = 0;
		int number=0;

		java.sql.PreparedStatement stmt = null;

		try 
		{   
			SQLconnection sqlConn = new SQLconnection();
			Connection con = sqlConn.createConnection(DB_USERNAME, DB_PASSWORD);	

			String sql = ("SELECT COUNT(*) FROM linkup.rating_system WHERE user_id = " + userid);
			java.sql.PreparedStatement prest = con.prepareStatement(sql);
			ResultSet rs = prest.executeQuery();
			while (rs.next()) {
				number = rs.getInt(1);
			}
			System.out.println("\nTHE NUMBER OF RATINGS FOR THIS USER ARE: " + number);
			//con.close();

		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		finally{

		}

		if(number!=0){
			String [] commentList = new String[number];
			int i = 0;
			String commen = "";
			//for(int i=0;i<number; i++){
			try{
				SQLconnection sqlConn = new SQLconnection();
				Connection con = sqlConn.createConnection(DB_USERNAME, DB_PASSWORD);	

				stmt = con.prepareStatement("SELECT comment FROM linkup.rating_system WHERE user_id = " + userid);
				stmt.executeQuery();
				ResultSet Cresult = stmt.getResultSet();
				while(Cresult.next()){
					commen = Cresult.getString(1);
					commentList[i] = commen;
					System.out.println("Comment: " + commentList[i]);
					i++;
				}
			}catch(Exception e){
				e.printStackTrace();
			}
			//}
			return commentList;
		}else{
			return null;
		}
	}

	public MatchUserProfile getMatchProfile(int userid){
		java.sql.PreparedStatement stmt = null;
		String  religion =null; String books=null; String movies=null; String music=null;String basic_info=null;
		String likes=null; String dislikes=null; 
		int location=0; int gender=0;int age=0;int looking_for=0;
		String first_name = null; String last_name = null;
		String location1 = null;
		String gender1 = null;
		String looking_for1 = null;
		String religion1 = null;
		String monthName = null; String day = null; String year = null; 
		String b_date = null;


		try 
		{   
			SQLconnection sqlConn = new SQLconnection();
			Connection con = sqlConn.createConnection(DB_USERNAME, DB_PASSWORD);	

			//GET F NAME!!!
			stmt = con.prepareStatement("SELECT first_name FROM linkup.user WHERE user_id = " + userid);
			stmt.executeQuery();
			ResultSet result12 = stmt.getResultSet();
			result12.next();
			first_name = result12.getString(1); //gets first name

			//GET L NAME!!!
			stmt = con.prepareStatement("SELECT last_name FROM linkup.user WHERE user_id = " + userid);
			stmt.executeQuery();
			ResultSet result13 = stmt.getResultSet();
			result13.next();
			last_name = result13.getString(1); //gets first name




			//LOCATION
			stmt = con.prepareStatement("SELECT location FROM linkup.profile_info WHERE user_id = " + userid);
			stmt.executeQuery();
			ResultSet result = stmt.getResultSet();
			result.next();
			location = result.getInt(1); //gets location = 2


			stmt = con.prepareStatement("SELECT location FROM linkup.location WHERE location_id = " + location);
			stmt.executeQuery();
			ResultSet result14 = stmt.getResultSet();
			result14.next();
			location1 = result14.getString(1);




			//GENDER
			stmt = con.prepareStatement("SELECT gender FROM linkup.profile_info WHERE user_id = " + userid);
			stmt.executeQuery();
			ResultSet result2 = stmt.getResultSet();
			result2.next();
			gender = result2.getInt(1);


			stmt = con.prepareStatement("SELECT gender FROM linkup.gender WHERE gender_id = " + gender);
			stmt.executeQuery();
			ResultSet result15 = stmt.getResultSet();
			result15.next();

			gender1 = result15.getString(1);





			//AGE
			stmt = con.prepareStatement("SELECT age FROM linkup.profile_info WHERE user_id = " + userid);
			stmt.executeQuery();
			ResultSet result3 = stmt.getResultSet();
			result3.next();
			age = result3.getInt(1);

			//dob
			stmt = con.prepareStatement("SELECT birth_date FROM linkup.user WHERE user_id = " + userid);
			stmt.executeQuery();
			ResultSet dob1 = stmt.getResultSet();
			dob1.next();
			b_date = dob1.getString(1);

			String dateParts[]= b_date.split("-");
			year = dateParts[0];
			String month = dateParts[1];
			day = dateParts[2];

			stmt = con.prepareStatement("SELECT month_name FROM linkup.bday_months WHERE month_date = " + month);
			stmt.executeQuery();
			ResultSet monthConv = stmt.getResultSet();
			monthConv.next();
			monthName = monthConv.getString(1);




			//RELIGION
			stmt = con.prepareStatement("SELECT religion FROM linkup.profile_info WHERE user_id = " + userid);
			stmt.executeQuery();
			ResultSet result4 = stmt.getResultSet();
			result4.next();
			religion = result4.getString(1);



			stmt = con.prepareStatement("SELECT religion FROM linkup.religion WHERE religion_id = " + religion);
			stmt.executeQuery();
			ResultSet result17 = stmt.getResultSet();
			result17.next();
			religion1 = result17.getString(1);

			//religion1 = religion;

			//BOOKS
			stmt = con.prepareStatement("SELECT books FROM linkup.profile_info WHERE user_id = " + userid);
			stmt.executeQuery();
			ResultSet result5 = stmt.getResultSet();
			result5.next();
			books = result5.getString(1);

			//MOVIEs
			stmt = con.prepareStatement("SELECT movies FROM linkup.profile_info WHERE user_id = " + userid);
			stmt.executeQuery();
			ResultSet result6 = stmt.getResultSet();
			result6.next();
			movies = result6.getString(1);

			//MUSIC
			stmt = con.prepareStatement("SELECT music FROM linkup.profile_info WHERE user_id = " + userid);
			stmt.executeQuery();
			ResultSet result7 = stmt.getResultSet();
			result7.next();
			music = result7.getString(1);

			//basic_info
			stmt = con.prepareStatement("SELECT basic_info FROM linkup.profile_info WHERE user_id = " + userid);
			stmt.executeQuery();
			ResultSet result8 = stmt.getResultSet();
			result8.next();
			basic_info = result8.getString(1);

			//LIKEs
			stmt = con.prepareStatement("SELECT likes FROM linkup.profile_info WHERE user_id = " + userid);
			stmt.executeQuery();
			ResultSet result9 = stmt.getResultSet();
			result9.next();
			likes = result9.getString(1);

			//dislikes
			stmt = con.prepareStatement("SELECT dislikes FROM linkup.profile_info WHERE user_id = " + userid);
			stmt.executeQuery();
			ResultSet result10 = stmt.getResultSet();
			result10.next();
			dislikes = result10.getString(1);

			//looking_for
			stmt = con.prepareStatement("SELECT looking_for FROM linkup.profile_info WHERE user_id = " + userid);
			stmt.executeQuery();
			ResultSet result11 = stmt.getResultSet();
			result11.next();
			looking_for = result11.getInt(1);

			stmt = con.prepareStatement("SELECT PInfoLookingFor FROM linkup.pinfolookingfor WHERE PInfoLookingFor_id = " + looking_for);
			stmt.executeQuery();
			ResultSet result16 = stmt.getResultSet();
			result16.next();
			looking_for1 = result16.getString(1);


		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		MatchUserProfile tempProfile = new MatchUserProfile(userid, location1, gender1, age, religion1, books, movies, music,
				basic_info, likes, dislikes, looking_for1, first_name, last_name);
		System.out.println("Age: " + age);
		return tempProfile;
	}

	@Override
	public void insertReplyMessages(Messages inMessage)
			throws PersistenceException {
		java.sql.PreparedStatement stmt = null;
		System.out.println("userid to" + inMessage.getToID()
				+ "\nuserid from: " + inMessage.getFromID()
				+ "\nMessage: " + inMessage.getMessage());
		try
		{
			SQLconnection sqlConn = new SQLconnection();
			Connection con = sqlConn.createConnection(DB_USERNAME, DB_PASSWORD);

			int messID = getMaxMessageId(con);
			String userName = null;

			stmt = con.prepareStatement("SELECT username FROM linkup.user WHERE user_id = " + inMessage.getFromID());
			stmt.executeQuery();
			ResultSet result = stmt.getResultSet();
			result.next();
			userName = result.getString(1);


			//using con create an entry into the appropriate table to add a user's looking for information
			stmt = con.prepareStatement("INSERT INTO linkup.match_messages(message_id,user_to"
					+ ",user_from,message) VALUES (?,?,?,?)");
			stmt.setInt(1, messID);
			stmt.setInt(2, inMessage.getToID());
			stmt.setString(3, userName);
			stmt.setString(4, inMessage.getMessage());
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

	@Override
	public String getSentMessages(int user_id) throws PersistenceException {
		java.sql.PreparedStatement stmt = null;
		int number = 0;
		int usernameFrom = -1;
		String mess = "";
		String tableData = "";
		java.sql.Timestamp time = null;

		String username = getUserName(user_id);

		try{

			SQLconnection sqlConn = new SQLconnection();
			Connection con = sqlConn.createConnection(DB_USERNAME, DB_PASSWORD);
			String sql = ("SELECT COUNT(*) FROM linkup.match_messages WHERE user_from = '" + username +"';");
			PreparedStatement prest = con.prepareStatement(sql);
			ResultSet rs = prest.executeQuery();
			while (rs.next()) {
				number = rs.getInt(1);
			}
			System.out.println("Number of sent records: " + number);
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			int newnum = 0;
		}
		if(number != 0){
			String[] toUser = new String[number];
			String[] matchMess = new String[number];
			int i = 0;
			try{ 
				SQLconnection sqlConn = new SQLconnection();
				Connection con = sqlConn.createConnection(DB_USERNAME, DB_PASSWORD);
				stmt = con.prepareStatement("SELECT user_to, message FROM linkup.match_messages WHERE user_from = '" + username + "' ORDER BY time DESC");
				stmt.executeQuery();
				ResultSet result = stmt.getResultSet();
				while(result.next()){
					//System.out.println("result is: " +result.getInt(1));
					usernameFrom = result.getInt(1);
					mess = result.getString(2);
					toUser[i] = getUserName(usernameFrom);
					matchMess[i] = mess;
					System.out.println("Sent to: " + toUser[i]);
					System.out.println("\nmessage is: " + matchMess[i]);
					i++;
				}

			} 
			catch (Exception e) 
			{
				e.printStackTrace();
			}
			int j;

			for(j = 0; j < number; j++){
				tableData = tableData + "<tr><td>" +toUser[j]+"</td><td>"+matchMess[j]+"</td></tr>";
			}
			tableData = tableData + "</table>";
		}else{
			tableData = "<tr><td></td><td></td></tr></table>";
		}
		return tableData;
	}

	@Override
	public String getDDLGender() throws PersistenceException {
		String ddl = "<select name='gender' style='width:110px'>";
		java.sql.PreparedStatement stmt = null;
		String gender;
		int i = 1;
		try{ 
			SQLconnection sqlConn = new SQLconnection();
			Connection con = sqlConn.createConnection(DB_USERNAME, DB_PASSWORD);
			stmt = con.prepareStatement("SELECT gender FROM linkup.gender");
			stmt.executeQuery();
			ResultSet result = stmt.getResultSet();
			while(result.next()){
				gender = result.getString(1);
				ddl = ddl + "<option name='gender' value = '"+ i +"' size='20'>" + gender +"</option>";
				i++;
			}

		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return ddl + "</select>";
	}

	@Override
	public String getDDLLocation() throws PersistenceException {
		String ddl = "<select name='location' style='width:110px'>";
		java.sql.PreparedStatement stmt = null;
		String location;
		int i = 1;
		try{ 
			SQLconnection sqlConn = new SQLconnection();
			Connection con = sqlConn.createConnection(DB_USERNAME, DB_PASSWORD);
			stmt = con.prepareStatement("SELECT location FROM linkup.location");
			stmt.executeQuery();
			ResultSet result = stmt.getResultSet();
			while(result.next()){
				location = result.getString(1);
				ddl = ddl + "<option name='location' value = '"+ i +"' size='20'>" + location +"</option>";
				i++;
			}

		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return ddl + "</select>";
	}

	@Override
	public String getDDLRace() throws PersistenceException {
		String ddl = "<select name='race' style='width:110px'>";
		java.sql.PreparedStatement stmt = null;
		String race;
		int i = 1;
		try{ 
			SQLconnection sqlConn = new SQLconnection();
			Connection con = sqlConn.createConnection(DB_USERNAME, DB_PASSWORD);
			stmt = con.prepareStatement("SELECT race FROM linkup.race");
			stmt.executeQuery();
			ResultSet result = stmt.getResultSet();
			while(result.next()){
				race = result.getString(1);
				ddl = ddl + "<option name='race' value = '"+ i +"' size='20'>" + race +"</option>";
				i++;
			}

		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return ddl + "</select>";
	}

	@Override
	public String getDDLReligion() throws PersistenceException {
		String ddl = "<select name='religion'>";
		java.sql.PreparedStatement stmt = null;
		String religion;
		int i = 1;
		try{ 
			SQLconnection sqlConn = new SQLconnection();
			Connection con = sqlConn.createConnection(DB_USERNAME, DB_PASSWORD);
			stmt = con.prepareStatement("SELECT religion FROM linkup.religion");
			stmt.executeQuery();
			ResultSet result = stmt.getResultSet();
			while(result.next()){
				religion = result.getString(1);
				ddl = ddl + "<option name='religion' value = '"+ i +"' size='20'>" + religion +"</option>";
				i++;
			}

		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return ddl + "</select>";
	}

	@Override
	public String getDDLWeight(String weight_type) throws PersistenceException {
		String ddl = "<select name='"+weight_type+"'>";
		java.sql.PreparedStatement stmt = null;
		String weight;
		int i = 1;
		try{ 
			SQLconnection sqlConn = new SQLconnection();
			Connection con = sqlConn.createConnection(DB_USERNAME, DB_PASSWORD);
			stmt = con.prepareStatement("SELECT weight FROM linkup.weight");
			stmt.executeQuery();
			ResultSet result = stmt.getResultSet();
			while(result.next()){
				weight = result.getString(1);
				ddl = ddl + "<option name='"+weight_type+"' value = '"+ i +"' size='20'>" + weight +"</option>";
				i++;
			}

		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return ddl + "</select>";
	}

	@Override
	public void update_user_looking_for(LookingFor inLooking)
			throws PersistenceException {
		java.sql.PreparedStatement stmt = null;
		System.out.println("userid" + inLooking.getUserid()
				+ "\nage low: " + inLooking.getAgeLow()
				+ "\nage high: " + inLooking.getAgeHigh()
				+ "\ngender: " + inLooking.getGender()
				+ "\nreligion weight: " + inLooking.getReligionWeight()
				+ "\nseriousness weight: " + inLooking.getseriousnessWeight());
		try
		{
			SQLconnection sqlConn = new SQLconnection();
			Connection con = sqlConn.createConnection(DB_USERNAME, DB_PASSWORD);
			//using con create an entry into the appropriate table to add a user's looking for information
			stmt = con.prepareStatement("UPDATE linkup.looking_for set age_low = ?, "
					+ "age_high = ?, gender = ?, religion_weight = ?, seriousness_weight = ?, state = ?, children = ?, married = ?, pets = ?, "
					+ "race = ?, income = ?, income_weight = ? WHERE user_id = "+inLooking.getUserid());
			stmt.setInt(1, inLooking.getAgeLow());
			stmt.setInt(2, inLooking.getAgeHigh());
			stmt.setInt(3, inLooking.getGender());
			stmt.setInt(4, inLooking.getReligionWeight());
			stmt.setInt(5, inLooking.getseriousnessWeight());
			stmt.setInt(6, inLooking.getState());
			stmt.setInt(7, inLooking.getChildern());
			stmt.setInt(8, inLooking.getMarried());
			stmt.setInt(9, inLooking.getPets());
			stmt.setInt(10, inLooking.getRace());
			stmt.setInt(11, inLooking.getIncome());
			stmt.setInt(12, inLooking.getIncome_weight());
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




	public static int getBirthdayAge(Connection con, int userid) throws SQLException{
		java.sql.PreparedStatement stmt2 = null;
		ResultSet result = null;
		String b_date = null; String MonthName=null; String day = null; String year = null; String month =null;
		int age = 0;

		try {

			//get birthdate
			//dob
			stmt2 = con.prepareStatement("SELECT birth_date FROM linkup.user WHERE user_id = " + userid); //userid
			stmt2.executeQuery();
			ResultSet dob = stmt2.getResultSet();
			dob.next();
			b_date = dob.getString(1);


			String dateParts[]= b_date.split("-");
			year = dateParts[0];
			String monthName = dateParts[1];
			day = dateParts[2];

			System.out.println("\nBEFORE bday year, month, day = " + year + " "+ monthName + " " +day);

			int Byear = Integer.parseInt(year);
			int Bmonth = Integer.parseInt(monthName);
			int Bday = Integer.parseInt(day);

			System.out.println("\nAFTER bday year, month, day = " + Byear + " "+ Bmonth + " " + Bday);

			//todays date
			Date date = null;
			Calendar cal = Calendar.getInstance();
			//cal.setTime(date);
			int year1 = cal.get(Calendar.YEAR);
			int month1 = cal.get(Calendar.MONTH);
			int day1 = cal.get(Calendar.DAY_OF_MONTH);
			month1 = month1+1;		
			//System.out.println("TODAYS DATE? = " + month1 + "-" + day1 + "-" + year1);

			/*int MYyear = 1990;
	    		int Mymonth = 06;
	    		int Myday = 14;
			 */
			int RealAge = year1 - Byear;
			if(month1 < Bmonth){
				RealAge --;
			}else if(month1 == Bmonth && day1 < Bday){
				RealAge --;
			}

			System.out.println("\nMY AGE!!! = "+ RealAge);







			return RealAge;
		} finally {
			DBUtil.closeQuietly(result);
			DBUtil.closeQuietly(stmt2);
		}
	}


	@Override
	public void edit_profile_info(UserProfile inProfile)
			throws PersistenceException {
		//determine next available userID
		java.sql.PreparedStatement stmt = null;
		//java.sql.PreparedStatement stmt2 = null;
		Date dob=null; //birth_date = null;

		try
		{
			SQLconnection sqlConn = new SQLconnection();
			Connection con = sqlConn.createConnection(DB_USERNAME, DB_PASSWORD);
			//using con create an entry into the appropriate table to add a user's looking for information

			
			////////
			
			///////////
			
			

			stmt = con.prepareStatement("UPDATE linkup.profile_info SET (location = '?', gender ='?', age ='?', religion ='?' "
					+ "music = '?', books = '?', movies = '?', basic_info = '?', likes = '?', dislikes = '?', seriousness ='?', children ='?', married ='?', pets ='?', race ='?', income ='?') WHERE user_id = "+inProfile.getUserid());
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
			stmt.setInt(12 , inProfile.getSeriousness());
			stmt.setInt(13 , inProfile.getChildren());
			stmt.setInt(14 , inProfile.getMarried());
			stmt.setInt(15 , inProfile.getPets());
			stmt.setInt(16 , inProfile.getRace());			
			stmt.setInt(17 , inProfile.getIncome());
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

	@Override
	public LookingFor getLooking_for(int userid) throws PersistenceException {
		int ageLow = -1;
		int ageHigh = -1;
		int gender = -1;
		int religionWeight = -1;
		int seriousnessWeight = -1;
		int state = -1;
		int children = -1;
		int married = -1;
		int pets = -1;
		int race = -1;
		int income = -1;
		int income_weight = -1;
		
		java.sql.PreparedStatement stmt = null;
		try 
		{   
			SQLconnection sqlConn = new SQLconnection();
			Connection con = sqlConn.createConnection(DB_USERNAME, DB_PASSWORD);	

			stmt = con.prepareStatement("SELECT age_low,age_high,gender,religion_weight,seriousness_weight,state,children,married,pets,race,income,income_weight FROM linkup.looking_for WHERE user_id = " + userid);
			stmt.executeQuery();
			ResultSet result = stmt.getResultSet();
			result.next();
			ageLow = result.getInt(1);
			ageHigh = result.getInt(2);
			gender = result.getInt(3);
			religionWeight = result.getInt(4);
			seriousnessWeight = result.getInt(5);
			state = result.getInt(6);
			children = result.getInt(7);
			married = result.getInt(8);
			pets = result.getInt(9);
			race = result.getInt(10);
			income = result.getInt(11);
			income_weight = result.getInt(12);
		}catch (Exception e) 
		{
			e.printStackTrace();
		}	
		LookingFor tempLooking = new LookingFor(userid, ageLow, ageHigh, gender, religionWeight, seriousnessWeight, state, children, married, pets, race, income, income_weight);
		
		return tempLooking;
	}

	public String[][] find_match(int userid)	{
		
		int lookingAgeLow = 0;
		int lookingAgeHigh = 100;
		int lookingGender = 1;
		int lookingReligion = -1;
		int ReligionOkay = -1;
		int lookingSeriousness = -1;
		int SeriousnessWeight = -1;
		int lookingState = -1;
		int StateOkay = -1;
		int lookingChildren = -1;
		int lookingMarried = -1;
		int lookingPets = -1;
		int lookingRace = -1;
		int RaceOkay = -1;
		int lookingIncome = -1;
		int IncomeWeight = -1;

		java.sql.PreparedStatement stmt = null;
		int match = -1;
		String soulMate = null;
		try 
		{   
			SQLconnection sqlConn = new SQLconnection();
			Connection con = sqlConn.createConnection(DB_USERNAME, DB_PASSWORD);	

			//start here

			stmt = con.prepareStatement("SELECT age_low, age_high, gender, religion_weight, seriousness_weight, state, children, married, pets, race, income, income_weight FROM linkup.looking_for WHERE user_id = " + userid);
			stmt.executeQuery();
			ResultSet result = stmt.getResultSet();
			result.next();
			lookingAgeLow = result.getInt(1);
			lookingAgeHigh = result.getInt(2);
			lookingGender = result.getInt(3);
			ReligionOkay = result.getInt(4);
			SeriousnessWeight = result.getInt(5);
			StateOkay = result.getInt(6);
			lookingChildren = result.getInt(7);
			lookingMarried = result.getInt(8);
			lookingPets = result.getInt(9);
			RaceOkay = result.getInt(10);
			lookingIncome = result.getInt(11);
			IncomeWeight = result.getInt(12);

			stmt = con.prepareStatement("SELECT religionID, seriousness, state, race FROM linkup.profile_info WHERE user_id = " + userid);
			stmt.executeQuery();
			ResultSet result1 = stmt.getResultSet();
			result1.next();
			lookingReligion = result1.getInt(1);
			lookingSeriousness = result1.getInt(2);
			lookingState = result1.getInt(3);
			lookingRace = result1.getInt(4);
			

		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		int seriousRange = 0;
		int seriousLow = 0;
		int seriousHigh = 0;
		
		seriousRange = 10 - SeriousnessWeight;
		seriousLow = lookingSeriousness - seriousRange;
		if(seriousLow < 0){
			seriousLow = 0;
		}
		seriousHigh = lookingSeriousness + seriousRange;
		if(seriousHigh > 10){
			seriousHigh = 10;
		}
		
		int incomeRange = 0;
		int incomeLow = 0;
		int incomeHigh = 0;
		
		incomeRange = 10 - IncomeWeight;
		incomeLow = lookingIncome - incomeRange;
		if(incomeLow < 0){
			incomeLow = 0;
		}
		incomeHigh = lookingIncome + incomeRange;
		if(incomeHigh > 10){
			incomeHigh = 10;
		}

		String ReligionStateRace = getStatement(ReligionOkay, StateOkay, RaceOkay, lookingReligion, lookingState, lookingRace, lookingChildren, lookingMarried, lookingPets);
		
		if(lookingChildren == 2){
			
		}
		
			int number = 0;
			try{

				SQLconnection sqlConn = new SQLconnection();
				Connection con = sqlConn.createConnection(DB_USERNAME, DB_PASSWORD);
				String sql = ("SELECT COUNT(*) FROM linkup.profile_info WHERE gender = " + lookingGender + ReligionStateRace 
						/*+ " AND children = " + lookingChildren + " AND married = " + lookingMarried 
						+ " AND pets = " + lookingPets*/
						+ " AND income BETWEEN " + incomeLow +" AND " + incomeHigh 
						+ " AND seriousness BETWEEN " + seriousLow +" AND " + seriousHigh 
						+ " AND age BETWEEN "+ lookingAgeLow +" AND " + lookingAgeHigh);
				PreparedStatement prest = con.prepareStatement(sql);
				ResultSet rs = prest.executeQuery();
				System.out.print(sql);
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
			
			if(number != 0){	
				String[][] matchs = new String[2][number];
				int seriousCal;
				int incomeCal;
				int i = 0;
				try{ 
					SQLconnection sqlConn = new SQLconnection();
					Connection con = sqlConn.createConnection(DB_USERNAME, DB_PASSWORD);
					//end here
					//stmt = con.prepareStatement("SELECT user_id FROM linkup.profile_info WHERE gender = " + lookingGender + ReligionStateRace 
					stmt = con.prepareStatement("SELECT user_id, seriousness, income FROM linkup.profile_info WHERE gender = " + lookingGender + ReligionStateRace
						/*+ " AND children = " + lookingChildren + " AND married = " + lookingMarried 
						+ " AND pets = " + lookingPets*/
						+ " AND income BETWEEN " + incomeLow +" AND " + incomeHigh 
						+ " AND seriousness BETWEEN " + seriousLow +" AND " + seriousHigh 
						+ " AND age BETWEEN "+ lookingAgeLow +" AND " + lookingAgeHigh);
					stmt.executeQuery();
					ResultSet result = stmt.getResultSet();
					while(result.next()){
						match = result.getInt(1);
						seriousCal = result.getInt(2);
						incomeCal = result.getInt(3);
						matchs[0][i] = getUserName(match);
						System.out.print("serious cal: " + seriousCal);
						System.out.print("\nincome cal: " + incomeCal);
						//calculate precentage of match
						double p = 9;
						double s = 0;
						if(lookingSeriousness > seriousCal){
							s = lookingSeriousness - seriousCal;
						}if(lookingSeriousness == seriousCal){
							s = seriousRange;
						}else{
							s = seriousCal - lookingSeriousness;
						}
						double ic = 0;
						if(lookingIncome > incomeCal){
							ic = lookingIncome - incomeCal;
						}if(lookingIncome == incomeCal){
							ic = incomeRange;
						}else{
							ic = incomeCal - lookingIncome;
						}
						System.out.println("\nseriousness range: " + s);
						System.out.println("income range: " + ic);
						p = ((p + ic + s) / (p + lookingIncome + lookingSeriousness)) * 100;
						matchs[1][i] = Integer.toString((int)p);
						
						System.out.println("match is: " + matchs[0][i]);
						i++;
					}
					return matchs;

				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				} 


				}else{
					return null;
				}
			return null;
	}
	
	public String getStatement(int ReligionOkay, int StateOkay, int RaceOkay, int religion, int state, int race, int lookingChildren, int lookingMarried, int lookingPets){
		String statement = null;
		if(ReligionOkay == 1 && StateOkay == 1){
			statement = "";
		}else if(ReligionOkay == 1 && StateOkay == 2){
			statement = " AND state = " + state;
		}else if(ReligionOkay == 2 && StateOkay == 1){
			statement = " AND religionID = " + religion;
		}else{
			statement = " AND state = " + state + " AND religionID = " + religion;
		}
		
		if(RaceOkay == 2){
			statement = statement + " AND race = " + race;
		}if(lookingChildren == 2){
			statement = statement + " AND children = 2";
		}if(lookingMarried == 2){
			statement = statement + " AND married = 2";
		}if(lookingPets == 2){
			statement = statement + " AND pets = 2";
		}
		return statement;
	}

}
