package data;
import java.util.Scanner;

public class Looking_for_testing {


	public static void main(String[] args) throws Exception {
		// Initiate Connection
		SQLconnection ourCon = new SQLconnection();
		
		// We'll have to figure out a better way of doing this in the future
		java.sql.Connection con = ourCon.createConnection("ajcummins", "root");
		
		Looking_For looking = new Looking_For(con);
		Matching matching = new Matching(con);
		
		//Hard-code the Input of User data to make sure it works...
		
		Scanner in = new Scanner(System.in);
		
		//enter your user id
		System.out.println("Please enter your user id");
		int userid = in.nextInt();
		
		//enter looking age
		System.out.println("Please enter the lowest age you are looking for");
		int age_low = in.nextInt();
		
		//enter age weight
		System.out.println("Please enter highest age you are looking for");
			int age_high = in.nextInt();
			while(age_high <= age_low){
				if(age_high <= age_low){
					System.out.println("highest age must be greater than lowest age.");
				}
				age_high = in.nextInt();
				
			}
		
		
		//enter sex you are looking for
		System.out.println("Please enter the sex you are looking for (M = 1 and F = 2)");
		int gender = -1;
		while(gender < 1 || gender > 2){
			gender = in.nextInt();
			if(gender < 1 || gender > 2){
				System.out.println("The sex must be M or F.");
			}
		}
		
		//enter the religion you are looking for
		System.out.println("Please enter the religion you are looking for");
		String religion = in.next();
		
		//enter the religion weight
		System.out.println("Please enter the relgion weight (1-10)");
		int religion_weight = -1;
		while(religion_weight < 0 || religion_weight > 10 ){
			religion_weight = in.nextInt();
			if(religion_weight < 0 || religion_weight > 10 ){
				System.out.println("The weight must be between 1 and 10.");
			}
		}
		
		//enter seriousness
		System.out.println("Please enter your seriousness (1-10)");
		int seriousness = -1;
		while(seriousness < 0 || seriousness > 10){
			seriousness = in.nextInt();
			if(seriousness < 0 || seriousness > 10){
				System.out.println("The seriousness must be between 1 and 10.");
			}
		}
		//seriousness weight
		System.out.println("Please enter seriousness weight (1-10)");
		int seriousness_weight = -1;
		while(seriousness_weight < 0 || seriousness_weight > 10){
			seriousness_weight = in.nextInt();
			if(seriousness_weight < 0 || seriousness_weight > 10){
				System.out.println("The seriousness must be between 1 and 10.");
			}
		}
		
		//adding user looking for method
		looking.add_user_looking_for(userid, age_low, age_high, gender,
				religion, religion_weight, seriousness, seriousness_weight);
		
		
		System.out.println("Checking for a match....\n");
		String match_user = matching.find_match(userid, age_low, age_high, gender);
		System.out.printf("Congradulations a good match would be: %s", match_user);
	}
		

}
