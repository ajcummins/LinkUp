package edu.ycp.cs481.linkup.persistence;

import javax.swing.JOptionPane;

public class dialogSecurity {

	public dialogSecurity() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		JOptionPane.showMessageDialog(null, "Enter credentials for database access...");
		String username = JOptionPane.showInputDialog("Username: ");
		
		String password = JOptionPane.showInputDialog("Password: ");
		
		//System.out.println(username);  // test to see if stores user input
		//System.out.println(password);
		
		DBaccess(username, password);
		

	} 
	
	static boolean DBaccess(String username, String password) {
		if(username == "kfelton" && password == "linkup"){
			return true;
		}
		if(username == "ajcummins" && password == "root"){
			return true;
		}
		if(username == "mmoore" && password == "linkup"){
			return true;
		}
		return false;
	}

}
