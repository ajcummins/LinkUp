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
import edu.ycp.cs481.linkup.controller.ProfileViewController;
import edu.ycp.cs481.linkup.model.MatchUserProfile;
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

		java.sql.PreparedStatement stmt = null;
		 String monthName = null; String day = null; String year = null; 
			String b_date = null;
	 

		Path urlPath1 = new Path(req.getPathInfo());
		Loginuserid = Integer.parseInt(urlPath1.getLoggedInUserIDFromPath());
		System.out.print("This is the user that is logged in: " + Loginuserid);

		//Get userid from the url passed
		Path urlPath = new Path(req.getPathInfo());
		userid = Integer.parseInt(urlPath.getMatchUserIDFromPath());
		System.out.print("\nThis is the user that is rated in: " + userid);
		
		ProfileViewController controller = new ProfileViewController();
		String[] comments = null;
		try {
			comments = controller.ProfileComments(userid);
		} catch (PersistenceException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String table = "";
		if(comments == null){
			req.setAttribute("comments", "No Comments at this time. :(");
		}
		else{
			for(int i = 0; i < comments.length; i++){
				table = table + (i+1) + ") " + comments[i] + "      <br>";
			}
			req.setAttribute("comments", table);
		}

		
		MatchUserProfile profile = null;
		try {
			profile = controller.MatchProfileView(userid);
		} catch (PersistenceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		try 
		{   
			SQLconnection sqlConn = new SQLconnection();
			Connection con = sqlConn.createConnection(DB_USERNAME, DB_PASSWORD);	
			
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
			
			
			
			
			} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		
		
		req.getSession().setAttribute("first_name", profile.getFirstName());
		req.getSession().setAttribute("last_name", profile.getLastName());
		req.getSession().setAttribute("location", profile.getLocation());
		req.getSession().setAttribute("gender", profile.getGender());
		req.getSession().setAttribute("age", profile.getAge());
		req.getSession().setAttribute("religion", profile.getReligion());
		req.getSession().setAttribute("books", profile.getBooks());
		req.getSession().setAttribute("music", profile.getMusic());
		req.getSession().setAttribute("movies", profile.getMovies());
		req.getSession().setAttribute("basic_info", profile.getBasic_Info());
		req.getSession().setAttribute("likes", profile.getLikes());
		req.getSession().setAttribute("dislikes", profile.getDislikes());
		req.getSession().setAttribute("looking_for", profile.getLooking_For());
		
		req.getSession().setAttribute("month", monthName);
		req.getSession().setAttribute("day", day);
		req.getSession().setAttribute("year", year);

		req.getSession().setAttribute("user_id", userid);
		req.getRequestDispatcher("/_view/MatchProfile.jsp").forward(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		System.out.print("\nthis is the user id:" + userid + "\n");
		String buttonAction = req.getParameter("submit");

		if(buttonAction.equals("Send Message")){ //go to the send message page
			resp.sendRedirect("sendMessage/"+ Loginuserid +"/" +userid);
		}
		else if(buttonAction.equals("Rate a Date")){ //go to the user's messages page
			System.out.print("\ngoing to rate page:" + userid);
			resp.sendRedirect("Rating/" +  Loginuserid +"/" + userid);
		}else{
			System.out.print("error happening here");
			resp.sendRedirect("userMatch/"+ Loginuserid);
		}

	}

}