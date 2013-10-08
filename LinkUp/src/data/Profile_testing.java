package data;

import java.util.Scanner;

public class Profile_testing {

	public Profile_testing() {
		// TODO Auto-generated constructor stub
	}


		public static void main(String[] args) throws Exception {
			// Initiate Connection
			SQLconnection ourCon = new SQLconnection();
			
			// We'll have to figure out a better way of doing this in the future
			java.sql.Connection con = ourCon.createConnection("ajcummins", "root");
			
			//Looking_For matching = new Looking_For(con);
			Profile profile = new Profile(con);
			
			//Hard-code the Input of User data to make sure it works...
			
			Scanner in = new Scanner(System.in);
			
			//enter your user id
			System.out.println("Please enter your user id");
			int userid = in.nextInt();
			in.nextLine();//ignores whatever so they dont print out without entering - have to use after nextint
			
			//enter username
			System.out.println("Please enter your username");
			String username = in.nextLine();
			
			//enter your location
			System.out.println("Please enter your location");
			String location = in.nextLine();
			
			
			//enter age
			System.out.println("Please enter your age");
			int age = in.nextInt();
			in.nextLine(); //ignores whatever so they dont print out without entering
			
			//enter gender
			System.out.println("Please enter your gender");
			String gender = in.nextLine();
			
			//enter your religion
			System.out.println("Please enter your religion");
			String religion = in.nextLine();
			
			//enter books
			System.out.println("Please enter your books");
			String books = in.nextLine();
			//books = in.nextLine();
			
			//enter your movies
			System.out.println("Please enter your movies");
			String movies = in.nextLine();
			
			//enter music
			System.out.println("Please enter your music");
			String music = in.nextLine();
			
			//enter your basic info
			System.out.println("Please enter your basic info");
			String basic_info = in.nextLine();
			
			//enter likes
			System.out.println("Please enter your likes");
			String likes = in.nextLine();
			
			//enter your dislikes
			System.out.println("Please enter your dislikes");
			String dislikes = in.nextLine();
			
			//enter looking for
			System.out.println("Please enter what kind of romance you are looking for");
			String looking_for = in.nextLine();
			
			//updating user looking for method
			profile.add_profile_info(userid, username, location, gender, age,
					religion, books, movies, music, basic_info, likes, dislikes, looking_for);
			

	}

}
