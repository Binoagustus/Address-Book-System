package com.addressBook;

import java.util.ArrayList;

import java.util.Scanner;

public class AddressBookMain {

	public static void main(String[] args) {
		String firstName;
		String lastName;
		String address;
		String city;
		String state;
		int zip;
		long phoneNumber;
		String mail;

		System.out.println("Welcome to Address Book Program");
		Scanner sc = new Scanner(System.in);
		ArrayList<Contacts> book = new ArrayList<Contacts>();

//		Adding two contacts using Array List
		for (int i = 0; i < 2; i++) {
			
			System.out.println("Enter First Name ");
			firstName = sc.next();

			System.out.println("Enter Last Name ");
			lastName = sc.next();

			System.out.println("Enter Address ");
			address = sc.next();

			System.out.println("Enter City ");
			city = sc.next();

			System.out.println("Enter State ");
			state = sc.next();

			System.out.println("Enter Zip ");
			zip = sc.nextInt();

			System.out.println("Enter Phone Number ");
			phoneNumber = sc.nextLong();

			System.out.println("Enter mail id ");
			mail = sc.next();

			book.add(new Contacts(firstName, lastName, address, city, state, zip, phoneNumber, mail));
			System.out.println("\nAdd Contact "+i);
		}
		System.out.print(book.get(0)+"\n\n");
		System.out.println(book.get(1));

	}

}
