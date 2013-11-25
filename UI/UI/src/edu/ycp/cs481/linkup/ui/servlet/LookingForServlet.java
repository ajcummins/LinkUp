package edu.ycp.cs481.linkup.ui.servlet;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.ycp.cs481.linkup.controller.CreateUserController;
import edu.ycp.cs481.linkup.controller.DropDownListController;
import edu.ycp.cs481.linkup.controller.LookingForController;
import edu.ycp.cs481.linkup.controller.MatchingController;
import edu.ycp.cs481.linkup.model.LookingFor;
import edu.ycp.cs481.linkup.model.Path;
import edu.ycp.cs481.linkup.model.User;
import edu.ycp.cs481.linkup.persistence.DuplicateUserException;
import edu.ycp.cs481.linkup.persistence.PersistenceException;

public class LookingForServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	int user_id;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		DropDownListController controller = new DropDownListController();
		String ddlGender = null;
		String ddlReligion = null;		
		try {
			ddlGender = controller.ddlGender();
			ddlReligion = controller.ddlReligion();
		} catch (PersistenceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		req.setAttribute("gender2", ddlGender);
		req.setAttribute("religion2", ddlReligion);
		
		req.getRequestDispatcher("/_view/lookingFor.jsp").forward(req, resp);
		
		
		HttpSession thisSession = req.getSession(true);
		User thisUser = (User) thisSession.getAttribute("loggedInUser");
		Boolean loggedIn = (Boolean) thisSession.getAttribute("login.isDone");
		
		if(loggedIn)
		{
			user_id = thisUser.getUserID();
		}
		else
		{
			//FIXME: Error User not logged in, need to fix w/ filters
		}
	}
	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
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
		
		// TODO: get looking for information, use a controller to create new user account, forward to view
		ageLow = Integer.parseInt(req.getParameter("age_low"));
		ageHigh = Integer.parseInt(req.getParameter("age_high"));
		gender = Integer.parseInt(req.getParameter("gender"));
		religionWeight = Integer.parseInt(req.getParameter("religion_weight"));
		seriousnessWeight = Integer.parseInt(req.getParameter("seriousness_weight"));
		state = Integer.parseInt(req.getParameter("location"));
		children = Integer.parseInt(req.getParameter("children"));
		married = Integer.parseInt(req.getParameter("married"));
		pets = Integer.parseInt(req.getParameter("pets"));
		race = Integer.parseInt(req.getParameter("race"));
		income = Integer.parseInt(req.getParameter("income"));
		income_weight = Integer.parseInt(req.getParameter("income_weight"));
		
		
		// Check if null 
		if(ageLow >= ageHigh || ageHigh <= ageLow || ageLow < 1 || ageHigh < 1 || user_id < 1 || gender < 1 || religionWeight < 1){
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
					+ "\nreligion weight: " + religionWeight
					+ "\nseriousness weight: " + seriousnessWeight
					+ "\nlocation : " + state
					+ "\nchildren : " + children
					+ "\nmarried : " + married
					+ "\npets : " + pets
					+ "\nrace : " + race
					+ "\nincome : " + income
					+ "\nincome_weight : " + income_weight
					);
			LookingFor tempLooking = new LookingFor(user_id, ageLow, ageHigh, gender, religionWeight, seriousnessWeight, state, children, married, pets, race, income, income_weight);


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
			
			
			HttpSession thisSession = req.getSession(true);
			thisSession.setAttribute("usersLookingFor",tempLooking);

			System.out.print("this is the user id:" + user_id);
			resp.sendRedirect("userProfile");	
			
		}
	}
}


