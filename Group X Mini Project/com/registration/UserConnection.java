package com.registration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
//Author-- Group x

public class UserConnection {

	public static Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecom", "root", "root");
		} catch (Exception e) {
			System.out.println(e);

		}
		return connection;
	}
}
