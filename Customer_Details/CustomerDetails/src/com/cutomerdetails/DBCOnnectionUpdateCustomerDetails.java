package com.cutomerdetails;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;

public class DBCOnnectionUpdateCustomerDetails {

	public int updateCustomerDetails(Customer Customer) {
		
		int count = 0;
		Calendar calendar = Calendar.getInstance();
	    Date currentDate = new Date(calendar.getTime().getTime());
		
		Connection connection = null;
		PreparedStatement preparedstatement = null;
		
		try {
			String sql = "update customer_details set street = ?, city = ?, zipcode = ?, product_name = ?, updated_by = ?, updated_on = ? where cid = ?";
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "c##bms", "akash");
			preparedstatement = connection.prepareStatement(sql);
			preparedstatement.setString(1, Customer.getStreet());
			preparedstatement.setString(2, Customer.getCity());
			preparedstatement.setInt(3, Customer.getZipcode());
			preparedstatement.setString(4,  Customer.getProduct_name());
			preparedstatement.setString(5, Customer.getUpdated_by());
			preparedstatement.setDate(6, currentDate);
			preparedstatement.setInt(7, Customer.getCid());
			count = preparedstatement.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}			
		
		return count;
		
	}
	
}
