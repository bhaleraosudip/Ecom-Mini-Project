package com.userpurchase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import com.registration.UserConnection;

//author--Group x

public class ProductList {
	static ResultSet resultSet = null;
	static Connection connection = null;
	static PreparedStatement preparedStatement = null;

	public static void getProductNameList() {
		List<String> productNameList = new ArrayList<String>();
		Set<String> productNameSet = new LinkedHashSet<String>();
		System.out.println("\nWant to view product name list (y or n)? :  ");
		char count = scanner.next().charAt(0);
		while (count == 'y' || count == 'Y') {

			try {
				preparedStatement = UserConnection.getConnection().prepareStatement("select name from fashion");
				resultSet = preparedStatement.executeQuery();
				while (resultSet.next()) {
					productNameList.add(resultSet.getString(1));
				}

				productNameSet.addAll(productNameList);
				for (String string : productNameSet) {
					System.out.println(string);
				}
			} catch (Exception e) {
				System.out.println(e);
			} finally {
				try {
					resultSet.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			break;
		}

	}

	static Scanner scanner = new Scanner(System.in);

	public static void getfullProductData() {
		System.out.print("\nWant to view details of products (y or n? : ");
		char productname = scanner.next().charAt(0);
		while (productname == 'y' || productname == 'Y') {

			try {
				preparedStatement = UserConnection.getConnection().prepareStatement("select * from fashion");
				resultSet = preparedStatement.executeQuery();
				while (resultSet.next()) {
					System.out.println("Product ID :				" + resultSet.getInt(1));
					System.out.println("Product  Name :			" + resultSet.getString(2));
					System.out.println("Product Description:		" + resultSet.getString(3));
					System.out.println("Product Price :			" + resultSet.getInt(4));
					System.out.println("\n");
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
			break;
		}
	}

	public static Map<Integer, String> getIdAndNameMap() {
		Map<Integer, String> getNamenId = new LinkedHashMap<Integer, String>();
		try {
			preparedStatement = UserConnection.getConnection().prepareStatement("select * from fashion");
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				getNamenId.put(resultSet.getInt(1), resultSet.getString(2));
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return getNamenId;
	}
}
