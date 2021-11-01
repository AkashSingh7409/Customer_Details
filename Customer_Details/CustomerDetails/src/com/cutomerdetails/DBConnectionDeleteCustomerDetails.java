package com.cutomerdetails;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBConnectionDeleteCustomerDetails {

	public int deleteCustomerDetails(Customer Customer) {
		
		int count = 0;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			
			String sql = "delete from customer_details where cid = ?";
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());			
			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "c##bms", "akash");
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, Customer.getCid());
			count = preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
		
	}
	
}
