package com.userserver;

import java.sql.SQLException;
import java.util.Scanner;

import com.adminserver.OperationOnProduct;
import com.registration.Sign_Up;
import com.userpurchase.Cart;
import com.userpurchase.ProductList;

//Author - Group x

public class Log_In {
	static Scanner scanner = new Scanner(System.in);

	public static void getLogIn() throws SQLException {

		System.out.print("want to Log_In to Ecom (y or no)?: ");
		char count = scanner.next().charAt(0);
		while (count == 'y' || count == 'Y') {

			System.out.println("To Register press 1 or To Log In Press 2 :\t");
			int userInt = scanner.nextInt();
			if (userInt == 1) {
				Sign_Up.GetRegistration();
				System.out.println("To Log In Press 2 :\t");
				userInt = scanner.nextInt();
			}
			if (userInt == 2) {
				System.out.format(
						"-----------------------------------------------------------------------------------------------------------------------------------");
				System.out.println("\n\t\t\t\t\tLog-In Details :  ");
				scanner.nextLine();
				System.out.print("\t\t\t\t\tusername : ");
				String username = scanner.nextLine();
				System.out.print("\t\t\t\t\tpassword : ");
				String pass = scanner.nextLine();
				System.out.format(
						"-----------------------------------------------------------------------------------------------------------------------------------");
				for (String string1 : usernameAndPassword.getUsername()) {
					for (String string2 : usernameAndPassword.getPassword()) {
						if (username.equals(string1) && pass.equals(string2)) {
							if (username.equals("admin") && pass.equals("admin@123")) {
								OperationOnProduct.productOperation();
							} else {
								System.out.println("\t\t\t\t\tuser login successfull...");
								ProductList.getProductNameList();
								ProductList.getfullProductData();
								Cart.generteCartList();
							}
						}
					}
				}
			}
			System.out.println("\n\t\t\t\t\tLog-In press 2: ");
			userInt = scanner.nextInt();
		}
	}

	public static void main(String[] args) throws SQLException {
		getLogIn();
	}
}
