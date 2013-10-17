package edu.ycp.cs481.linkup.persistence;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtil {

	public static void closeQuietly(ResultSet result) {
		if (result != null) {
			try {
				result.close();
			} catch (SQLException e) {
				// TODO: log
			}
		}
	}

	public static void closeQuietly(PreparedStatement stmt) {
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO: log
			}
		}
	}

}
