package com.asm3.mobie.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.microsoft.sqlserver.jdbc.SQLServerDriver;

public class MyConnection {
	public static Connection connect() {
		Connection conn = null;
		// Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); // tìm driver
		// , phiên bản java cũ thì cần mới thì 0
		String dbURL = "jdbc:sqlserver://ADMIN:1433;databaseName=ShoppingDB";
		// DESKTOP-U3GVQTN:1433 (Tên Host : port )
		String USER_NAME = "tduy1998vn";
		String PASSWORD = "123456";
		try {
			DriverManager.registerDriver(new SQLServerDriver());
			conn = DriverManager.getConnection(dbURL, USER_NAME, PASSWORD);
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
		return conn;
	}
}
