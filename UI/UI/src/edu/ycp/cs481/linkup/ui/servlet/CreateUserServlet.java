package edu.ycp.cs481.linkup.ui.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ycp.cs481.linkup.controller.CreateUserController;
import edu.ycp.cs481.linkup.model.User;
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
		// Check if null | Check if password and confirmpassword are the same | Validate that there is no other Usernames like this one
		if(user == null || pass == null)
		{
			//Some type of error
		}
		else
		{
			System.out.println("USER: " + user + " PASS: " + pass);
			User tempUser = new User();
			tempUser.setUsername(user);
			tempUser.setPassword(pass);
			CreateUserController controller = new CreateUserController();
			try {
				controller.createUser(tempUser);
			} catch (PersistenceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
}
