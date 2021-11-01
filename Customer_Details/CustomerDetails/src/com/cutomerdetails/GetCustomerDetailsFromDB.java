package com.cutomerdetails;

import java.util.ArrayList;

public class GetCustomerDetailsFromDB {

	public static void main(String[] args) {
		
		DBConnectionGetCustomerDetails dBConnectionGetCustomerDetails = new DBConnectionGetCustomerDetails();
		ArrayList<Customer> customer = dBConnectionGetCustomerDetails.getCustomerDetails();
		
		customer.forEach(result -> {
			System.out.println("cid: " + result.getCid() + ", firstname: " + result.getFirstname() + 
			", lastname: " + result.getLastname() + ", street: " + result.getStreet() +
			", city: " + result.getCity() + ", state: " + result.getState() +
			", zipcode: " + result.getZipcode() + ", product_name: " + result.getProduct_name() + 
			", created_by: " + result.getCreated_by() + ", created_on: " + result.getCreated_on() +
			", updated_by: " + result.getUpdated_by() + ", update_on: " + result.getUpdated_on());
		});
		System.out.println("Get customer details successfully...");
	}
}
