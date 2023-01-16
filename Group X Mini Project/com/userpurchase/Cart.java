package com.userpurchase;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.Map.Entry;

import com.registration.UserConnection;

//Author --Group x

public class Cart {
	static int totalPrice = 0;
	static int quantity = 0;
	static int integer;
	static Integer id = null;
	static int quantites;

	static int integer1;
	static String _name_;
	static int _quantity_;
	static int _price_;

	public static void generteCartList() {
		Map<Integer, String> idAndName = new LinkedHashMap<Integer, String>();
		Map<Integer, Integer> idAndPrice = new LinkedHashMap<Integer, Integer>();
		Map<Integer, Integer> idAndQuantity = new LinkedHashMap<Integer, Integer>();

		List<ProductData> productDataList = new ArrayList<ProductData>();
		Scanner scanner = new Scanner(System.in);

		// Add To Cart
		System.out.print("\nWant to add product in Cart (y or n)?");
		char cartChoice = scanner.next().charAt(0);
		while (cartChoice == 'y' || cartChoice == 'Y') {
			PreparedStatement preparedStatement = null;
			ResultSet resultSet = null;
			try {
				preparedStatement = UserConnection.getConnection().prepareStatement("select * from fashion");
				resultSet = preparedStatement.executeQuery();

				// Format
				ProductData.displayFormat();

				while (resultSet.next()) {
					System.out.format("   %-9s             %-100s      %-35s               \n", resultSet.getInt(1),
							resultSet.getString(2), resultSet.getInt(4));
					idAndName.put(resultSet.getInt(1), resultSet.getString(2));
					idAndPrice.put(resultSet.getInt(1), resultSet.getInt(4));
					idAndQuantity.put(resultSet.getInt(1), resultSet.getInt(5));
				}
				System.out.print("\n\tEnter product ID to add in cart :	");

				// converting int into object(AutoBoxing)
				integer = scanner.nextInt();
				id = new Integer(integer);
				Set<Entry<Integer, String>> set1 = idAndName.entrySet();
				for (Entry<Integer, String> entry : set1) {
					if (id.equals(entry.getKey())) {
						integer1 = integer;
						_name_ = entry.getValue();
					}
				}

				Set<Entry<Integer, Integer>> set2 = idAndQuantity.entrySet();
				for (Entry<Integer, Integer> entry : set2) {

					// To add quantity of product
					if (id.equals(entry.getKey())) {
						System.out.println("\n\tAdd Quantity :	");
						quantites = scanner.nextInt();
						_quantity_ = quantites;

					}

					// to show total Price
					Set<Entry<Integer, Integer>> set3 = idAndPrice.entrySet();
					for (Entry<Integer, Integer> entry2 : set2) {
						if (id.equals(entry.getKey())) {
							_price_ = entry2.getValue();
							totalPrice = totalPrice + (_quantity_ * entry.getValue());

						}
					}

				}
//				System.out.print("\n\tWant to purchase from Cart (y or n)? :  ");
//				char buyChoice = scanner.next().charAt(0);
				productDataList.add(new ProductData(integer1, _name_, _quantity_, _price_));
//				if (buyChoice == 'y' || buyChoice == 'Y') {
//					ArrayList arrayList1 = new ArrayList();
//					BuyProduct.buyProduct(arrayList1, totalPrice);
//				}
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
			System.out.print("\nWant to add more products to Cart (y or n)? :  ");
			cartChoice = scanner.next().charAt(0);
		}

		System.out.println("\nWant to buy products from Cart (y or n) ?:  ");
		char buy = scanner.next().charAt(0);
		if (buy == 'y' || buy == 'Y') {
		BuyProduct.getData(productDataList, totalPrice);
			System.out.println("\n\t\t\t\t\t\t\t\t\t\tTotal Price:  Rs." + totalPrice);
		}

	}
	
}
