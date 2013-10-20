package edu.ycp.cs481.linkup.controller;

import edu.ycp.cs481.linkup.model.User;
import edu.ycp.cs481.linkup.persistence.Database;
import edu.ycp.cs481.linkup.persistence.PersistenceException;

public class IndexController {
	public User checkUserCredentials(String inUsername, String inPassword) throws PersistenceException
	{
		return Database.getInstance().checkUserCredentials(inUsername,inPassword);
	}
}
