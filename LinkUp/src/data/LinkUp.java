package data;

import java.sql.Date;
import java.util.Calendar;
import java.util.Scanner;

// I imagine this will be our main


//added comment
public class LinkUp {

	public static void main(String[] args) throws Exception {
		
		
		Date date = null;
		Calendar cal = Calendar.getInstance();
		//cal.setTime(date);
		int year1 = cal.get(Calendar.YEAR);
		int month1 = cal.get(Calendar.MONTH);
		int day1 = cal.get(Calendar.DAY_OF_MONTH);
		month1 = month1+1;		
		System.out.println("TODAYS DATE? = " + month1 + "-" + day1 + "-" + year1);
		
		int MYyear = 1990;
		int Mymonth = 06;
		int Myday = 14;
		
		int age = year1 - MYyear;
		if(month1 < Mymonth){
			age --;
		}else if(month1 == Mymonth && day1 < Myday){
			age --;
		}
		
		System.out.println("\nMY AGE!!! = "+ age);
		
		
		/*// Initiate Connection
		SQLconnection ourCon = new SQLconnection();
		
		// We'll have to figure out a better way of doing this in the future
		java.sql.Connection con = ourCon.createConnection("ajcummins", "root");
		
		User curUser = new User(con);
		Looking_for_testing looking_for = new Looking_for_testing();
		Profile_testing profile = new Profile_testing();
		
		//Hard-code the Input of User data to make sure it works...
		
		Scanner in = new Scanner(System.in);
		
		System.out.println("Welcome to LinkUp!!! \n");
		
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
		
		System.out.println("Lets create your profile.\n");
		
		profile.main(null);
		
		System.out.println("Now lets determine what kind of person you are looking for!\n");
		
		looking_for.main(null);
	}*/
	}
}
