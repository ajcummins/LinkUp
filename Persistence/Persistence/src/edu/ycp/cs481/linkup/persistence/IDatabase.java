package edu.ycp.cs481.linkup.persistence;

import edu.ycp.cs481.linkup.model.LookingFor;
import edu.ycp.cs481.linkup.model.User;
import edu.ycp.cs481.linkup.model.UserProfile;;


/**
 * Interface describing persistence operations.
 * 
 * @author AJC
 */
public interface IDatabase {
	/**
	 * Load the user profile for given profile id.
	 * 
	 * @param profileId the profile id
	 * @return the {@link UserProfile}, or null if there is no such user
	 */
	public UserProfile loadUserProfile(int profileId) throws PersistenceException;
	
	public void createUser(User inUser) throws PersistenceException;

	public void add_user_looking_for(LookingFor inLooking) throws PersistenceException;


}
