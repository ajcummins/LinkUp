package edu.ycp.cs481.linkup.controller;

import com.mysql.jdbc.Messages;

import edu.ycp.cs481.linkup.model.Matching;
import edu.ycp.cs481.linkup.persistence.Database;
import edu.ycp.cs481.linkup.persistence.PersistenceException;

public class MessageController {
	public void Messaging(Messages inMessage) throws PersistenceException{
		Database.getInstance().getMessages(inMessage);
	}
}
