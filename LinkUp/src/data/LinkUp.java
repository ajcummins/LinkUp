package data;

import java.util.Scanner;

// I imagine this will be our main

public class LinkUp {

	public static void main(String[] args) throws Exception {
		// Initiate Connection
		SQLconnection ourCon = new SQLconnection();
		
		// We'll have to figure out a better way of doing this in the future
		java.sql.Connection con = ourCon.createConnection("ajcummins", "root");
		
		User curUser = new User(con);
		
		//Hard-code the Input of User data to make sure it works...
		
		Scanner in = new Scanner(System.in);
		
		System.out.println("Please Input Your First Name");
		String fName = in.next();
		
		System.out.println("Please Input Your Last Name");
		String lName = in.next();
		
		System.out.println("Please Input Your Username");
		String username = in.next();
		
		System.out.println("Please Input Your Password");
		String password = in.next();
		
		System.out.println("Please Input Your Security Question Choice");
		String secQ = in.next();
		
		System.out.println("Please Input Your Security Answer");
		String secA = in.next();
		
		System.out.println("Please Input Your Email");
		String email = in.next();
		
		System.out.println("Please Input Your DOB Month [Enter] "
				+ "Day [Enter] Year [Enter]");
		String mon = in.next();
		String day = in.next();
		String year = in.next();
		
		
		curUser.createUser(fName, lName, username, password,
				secQ, secA, email, mon, day, year);
		
		ourCon.stopConnection();
	}

}
