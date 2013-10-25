package edu.ycp.cs481.linkup.controller;

import edu.ycp.cs481.linkup.model.User;
import edu.ycp.cs481.linkup.persistence.Database;
import edu.ycp.cs481.linkup.persistence.PersistenceException;

public class CreateUserController {
	public int createUser(User inUser) throws PersistenceException{
		return Database.getInstance().createUser(inUser);
	}
}
