package edu.ycp.cs481.linkup.controller;

import edu.ycp.cs481.linkup.model.UserProfile;
import edu.ycp.cs481.linkup.persistence.Database;
import edu.ycp.cs481.linkup.persistence.PersistenceException;

public class EditProfileInfoController {
	public void Profile(UserProfile inProfile) throws PersistenceException{
		Database.getInstance().edit_profile_info(inProfile);
	}
}


