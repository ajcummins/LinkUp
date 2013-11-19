package edu.ycp.cs481.linkup.controller;

import edu.ycp.cs481.linkup.model.User;
import edu.ycp.cs481.linkup.persistence.Database;
import edu.ycp.cs481.linkup.persistence.PersistenceException;

public class DropDownListController {
	public String ddlGender() throws PersistenceException
	{
		return Database.getInstance().getDDLGender();
	}
	public String ddlLocation() throws PersistenceException
	{
		return Database.getInstance().getDDLLocation();
	}
	public String ddlLookingFor() throws PersistenceException
	{
		return Database.getInstance().getDDLLookingFor();
	}
	public String ddlReligion() throws PersistenceException
	{
		return Database.getInstance().getDDLReligion();
	}
	public String ddlWeight(String weight_type) throws PersistenceException
	{
		return Database.getInstance().getDDLWeight(weight_type);
	}
}
