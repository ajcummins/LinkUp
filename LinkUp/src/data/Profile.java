package data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Profile {

	public Profile() {
		// TODO Auto-generated constructor stub
		String likes, dislikes, sex;
	}

	//test

		
		public String getLikes(){
			String likes = null;
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			try {
				likes = reader.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return likes;
			
			
		}
		
		public String getDislikes(){
			String dislikes = null;
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			try {
				dislikes = reader.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return dislikes;
			
			
			
			
		}
		
		public String getSex(){
			String sex = null;
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			try {
				sex = reader.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(sex.equalsIgnoreCase("M") || sex.equalsIgnoreCase("F")){
				
			}else{
				System.out.print("Try again. Enter M for male or F for female");
				getSex();
			}
			
			return sex;
			
			
			
		}
		

	}


