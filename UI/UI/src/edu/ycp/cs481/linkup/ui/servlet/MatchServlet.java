package edu.ycp.cs481.linkup.ui.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ycp.cs481.linkup.controller.MatchingController;
import edu.ycp.cs481.linkup.model.Matching;
import edu.ycp.cs481.linkup.persistence.PersistenceException;
import edu.ycp.cs481.linkup.persistence.SQLconnection;


public class MatchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static String DB_USERNAME = "ajcummins";
	private static String DB_PASSWORD = "root";
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		java.sql.PreparedStatement stmt = null;
		String soulMate = "fred";
		try 
        {   
		 SQLconnection sqlConn = new SQLconnection();
		 Connection con = sqlConn.createConnection(DB_USERNAME, DB_PASSWORD);	
		 stmt = con.prepareStatement("SELECT username FROM linkup.profile_info WHERE gender = " + 1 +" AND age BETWEEN "+ 21 +" AND " + 55);
            stmt.executeQuery();
            ResultSet result = stmt.getResultSet();
            result.next();
            soulMate = result.getString(1);
        	
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        } 
		resp.setContentType("text/html");
			 PrintWriter pw = resp.getWriter();
					pw.println("<!doctype html>");
					pw.println("<html>");
					pw.println("<head>");
					pw.println("<title>User Match</title>");
					pw.println("</head>");
					pw.println("<body>		");
					pw.println("<form action='/userMatch' method='POST'>");
					pw.println("<fieldset>");
					pw.println("<legend> Condulations!!!! </legend>");
					pw.println("<table>");
					pw.println("	<tr>");
					pw.println("Your Perfect Match: " + soulMate);
					pw.println("</tr>");
					pw.println("<tr>");
					pw.println("	<td></td>");
					pw.println("<td><input name='submit' value='profile' type='submit' /></td>");
					pw.println("</tr>");
					pw.println("</table>");
					pw.println("</fieldset>");
					pw.println("</form>");
					pw.println("</body>");
					pw.println("</html>");
	      
	}
	

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
			req.getRequestDispatcher("/_view/SetUpProfileInfo.jsp").forward(req, resp);
		}
}

