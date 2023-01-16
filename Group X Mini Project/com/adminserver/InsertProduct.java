package com.adminserver;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.registration.UserConnection;

//Author--Group x

public class InsertProduct {
	static void getInsert() {
		PreparedStatement preparedStatement=null;
		Scanner scanner=new Scanner(System.in);
		ResultSet resultSet=null;
		try {
			// Insert Query to add product in database
			preparedStatement = UserConnection.getConnection().prepareStatement(
					"insert into fashion(productId,name,description,price, quantity)values(?,?,?,?,?)");

			// take input from user
			System.out.println("____________________To add the product in Fashion____________________");
			System.out.print("Product ID :\t");
			int id = scanner.nextInt();
			scanner.nextLine();
			System.out.print("Product name :\t");
			String name = scanner.nextLine();
			System.out.print("Product Description :\t");
			String description = scanner.nextLine();
			System.out.print("Product Price :\tRs.");
			int price = scanner.nextInt();
			System.out.print("Product Quantity :\t");
			int quantity = scanner.nextInt();

			// Add values in table
			preparedStatement.setInt(1, id);
			preparedStatement.setString(2, name);
			preparedStatement.setString(3, description);
			preparedStatement.setInt(4, price);
			preparedStatement.setInt(5, quantity);
			System.out.println("\t\t\t\t\tInsertion Completed...");
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			try {
				preparedStatement.close();
				resultSet.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
