package edu.ycp.cs481.linkup.controller;

import edu.ycp.cs481.linkup.model.UserProfile;
import edu.ycp.cs481.linkup.persistence.Database;
import edu.ycp.cs481.linkup.persistence.PersistenceException;

public class LoadUserProfile {
	public UserProfile getUserProfile(int profileId) throws PersistenceException {
		return Database.getInstance().loadUserProfile(profileId);
	}
}
