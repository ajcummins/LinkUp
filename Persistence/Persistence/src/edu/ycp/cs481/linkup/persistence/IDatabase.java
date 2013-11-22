package edu.ycp.cs481.linkup.persistence;

import java.sql.Connection;

import edu.ycp.cs481.linkup.model.LookingFor;
import edu.ycp.cs481.linkup.model.MatchUserProfile;
import edu.ycp.cs481.linkup.model.Matching;
import edu.ycp.cs481.linkup.model.Messages;
import edu.ycp.cs481.linkup.model.Rating;
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
	 * @return 
	 * @throws DuplicateUserException if the user already exists
	 * @throws PersistenceException if some other database error occurs
	 */
	public int createUser(User inUser) throws PersistenceException;

	public void add_user_looking_for(LookingFor inLooking) throws PersistenceException;
	
	public void add_profile_info(UserProfile inProfile) throws PersistenceException;

	public String[] find_match(int inMatching) throws PersistenceException;

	public User checkUserCredentials(String inUsername, String inPassword) throws PersistenceException;

	public String[] get_profile_info(UserProfile inProfile) throws PersistenceException;
	
	public int createRating(Rating inRating) throws PersistenceException;

	public void insertMessages(Messages inMessage) throws PersistenceException;

	public int getMatchID(String buttonAction) throws PersistenceException;

	public String getMessages(int user_id) throws PersistenceException;
	
	public String getUserName(int user_id) throws PersistenceException;
	
	public String[] get_comment(int userid)	throws PersistenceException;

	public MatchUserProfile getMatchProfile(int userid)	throws PersistenceException;

	public void insertReplyMessages(Messages inMessage)	throws PersistenceException;

	public int getReplyID(String buttonAction)	throws PersistenceException;

	public String getSentMessages(int user_id)	throws PersistenceException;

	public String getDDLGender()	throws PersistenceException;

	public String getDDLLocation()	throws PersistenceException;

	public String getDDLLookingFor()	throws PersistenceException;

	public String getDDLReligion()	throws PersistenceException;

	public String getDDLWeight(String weight_type)	throws PersistenceException;

	public void update_user_looking_for(LookingFor inLooking)	throws PersistenceException;
	
	public void edit_profile_info(UserProfile inProfile) throws PersistenceException;

	public LookingFor getLooking_for(int userid) throws PersistenceException;




	


}
