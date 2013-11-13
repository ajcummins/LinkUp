package edu.ycp.cs481.linkup.controller;

import edu.ycp.cs481.linkup.model.Matching;
import edu.ycp.cs481.linkup.persistence.Database;
import edu.ycp.cs481.linkup.persistence.PersistenceException;

public class MatchingController {
	public String[] Matching(int inMatching) throws PersistenceException{
		return Database.getInstance().find_match(inMatching);
	}
	public int MatchID(String buttonAction) throws PersistenceException{
		return Database.getInstance().getMatchID(buttonAction);
	}
}
