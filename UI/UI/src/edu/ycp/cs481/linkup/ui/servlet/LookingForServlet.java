package edu.ycp.cs481.linkup.ui.servlet;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ycp.cs481.linkup.controller.LookingForController;
import edu.ycp.cs481.linkup.model.LookingFor;
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
		// TODO: get looking for information, use a controller to create new user account, forward to view
		int ageLow = Integer.parseInt(req.getParameter("age_low"));
		int ageHigh = Integer.parseInt(req.getParameter("age_high"));
		int gender = Integer.parseInt(req.getParameter("gender"));
		String religion = req.getParameter("religion");
		int religionWeight = Integer.parseInt(req.getParameter("religion_weight"));
		int seriousness = Integer.parseInt(req.getParameter("seriousness"));
		int seriousnessWeight = Integer.parseInt(req.getParameter("seriousness_weight"));
		
		
		// Check if null 
		if(ageLow < 0 || ageHigh < 0)
		{
			//Some type of error
		}
		else
		{
			System.out.println("age low: " + ageLow 
					+ "\nage high: " + ageHigh
					+ "\ngender: " + ageHigh
					+ "\nreligion: " + religion
					+ "\nreligion weight: " + religionWeight
					+ "\nseriousness: " + seriousness
					+ "\nseriousness weight: " + seriousnessWeight);
			LookingFor tempLooking = new LookingFor();
			tempLooking.setAgeLow(ageLow);
			tempLooking.setAgeHigh(ageHigh);
			tempLooking.setGender(gender);
			tempLooking.setReligion(religion);
			tempLooking.setReligionWeight(religionWeight);
			tempLooking.setseriousness(seriousness);
			tempLooking.setseriousnessWeight(seriousnessWeight);
			
			LookingForController controller = new LookingForController();
			try {
				controller.LookingFor(tempLooking);
			} catch (PersistenceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
}


