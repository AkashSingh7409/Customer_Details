package com.cutomerdetails;

import java.util.Scanner;

public class DeleteCustomerDetailsInDB {

	public static void main(String[] args) {
		
		Customer customer = new Customer();
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("enter cid: ");
		int cid = scanner.nextInt();
		customer.setCid(cid);
		
		DBConnectionDeleteCustomerDetails dbConnectionDeleteCustomerDetails = new DBConnectionDeleteCustomerDetails();
		dbConnectionDeleteCustomerDetails.deleteCustomerDetails(customer);
	    System.out.println("Deleted customer details succesfully...");			
	}

}
