package com.adminserver;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.registration.UserConnection;

//Author--Group x
class updateProduct {
	static Connection connection = null;
	static PreparedStatement preparedStatement = null;
	static Scanner scanner = new Scanner(System.in);

	static int id;
	static String name;
	static String description;
	static int price;
	static int quantity;

	public static void updateName() throws SQLException {
		try {
			preparedStatement = UserConnection.getConnection()
					.prepareStatement("update fashion set name=? where productId=?");
			System.out.print("Product ID :\t");
			id = scanner.nextInt();
			scanner.nextLine();
			System.out.print("Product Name :\t");
			name = scanner.nextLine();

			preparedStatement.setInt(2, id);
			preparedStatement.setString(1, name);
			preparedStatement.executeUpdate();

		} catch (Exception e) {
			System.out.println(e);
		} finally {
			preparedStatement.close();
		}
	}

	public static void updateDescription() throws SQLException {
		try {
			preparedStatement = UserConnection.getConnection()
					.prepareStatement("update fashion set description=? where productId=?");
			System.out.print("Product ID :\t");
			id = scanner.nextInt();
			scanner.nextLine();
			System.out.print("Product Description :\t");
			description = scanner.nextLine();

			preparedStatement.setInt(2, id);
			preparedStatement.setString(1, description);
			preparedStatement.executeUpdate();

		} catch (Exception e) {
			System.out.println(e);
		} finally {
			preparedStatement.close();
		}
	}

	public static void updatePrice() throws SQLException {
		try {
			preparedStatement = UserConnection.getConnection()
					.prepareStatement("update fashion set price=? where productId=?");
			System.out.print("Product ID :\t");
			id = scanner.nextInt();
			System.out.print("Product Price :\t");
			price = scanner.nextInt();

			preparedStatement.setInt(2, id);
			preparedStatement.setInt(1, price);
			preparedStatement.executeUpdate();

		} catch (Exception e) {
			System.out.println(e);
		} finally {
			preparedStatement.close();
		}
	}

	public static void updateQuantity() throws SQLException {
		try {
			preparedStatement = UserConnection.getConnection()
					.prepareStatement("update fashion set quantity=? where productId=?");
			System.out.print("Product ID :\t");
			id = scanner.nextInt();
			System.out.print("Product Quantity :\t");
			quantity = scanner.nextInt();

			preparedStatement.setInt(2, id);
			preparedStatement.setInt(1, quantity);
			preparedStatement.executeUpdate();

		} catch (Exception e) {
			System.out.println(e);
		} finally {
			preparedStatement.close();
		}
	}
}
