package edu.ycp.cs481.linkup.controller;

import edu.ycp.cs481.linkup.model.UserProfile;
import edu.ycp.cs481.linkup.persistence.Database;

public class LoadUserProfile {
	public UserProfile getUserProfile(int profileId) {
		return Database.getInstance().loadUserProfile(profileId);
	}
}
