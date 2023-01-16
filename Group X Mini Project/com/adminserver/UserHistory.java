package com.adminserver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

//Author -- Group x
class UserHistory {

	static void getUserHistory() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecom", "root", "root");
			preparedStatement = connection
					.prepareStatement("select * from user inner join userhistory on user.sr_no=userhistory.sr_no");
			resultSet = preparedStatement.executeQuery();

			System.out.println(
					"-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
			System.out.println(
					"\nName\t\t\t\t\t\t\t\teMail\t\t\t\t\t\t\tusername\t\t\t\tPurchase History\t\tTotal Expense(Rs.)\n");
			System.out.println(
					"-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
			while (resultSet.next()) {
				System.out.format("%-55S %-5s %40s %45d %45d \n", resultSet.getString(2), resultSet.getString(3),
						resultSet.getString(5), resultSet.getInt(7), resultSet.getInt(8));
			}
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
