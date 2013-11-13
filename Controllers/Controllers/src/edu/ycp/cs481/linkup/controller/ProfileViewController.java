package edu.ycp.cs481.linkup.controller;

import edu.ycp.cs481.linkup.model.MatchUserProfile;
import edu.ycp.cs481.linkup.model.UserProfile;
import edu.ycp.cs481.linkup.persistence.Database;
import edu.ycp.cs481.linkup.persistence.PersistenceException;

public class ProfileViewController {
		public void ProfileView(UserProfile inProfile) throws PersistenceException{
			Database.getInstance().get_profile_info(inProfile); //inUserProfile
		}
		public String[] ProfileComments(int inProfile) throws PersistenceException{
			return Database.getInstance().get_comment(inProfile); //inUserProfile
		}
		public MatchUserProfile MatchProfileView(int userid) throws PersistenceException{
			return Database.getInstance().getMatchProfile(userid); //inUserProfile
		}
	}