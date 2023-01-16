package com.userpurchase;

import java.util.ArrayList;
//Auhor-- Group x

class ProductData {

	static int id;
	static String name;
	static float price;
	static int quantity;

	public ProductData(int id, String name, int quantity,int price) {
		this.id = id;
		this.name = name;
		this.quantity = quantity;
	}

	public static int getId() {
		return id;
	}

	public static String getName() {
		return name;
	}

	public static float getPrice() {
		return price;
	}

	public static int getQuantity() {
		return quantity;
	}

	public static void displayFormat() {
		System.out.format(
				"-----------------------------------------------------------------------------------------------------------------------------------");
		System.out.print("\nProduct ID \t\tName\t\t\t\t \t\t\t\t\t\t\t\t\t\t\tPrice\n");
		System.out.format(
				"-----------------------------------------------------------------------------------------------------------------------------------\n");
	}
	public static void buyDisplayFormat() {
		System.out.format(
				"-----------------------------------------------------------------------------------------------------------------------------------");
		System.out.print("\nProduct ID \t\tName\t\t\t\t \t\t\t\t\t\t\t\t\t\t\tQuantity\t\t\t\t\t\t\t\t\t\tPrice\n");
		System.out.format(
				"-----------------------------------------------------------------------------------------------------------------------------------\n");
	}
	// display
	public void display() {
		System.out.format("   %-9s             %-100s      %30d              %40s \n", id, name, quantity,price);
	}

}
