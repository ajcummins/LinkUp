package edu.ycp.cs481.linkup.ui.servlet;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ycp.cs481.linkup.controller.CreateUserController;
import edu.ycp.cs481.linkup.controller.LookingForController;
import edu.ycp.cs481.linkup.model.LookingFor;
import edu.ycp.cs481.linkup.persistence.DuplicateUserException;
import edu.ycp.cs481.linkup.persistence.PersistenceException;

public class LookingForServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.getRequestDispatcher("/_view/lookingFor.jsp").forward(req, resp);
	}
	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		int userid = -1;
		int ageLow = -1;
		int ageHigh = -1;
		int gender = -1;
		int religionWeight = -1;
		int seriousness = -1;
		int seriousnessWeight = -1;
		
		// TODO: get looking for information, use a controller to create new user account, forward to view
		userid = Integer.parseInt(req.getParameter("user_id"));
		ageLow = Integer.parseInt(req.getParameter("age_low"));
		ageHigh = Integer.parseInt(req.getParameter("age_high"));
		gender = Integer.parseInt(req.getParameter("gender"));
		String religion = req.getParameter("religion");
		religionWeight = Integer.parseInt(req.getParameter("religion_weight"));
		seriousness = Integer.parseInt(req.getParameter("seriousness"));
		seriousnessWeight = Integer.parseInt(req.getParameter("seriousness_weight"));
		
		
		// Check if null 
		if(ageLow >= ageHigh || ageLow < 0 || ageHigh < 0 || userid < 0 || religion == null)
		{
			//Some type of error
			req.setAttribute("error", "You have remaining Empty Fields");
			//throw new ServletException("You have remaining Empty Fields");
			req.getRequestDispatcher("/_view/lookinFor.jsp").forward(req, resp);
		}
		else
		{
			System.out.println("age low: " + ageLow 
					+ "\nage high: " + ageHigh
					+ "\ngender: " + gender
					+ "\nreligion: " + religion
					+ "\nreligion weight: " + religionWeight
					+ "\nseriousness: " + seriousness
					+ "\nseriousness weight: " + seriousnessWeight);
			LookingFor tempLooking = new LookingFor(userid, ageLow, ageHigh, gender, religion, religionWeight, seriousness, seriousnessWeight);


			LookingForController controller = new LookingForController();
			try {
				//req.getRequestDispatcher("/_view/userMatch.jsp").forward(req, resp);
				controller.LookingFor(tempLooking);
				//req.setAttribute("info", "Successfully created user!");
			} catch (PersistenceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new ServletException("Error communicating with database", e);
			}

			req.getRequestDispatcher("/_view/userProfile.jsp").forward(req, resp);
			
		}
	}
}


