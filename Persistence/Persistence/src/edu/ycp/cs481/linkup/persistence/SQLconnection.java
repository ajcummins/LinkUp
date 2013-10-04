package edu.ycp.cs481.linkup.persistence;
import java.sql.DriverManager;
import java.sql.SQLException;


public class SQLconnection {

	private java.sql.Connection con = null;
    private java.sql.PreparedStatement stmt = null;
	
	public SQLconnection() throws Exception
	{
		Class.forName("com.mysql.jdbc.Driver");
	}
	
	// Creates and returns a connection to the LinkUp Database requiring a user and pass to the database
	public java.sql.Connection createConnection(String inUser, String inPass)
	{	
	 try {
		 	//172.31.5.42 is the IP of Kerry's Machine which is hosting the Database
            con = DriverManager.getConnection("jdbc:mysql://172.31.5.42:3306/linkup", inUser, inPass);
        } catch (Exception e) {
            e.printStackTrace();
        } 
		return con;
	}
	
	
	public void stopConnection()
	{
		try {
            if (con != null) {
                try {
                   con.close();                    
                } catch (SQLException ex) {
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } 
	}
}
