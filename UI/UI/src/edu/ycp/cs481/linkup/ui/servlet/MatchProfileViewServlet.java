package edu.ycp.cs481.linkup.ui.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.client.api.Request;

import com.mysql.jdbc.PreparedStatement;

import edu.ycp.cs481.linkup.controller.LoadUserProfile;
import edu.ycp.cs481.linkup.controller.ProfileController;
import edu.ycp.cs481.linkup.model.Path;
import edu.ycp.cs481.linkup.model.User;
import edu.ycp.cs481.linkup.model.UserProfile;
import edu.ycp.cs481.linkup.persistence.DBUtil;
import edu.ycp.cs481.linkup.persistence.PersistenceException;
import edu.ycp.cs481.linkup.persistence.SQLconnection;

public class MatchProfileViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	private static String DB_USERNAME = "ajcummins";
	private static String DB_PASSWORD = "root";
	private int userid;	
	private int Loginuserid;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		String location1 = null;
		String gender1 = null;
		String looking_for1 = null;
		String religion1 = null;


		Path urlPath1 = new Path(req.getPathInfo());
		Loginuserid = Integer.parseInt(urlPath1.getLoggedInUserIDFromPath());
		System.out.print("This is the user that is logged in: " + Loginuserid);

		//Get userid from the url passed
		Path urlPath = new Path(req.getPathInfo());
		userid = Integer.parseInt(urlPath.getMatchUserIDFromPath());
		System.out.print("This is the user that is rated in: " + userid);

		/*String[] comments = get_comment(userid, req, resp);
		String table = "";
		if(comments == null){
			req.setAttribute("comments", "No Comments at this time. :(");
			req.getRequestDispatcher("/_view/MatchProfile.jsp").forward(req, resp);
		}
		else{
			for(int i = 0; i < comments.length; i++){
				table = table + (i+1) + ") " + comments[i] + "      <input name='submit' value='View "+ comments[i] +" Profile' type='submit' /><br>";
			}
			req.setAttribute("comments", table);
			req.getRequestDispatcher("/_view/MatchProfile.jsp").forward(req, resp);
		}


*/
		java.sql.PreparedStatement stmt = null;
		String  religion =null; String books=null; String movies=null; String music=null;String basic_info=null;
		String likes=null; String dislikes=null; 
		int location=0; int gender=0;int age=0;int looking_for=0;
		String first_name = null; String last_name = null;


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


			// System.out.println("Location: " + location);
			//System.out.println("Location1: " + location1);




		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}


		//merrr
		System.out.println("Age: " + age);



		req.getSession().setAttribute("first_name", first_name);
		req.getSession().setAttribute("last_name", last_name);

		req.getSession().setAttribute("location", location1);


		req.getSession().setAttribute("gender", gender1);
		req.getSession().setAttribute("age", age);
		req.getSession().setAttribute("religion", religion1);
		req.getSession().setAttribute("books", books);
		req.getSession().setAttribute("music", music);
		req.getSession().setAttribute("movies", movies);
		req.getSession().setAttribute("basic_info", basic_info);
		req.getSession().setAttribute("likes", likes);
		req.getSession().setAttribute("dislikes", dislikes);
		req.getSession().setAttribute("looking_for", looking_for1);
		//req.getSession().setAttribute("comments", commentList);

		req.getRequestDispatcher("/_view/MatchProfile.jsp").forward(req, resp);

		req.getSession().setAttribute("user_id", userid);
		System.out.println("sdfjkfhsdjkh: " + userid);






	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//System.out.print("this is the user id:" + userid);

		System.out.print("\nthis is the user id:" + userid + "\n");
		String buttonAction = req.getParameter("submit");

		if(buttonAction.equals("Send Message")){ //go to the send message page
			resp.sendRedirect("sendMessage/"+ Loginuserid +"/" +userid);
		}
		if(buttonAction.equals("Rate a Date")){ //go to the user's messages page
			System.out.print("\ngoing to rate page:" + userid);
			resp.sendRedirect("Rating/" +  userid);
		}else{
			resp.sendRedirect("userMatch/"+ Loginuserid);
		}

	}

	String[] get_comment(int userid, HttpServletRequest req, HttpServletResponse resp)	{
		int NumComments = 0;
		int number=0;
		String [] commentList = new String[number];
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
			for(int i=0;i<number; i++){
				try{
					SQLconnection sqlConn = new SQLconnection();
					Connection con = sqlConn.createConnection(DB_USERNAME, DB_PASSWORD);	

					stmt = con.prepareStatement("SELECT comment FROM linkup.rating_system WHERE user_id = " + userid);
					stmt.executeQuery();
					ResultSet Cresult = stmt.getResultSet();
					Cresult.next();
					commentList[i] = Cresult.getString(1);
					System.out.println("Comment: " + commentList[i]);
				}catch(Exception e){
					e.printStackTrace();
				}
			}
			return commentList;
		}else{
			return null;
		}
	



	}

}