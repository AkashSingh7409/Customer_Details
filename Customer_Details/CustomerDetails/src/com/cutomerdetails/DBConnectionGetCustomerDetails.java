package com.cutomerdetails;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DBConnectionGetCustomerDetails {

	public ArrayList<Customer> getCustomerDetails() {
		
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		ArrayList<Customer> customerList = null;
		
		try {
			
			String sql = "Select * from customer_details";
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "c##bms", "akash");
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			customerList = new ArrayList<Customer>();
			while(resultSet.next()) {
				Customer customer = new Customer();
				customer.setCid(resultSet.getInt(1));
				customer.setFirstname(resultSet.getString(2));
				customer.setLastname(resultSet.getString(3));
				customer.setStreet(resultSet.getString(4));
				customer.setCity(resultSet.getString(5));
				customer.setState(resultSet.getString(6));
				customer.setZipcode(resultSet.getInt(7));
				customer.setProduct_name(resultSet.getString(8));
				customer.setCreated_by(resultSet.getString(9));
				customer.setCreated_on(resultSet.getDate(10));
				customer.setUpdated_by(resultSet.getString(11));
				customer.setUpdated_on(resultSet.getDate(12));
				customerList.add(customer);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return customerList;	
	}	
}
