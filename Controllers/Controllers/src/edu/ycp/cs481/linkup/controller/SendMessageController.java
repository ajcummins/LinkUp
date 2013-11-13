package edu.ycp.cs481.linkup.controller;

import edu.ycp.cs481.linkup.model.Messages;
import edu.ycp.cs481.linkup.persistence.Database;
import edu.ycp.cs481.linkup.persistence.PersistenceException;

public class SendMessageController {
	public void SendMessages(Messages inMessage) throws PersistenceException{
		Database.getInstance().insertMessages(inMessage);
	}
	public void ReplyMessages(Messages inMessage) throws PersistenceException{
		Database.getInstance().insertReplyMessages(inMessage);
	}
	public int ReplyID(String buttonAction) throws PersistenceException{
		return Database.getInstance().getReplyID(buttonAction);
	}
}
