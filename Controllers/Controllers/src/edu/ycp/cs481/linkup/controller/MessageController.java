package edu.ycp.cs481.linkup.controller;

import edu.ycp.cs481.linkup.model.Messages;
import edu.ycp.cs481.linkup.persistence.Database;
import edu.ycp.cs481.linkup.persistence.PersistenceException;

public class MessageController {
	public String Messaging(int inMessage) throws PersistenceException{
		return Database.getInstance().getMessages(inMessage);
	}
	
	public String MessagingUserName(int inMessage) throws PersistenceException{
		return Database.getInstance().getUserName(inMessage);
	}
}
