package com.userpurchase;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
//Author--Group x

public class BuyProduct {
	static int quantity = 0;

	static public void getData(List<ProductData> list, int totalPrice) {
		ArrayList<ProductData> values = new ArrayList<ProductData>();
		System.out.println("\t\t\t\t--------------------Invoice-----------------");
		System.out.println("\t\t\t\t\t " + "  " + "'Amazon Online shopping");

		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = new Date(quantity);
		Calendar calendar = Calendar.getInstance();
		String[] days = new String[] { "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" };
		// prints current date and time
		System.out.println("Date: " + formatter.format(date) + "  " + days[calendar.get(Calendar.DAY_OF_WEEK) - 1]
				+ "\t\t\t\t\t\t");
		System.out.format(
				"-----------------------------------------------------------------------------------------------------------------------------------");
		System.out.print("\nProduct Name\t\t\t\t\t\t\t\t\t\tQuantity\t\t\t\t\t\n");
		System.out.format(
				"-----------------------------------------------------------------------------------------------------------------------------------\n");

		for (ProductData p : values) {
			System.out.format("   %-9s             %-100s      %40d               \n", p.getId(), p.getName(),
					p.getQuantity());
		}
		System.out.format("\nTotal Price %10d  Rs.", totalPrice);
		System.out.println("\n\t\t\t\t----------------Thank You for Shopping!!-----------------");
		System.out.println("\n\t\t\t\t                     Visit Again");
	}

	public static void buyProduct(ArrayList list, int totalPrice) {

		List<ProductData> buy = new ArrayList<ProductData>();
		buy.addAll(list);
		getData(buy, totalPrice);
	}
}
