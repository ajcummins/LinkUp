package edu.ycp.cs481.linkup.persistence;

import edu.ycp.cs481.linkup.model.User;
import edu.ycp.cs481.linkup.model.UserProfile;

public class FakeDatabase implements IDatabase {

	@Override
	public UserProfile loadUserProfile(int profileId) {
		// FIXME: this is fake, really should access the databases
		UserProfile profile = new UserProfile();
		profile.setName("Whatever");
		return profile;
	}

	@Override
	public void createUser(User inUser) {
		// TODO Auto-generated method stub
		
		
	}


}
