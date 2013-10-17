package edu.ycp.cs481.linkup.controller;

import edu.ycp.cs481.linkup.model.UserProfile;
import edu.ycp.cs481.linkup.persistence.Database;
import edu.ycp.cs481.linkup.persistence.PersistenceException;

public class ProfileController {
		public void Profile(UserProfile inProfile) throws PersistenceException{
			Database.getInstance().add_profile_info(inProfile);
		}
	}


