package edu.ycp.cs481.linkup.persistence;

/**
 * Provide access to a singleton instance of {@link IDatabase}.
 * 
 * @author AJC
 */
public class Database {
	// Can change this to a "real" database eventually
	private static IDatabase theDatabase = new FakeDatabase();
	
	
	
	/**
	 * Get the singleton instance of {@link IDatabase}.
	 * 
	 * @return the singleton instance of {@link IDatabase}
	 */
	public static IDatabase getInstance() {
		return theDatabase;
	}
}

