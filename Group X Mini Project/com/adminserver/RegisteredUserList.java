package com.adminserver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//Author - Group x 


class RegisteredUserList {

	static void userList() {
		PreparedStatement preparedStatement = null;
		Connection connection = null;
		ResultSet resultSet = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecom", "root", "root");
			preparedStatement = connection.prepareStatement("select username, name from user");
			resultSet = preparedStatement.executeQuery();
			System.out.println(
					
					"----------------------------------------------------------------------------------------------------------------");
			System.out.println(
					"         Name                                                              username              ");
			System.out.println(
					"----------------------------------------------------------------------------------------------------------------");

			while (resultSet.next()) {
				System.out.format("%-50s             %10s       \n", resultSet.getString(2), resultSet.getString(1));
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				resultSet.close();
				preparedStatement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
