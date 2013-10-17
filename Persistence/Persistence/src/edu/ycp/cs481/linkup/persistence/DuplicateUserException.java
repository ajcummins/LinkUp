package edu.ycp.cs481.linkup.persistence;

public class DuplicateUserException extends PersistenceException {
	private static final long serialVersionUID = 1L;

	public DuplicateUserException(String msg) {
		super(msg);
	}
	
	public DuplicateUserException(String msg, Exception cause) {
		super(msg, cause);
	}
}
