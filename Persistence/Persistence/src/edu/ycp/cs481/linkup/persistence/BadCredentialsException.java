package edu.ycp.cs481.linkup.persistence;

public class BadCredentialsException extends PersistenceException{

		private static final long serialVersionUID = 1L;

		public BadCredentialsException(String msg) {
			super(msg);
		}
		
		public BadCredentialsException(String msg, Exception cause) {
			super(msg, cause);
		}
	
}
