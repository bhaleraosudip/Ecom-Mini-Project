package com.registration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import com.userserver.LogInException;

public class Sign_Up extends LogInException{

	public static void GetRegistration()  {
		Scanner scanner = new Scanner(System.in);
		System.out.println("\t\t\t\t\tSign-Up Details....");
		System.out.println(
				"__________________________________________________________________________________________________________________\n");
		System.out.print("Name :\t");
		String name = scanner.nextLine();
		System.out.print("E Mail :\t");
		String eMail = scanner.nextLine();
		System.out.print("Phone Number :\t");
		String phone = scanner.nextLine();
		System.out.print("username :\t");
		String username = scanner.nextLine();
		System.out.print("password :\t");
		String password = scanner.nextLine();

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {

			preparedStatement = UserConnection.getConnection().prepareStatement(
					"insert into user(name, email, phone_number, username, password)values(?, ?, ?, ?, ?)");
			preparedStatement.setString(1, name);
			preparedStatement.setString(2, eMail);
			preparedStatement.setString(3, phone);
			preparedStatement.setString(4, username);
			preparedStatement.setString(5, password);
			preparedStatement.executeUpdate();
			System.out.println("\n\t\t\t\t\tRegistration Complete......");
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				preparedStatement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
