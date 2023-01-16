package com.adminserver;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.registration.UserConnection;

//Author-Group x
public class FetchProduct {
	static void getView() {
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		try {
			// select query to fetch the list of products
			preparedStatement = UserConnection.getConnection().prepareStatement("select * from fashion");
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				System.out.println("Product ID :					" + resultSet.getInt(1));
				System.out.println("Product Name :				" + resultSet.getString(2));
				System.out.println("Product Description :		" + resultSet.getString(3));
				System.out.println("Product Price :				" + resultSet.getInt(4));
				System.out.println("Product Quantity :				" + resultSet.getInt(5));
				System.out.println("\n");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
}
