package edu.ycp.cs481.linkup.controller;

import edu.ycp.cs481.linkup.model.LookingFor;
import edu.ycp.cs481.linkup.persistence.Database;
import edu.ycp.cs481.linkup.persistence.PersistenceException;

public class LookingForController {
	public void LookingFor(LookingFor inLooking) throws PersistenceException{
		Database.getInstance().add_user_looking_for(inLooking);
	}
	public void UpdateLookingFor(LookingFor inLooking) throws PersistenceException{
		Database.getInstance().update_user_looking_for(inLooking);
	}
	public LookingFor GetLookingFor(int userid) throws PersistenceException{
		return Database.getInstance().getLooking_for(userid);
	}
}
