package edu.ycp.cs481.linkup.persistence;

import edu.ycp.cs481.linkup.model.UserProfile;

public class Database {
	private static Database theDatabase = new Database();
	
	public static Database getInstance() {
		return theDatabase;
	}
	
	private Database() {
		
	}
	
	public UserProfile loadUserProfile(int profileId) {
		// FIXME: this is fake, really should access the databases
		UserProfile profile = new UserProfile();
		profile.setName("Whatever");
		return profile;
	}
}
