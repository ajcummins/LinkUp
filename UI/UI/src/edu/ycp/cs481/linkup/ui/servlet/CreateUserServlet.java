package edu.ycp.cs481.linkup.ui.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ycp.cs481.linkup.controller.CreateUserController;
import edu.ycp.cs481.linkup.model.User;
import edu.ycp.cs481.linkup.persistence.DuplicateUserException;
import edu.ycp.cs481.linkup.persistence.PersistenceException;


public class CreateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.getRequestDispatcher("/_view/createUser.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO: get username and password, use a controller to create new user account, forward to view
		String user = req.getParameter("username");
		String pass = req.getParameter("password");
		String confirmPass = req.getParameter("confirm_password");
		String firstname = req.getParameter("fname");
		String lastname = req.getParameter("lname");
		String dob = req.getParameter("dob");
		String email = req.getParameter("email");
		String secQues = req.getParameter("security_question");
		String secAns = req.getParameter("security_answer");

		
		// Check if null | Check if password and confirmpassword are the same | Validate that there is no other Usernames like this one
		if(user == null || pass == null || confirmPass == null || firstname == null || lastname == null || dob == null || email == null || secQues == null ||
				secAns == null )
		{
			//Some type of error
			req.setAttribute("error", "You have remaining Empty Fields");
			//throw new ServletException("You have remaining Empty Fields");
			req.getRequestDispatcher("/_view/createUser.jsp").forward(req, resp);
		}
		else if(!pass.equals(confirmPass))
		{
			req.setAttribute("password","");
			req.setAttribute("confirm_password","");
			req.setAttribute("error", "Your Passwords do not match");
			//throw new ServletException("Your Passwords do not match");
			req.getRequestDispatcher("/_view/createUser.jsp").forward(req, resp);
		}
		else
		{
			User tempUser = new User();
			tempUser.setUsername(user);
			tempUser.setPassword(pass);
			tempUser.setFirstName(firstname);
			tempUser.setLastName(lastname);
			tempUser.setDOB(dob);
			tempUser.setEmail(email);
			tempUser.setSecQues(secQues);
			tempUser.setSecAns(secAns);
			
			CreateUserController controller = new CreateUserController();
			try {
				controller.createUser(tempUser);
				req.setAttribute("info", "Successfully created user!");
				
				// redirect
				req.getRequestDispatcher("/_view/SetUpProfileInfo.jsp");
			} catch (DuplicateUserException e) {
				// User already exists
				req.setAttribute("error", "User " + user + " already exists");
			} catch (PersistenceException e) {
				throw new ServletException("Error communicating with database", e);
			}
			
			//req.getRequestDispatcher("/_view/createUser.jsp").forward(req, resp);
		}
	}
}
