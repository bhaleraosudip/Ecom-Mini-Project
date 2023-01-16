package com.adminserver;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.registration.UserConnection;

//Author -- Group x
class QuantityCheck {
	 static void checkQuantity() {
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		int totalQuantity=0;
		try {
			preparedStatement=UserConnection.getConnection().prepareStatement("select quantity from fashion");
			resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				totalQuantity=totalQuantity+resultSet.getInt(1);
			}
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
		System.out.println("\nTotal Quantity of all products is:  "+totalQuantity);
	}
	
}
