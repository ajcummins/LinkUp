package edu.ycp.cs481.linkup.persistence;
import java.sql.*;


public class SQLTEST {

	public static void main(String[] args) throws Exception {
		
		Class.forName("com.mysql.jdbc.Driver");
        java.sql.Connection con = null;
        java.sql.PreparedStatement stmt = null;
        String user = "ajcummins";
        String pass = "root";
        try {
            con = DriverManager.getConnection("jdbc:mysql://172.31.5.42:3306/linkup", user, pass);
            /*
            stmt = con.prepareStatement("INSERT INTO linkup.account_registration(user_id,first_name,last_name) VALUES (?,?,?)");
            stmt.setString(1, "999");
            stmt.setString(2, "Clyde");
            stmt.setString(3, "Evans");
            stmt.executeUpdate();
            */
            
            /*Further utilizing the SQLTEST to test SQL statments
            // Statement for getting max user_id
            stmt = con.prepareStatement("SELECT MAX(user_id) FROM user");
            stmt.executeQuery();
            ResultSet result = stmt.getResultSet();
            result.next();
            int max = result.getInt(1);
            System.out.println("Max is : " + max);
            System.out.println("So we need : " + (max+1));
            */
            //con.commit();
            
            
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (stmt != null) {
                try {
                   stmt.close();
                } catch (SQLException ex) {
                }
            }
            if (con != null) {
                try {
                   con.close();                    
                } catch (SQLException ex) {
                }
            }
        }
	}

}




/*
 * Useful..
 * 
 * Basically you are positioning the cursor before the first row and then requesting data. You need to move the cursor to the first row.

 result.next();
 String foundType = result.getString(1);
It is common to do this in an if statement or loop.

if(result.next()){
   foundType = result.getString(1);
}
 * 
 */
