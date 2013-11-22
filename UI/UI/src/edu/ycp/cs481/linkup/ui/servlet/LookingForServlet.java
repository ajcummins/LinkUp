package edu.ycp.cs481.linkup.ui.servlet;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ycp.cs481.linkup.controller.CreateUserController;
import edu.ycp.cs481.linkup.controller.DropDownListController;
import edu.ycp.cs481.linkup.controller.LookingForController;
import edu.ycp.cs481.linkup.controller.MatchingController;
import edu.ycp.cs481.linkup.model.LookingFor;
import edu.ycp.cs481.linkup.model.Path;
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
		String ddlLooking = null;
		String ddlReligion = null;		
		try {
			ddlGender = controller.ddlGender();
			ddlLooking = controller.ddlLookingFor();
			ddlReligion = controller.ddlReligion();
		} catch (PersistenceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		req.setAttribute("gender2", ddlGender);
		req.setAttribute("religion2", ddlReligion);
		req.setAttribute("lookingfor2", ddlLooking);
		
		req.getRequestDispatcher("/_view/lookingFor.jsp").forward(req, resp);
		
		//Get userid from the url passed
				Path urlPath = new Path(req.getPathInfo());
				System.out.println("Path = " + req.getPathInfo());
				user_id = Integer.parseInt(urlPath.getUserIDFromPath());
	}
	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		int ageLow = -1;
		int ageHigh = -1;
		int gender = -1;
		int religionWeight = -1;
		int seriousness = -1;
		int seriousnessWeight = -1;
		int religion = -1;
		int location = -1;
		
		// TODO: get looking for information, use a controller to create new user account, forward to view
		ageLow = Integer.parseInt(req.getParameter("age_low"));
		ageHigh = Integer.parseInt(req.getParameter("age_high"));
		gender = Integer.parseInt(req.getParameter("gender"));
		religion = Integer.parseInt(req.getParameter("religion"));
		religionWeight = Integer.parseInt(req.getParameter("religion_weight"));
		seriousness = Integer.parseInt(req.getParameter("seriousness"));
		seriousnessWeight = Integer.parseInt(req.getParameter("seriousness_weight"));
		location = Integer.parseInt(req.getParameter("location"));
		
		
		// Check if null 
		if(ageLow >= ageHigh || ageHigh <= ageLow || ageLow < 1 || ageHigh < 1 || user_id < 1 || religion < 1 || location < 1){
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
					+ "\nseriousness weight: " + seriousnessWeight
					+ "\nlocation : " + location);
			LookingFor tempLooking = new LookingFor(user_id, ageLow, ageHigh, gender, religion, religionWeight, seriousness, seriousnessWeight, location);


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

			System.out.print("this is the user id:" + user_id);
			resp.sendRedirect("userProfile/"+ user_id);	
			
		}
	}
}


