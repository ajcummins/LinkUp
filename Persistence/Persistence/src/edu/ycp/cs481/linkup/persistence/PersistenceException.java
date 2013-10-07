package edu.ycp.cs481.linkup.persistence;

/**
 * Exception type for persistence errors.
 * 
 * @author AJC
 */
public class PersistenceException extends Exception {
	private static final long serialVersionUID = 1L;

	public PersistenceException(String msg) {
		super(msg);
	}
	
	public PersistenceException(String msg, Exception cause) {
		super(msg, cause);
	}
}
