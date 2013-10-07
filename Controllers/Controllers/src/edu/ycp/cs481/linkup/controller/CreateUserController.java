package edu.ycp.cs481.linkup.controller;

import edu.ycp.cs481.linkup.model.User;
import edu.ycp.cs481.linkup.persistence.Database;
import edu.ycp.cs481.linkup.persistence.PersistenceException;

public class CreateUserController {
	public void createUser(User inUser) throws PersistenceException{
		Database.getInstance().createUser(inUser);
	}
}
