package com.cutomerdetails;

import java.util.Scanner;

public class InsertCustomerDetailsIntoDB {
	
	public static void main(String[] args) {
		
		Customer customer = new Customer();
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("enter cid: ");
		int cid = scanner.nextInt();
		System.out.print("enter firstname: ");
		String firstname = scanner.next();
		System.out.print("enter lastname: ");
		String lastname = scanner.next();
		System.out.print("enter street: ");
		String street = scanner.next();
		System.out.print("enter city: ");
		String city = scanner.next();
		System.out.print("enter state: ");
		String state = scanner.next();
		System.out.print("enter zipcode: ");
		int zipcode = scanner.nextInt();
		System.out.print("enter product_name: ");
		String product_name = scanner.next();
		System.out.print("enter created_by: ");
		String created_by = scanner.next();
		
		customer.setCid(cid);
		customer.setFirstname(firstname);
		customer.setLastname(lastname);
		customer.setStreet(street);
		customer.setCity(city);
		customer.setState(state);
		customer.setZipcode(zipcode);
		customer.setProduct_name(product_name);
		customer.setCreated_by(created_by);
		
		DBConnectionInsertCustomerDetails dbConnectionInsertCustomerDetails = new DBConnectionInsertCustomerDetails();
		dbConnectionInsertCustomerDetails.insertCustomerDetails(customer);
		System.out.println("Customer details inserted successfully...");
		
	}
}
