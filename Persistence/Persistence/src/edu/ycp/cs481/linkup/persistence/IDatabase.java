package edu.ycp.cs481.linkup.persistence;

import edu.ycp.cs481.linkup.model.LookingFor;
import edu.ycp.cs481.linkup.model.Matching;
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
	
	/**
	 * Create given user in the database.
	 * 
	 * @param inUser the {@link User} to create
	 * @throws DuplicateUserException if the user already exists
	 * @throws PersistenceException if some other database error occurs
	 */
	public void createUser(User inUser) throws PersistenceException;

	public void add_user_looking_for(LookingFor inLooking) throws PersistenceException;
	
	public void add_profile_info(UserProfile inProfile) throws PersistenceException;

	public String find_match(Matching inMatching) throws PersistenceException;

	public User checkUserCredentials(String inUsername, String inPassword);

	public String[] get_profile_info(UserProfile inProfile) throws PersistenceException;

	


}
