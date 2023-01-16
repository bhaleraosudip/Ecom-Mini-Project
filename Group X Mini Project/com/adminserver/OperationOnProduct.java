package com.adminserver;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.registration.UserConnection;

public class OperationOnProduct {
	// Author -- Group x

	public static void productOperation() throws SQLException {

		Scanner scanner = new Scanner(System.in);

		// Only admin can change data into fashion table
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		// Program to make changes in data base
		System.out.print("Want to make changes in database (y or n)?:   ");
		char changes = scanner.next().charAt(0);
		while (changes == 'y' || changes == 'Y') {

			System.out.println(
					"__________________________________________________________________________________________________");

			System.out.println("Want to update DATABASE ?");
			scanner.nextLine();
			System.out.print("\t\t\t\t\tSelect Operation....(ADD, DELETE, VIEW, UPDATE):   ");
			String operation = scanner.nextLine().toUpperCase();
			switch (operation) {
			case "ADD":
				
				//JDBC method to add product in
				InsertProduct.getInsert();
				break;

			/*case "DELETE":
				DeleteProduct.getDelete();
				break;
*/
			case "VIEW":
				FetchProduct.getView();
				break;

			case "UPDATE":
				System.out.println("What you want to update :\t");
				System.out.println("Name, Description,price, quantity?");
				String update = scanner.nextLine().toUpperCase();
				switch (update) {
				case "NAME":
					updateProduct.updateName();
					break;
				case "DESCRIPTION":
					updateProduct.updateDescription();
					break;
				case "PRICE":
					updateProduct.updatePrice();
					break;
				case "QUANTITY":
					updateProduct.updateQuantity();
					break;
				}
				System.out.println("\t\t\t\t\tUpdate Completed...");
				break;
			}
			System.out.print("\nWant to make changes in data base (y or n)?:  ");
			changes = scanner.next().charAt(0);
		}
		System.out.print("\nWant to check total qunatity of all products (y or n) :  ");
		char quantity = scanner.next().charAt(0);
		if (quantity == 'y' || quantity == 'Y') {
			QuantityCheck.checkQuantity();
		}
		System.out.print("\nWant to check user list (y or n)? :   ");
		char user = scanner.next().charAt(0);
		if (user == 'y' || user == 'Y') {
			RegisteredUserList.userList();
		}
		System.out.println("\nWant to check User History (y or n)? :  ");
		char history = scanner.next().charAt(0);
		if (user == 'y' || user == 'Y') {
			UserHistory.getUserHistory();
		}
	}

}
