package edu.ycp.cs481.linkup.controller;

import edu.ycp.cs481.linkup.model.UserProfile;
import edu.ycp.cs481.linkup.persistence.Database;
import edu.ycp.cs481.linkup.persistence.PersistenceException;

public class ProfileViewController {
		public void ProfileView(UserProfile inProfile) throws PersistenceException{
			Database.getInstance().get_profile_info(inProfile); //inUserProfile
		}
	}