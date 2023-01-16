package com.userserver;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.registration.UserConnection;
//Author--Gruop x


public class usernameAndPassword {
	static PreparedStatement preparedStatement = null;
	static ResultSet resultSet = null;

	public static ArrayList<String> getUsername() {
		ArrayList<String> username = new ArrayList<String>();

		try {
			preparedStatement = UserConnection.getConnection().prepareStatement("select username from user");
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				username.add(resultSet.getString(1));
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				preparedStatement.close();
				resultSet.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return username;
	}

	private void y() {
		// TODO Auto-generated method stub

	}

	public static ArrayList<String> getPassword() {
		ArrayList<String> password = new ArrayList<String>();
		try {
			preparedStatement = UserConnection.getConnection().prepareStatement("select password from user");
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				password.add(resultSet.getString(1));
			}

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			try {
				preparedStatement.close();
				resultSet.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return password;
	}

	public static void main(String[] args) {
		getUsername();
	}
}
