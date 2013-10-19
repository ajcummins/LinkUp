package edu.ycp.cs481.linkup.controller;

import edu.ycp.cs481.linkup.model.Matching;
import edu.ycp.cs481.linkup.persistence.Database;
import edu.ycp.cs481.linkup.persistence.PersistenceException;

public class MatchingController {
	public void Matching(Matching inMatching) throws PersistenceException{
		Database.getInstance().find_match(inMatching);
	}
}
