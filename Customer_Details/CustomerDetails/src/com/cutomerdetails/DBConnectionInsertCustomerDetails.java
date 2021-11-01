package com.cutomerdetails;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;

public class DBConnectionInsertCustomerDetails {
	
	public int insertCustomerDetails(Customer Customer) {
		
		int count = 0;
		Calendar calendar = Calendar.getInstance();
	    Date currentDate = new Date(calendar.getTime().getTime());
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			String sql = "insert into customer_details values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());			
			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "c##bms", "akash");
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, Customer.getCid());
			preparedStatement.setString(2, Customer.getFirstname());
			preparedStatement.setString(3, Customer.getLastname());
			preparedStatement.setString(4, Customer.getStreet());
			preparedStatement.setString(5, Customer.getCity());
			preparedStatement.setString(6, Customer.getState());
			preparedStatement.setInt(7, Customer.getZipcode());
			preparedStatement.setString(8,  Customer.getProduct_name());
			preparedStatement.setString(9, Customer.getCreated_by());
			preparedStatement.setDate(10, currentDate);
			preparedStatement.setString(11, null);
			preparedStatement.setDate(12, null);
			count = preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
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
		}
		
		return count;		
	}
	
}
