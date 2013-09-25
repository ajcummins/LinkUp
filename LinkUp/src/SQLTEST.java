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
            stmt = con.prepareStatement("INSERT INTO linkup.account_registration(user_id,first_name,last_name) VALUES (?,?,?)");
            stmt.setString(1, "999");
            stmt.setString(2, "Clyde");
            stmt.setString(3, "Evans");
            stmt.executeUpdate();
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
