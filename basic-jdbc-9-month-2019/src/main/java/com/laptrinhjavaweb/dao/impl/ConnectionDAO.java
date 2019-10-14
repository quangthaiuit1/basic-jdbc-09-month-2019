package com.laptrinhjavaweb.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionDAO {
	public static Connection getConnection() {
		// Load driver mysql
		try {
			Class.forName("com.mysql.jdbc.Driver");
			// handle connect mysql
			String url = "jdbc:mysql://localhost:3306/shopdan";
			String user = "root";
			String password = "voquangthai";
			return DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException | SQLException e) {
			return null;
		}
	}

	public static boolean closeConnection(Connection con,PreparedStatement ps) {
		try {
			if(con != null) {
				con.close();
			}
			if(ps != null) {
				ps.close();
			}
		} catch (Exception e2) {
			return false;
		}
		return true;
	}
}
