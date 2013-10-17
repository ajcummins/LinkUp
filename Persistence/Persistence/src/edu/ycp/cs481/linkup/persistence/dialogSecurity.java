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
		
		boolean access = DBaccess(username, password);
		
		if(access == false){
			JOptionPane.showMessageDialog(null, "ACCESS DENIED!"); // if not correct, terminates
			//for(int i = 1; i < 4; i++){  //NEED TO WORK ON LOOP (ex: max 3 tries)
				//main(null);
			//}
			System.exit(0);
		}
	
		

	} 
	
	static boolean DBaccess(String username, String password) {
		if(username == "kfelton" && password == "linkup"){
			return true;
		}else if(username == "ajcummins" && password == "root"){
			return true;
		}else if(username == "mmoore" && password == "linkup"){
			return true;
		}else{
			return false;
		}
	}

}
