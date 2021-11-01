package com.cutomerdetails;

import java.util.Scanner;

public class UpdateCustomerDetailsToDB {

	public static void main(String[] args) {
		
		Customer customer = new Customer();
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("enter cid: ");
		int cid = scanner.nextInt();
		System.out.print("enter street: ");
		String street = scanner.next();
		System.out.print("enter city: ");
		String city = scanner.next();
		System.out.print("enter zipcode: ");
		int zipcode = scanner.nextInt();
		System.out.print("enter product_name: ");
		String product_name = scanner.next();
		System.out.print("enter updated_by: ");
		String updated_by = scanner.next();
		
		customer.setCid(cid);
		customer.setStreet(street);
		customer.setCity(city);
		customer.setZipcode(zipcode);
		customer.setProduct_name(product_name);
		customer.setUpdated_by(updated_by);
		
		DBCOnnectionUpdateCustomerDetails dbCOnnectionUpdateCustomerDetails = new DBCOnnectionUpdateCustomerDetails();
		dbCOnnectionUpdateCustomerDetails.updateCustomerDetails(customer);
		System.out.println("Updated customer details successfully...");
		
	}
}
