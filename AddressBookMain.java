package com.addressBook;

import java.util.ArrayList;

import java.util.Scanner;

public class AddressBookMain {
	String firstName;
	String lastName;
	String address;
	String city;
	String state;
	int zip;
	long phoneNumber;
	String mail;

	Scanner sc = new Scanner(System.in);
	ArrayList<Contacts> bookList = new ArrayList<Contacts>();

	public void addContact() {
		Contacts contact = new Contacts();

		System.out.println("Enter First Name ");
		firstName = sc.next();
		contact.setFirstName(firstName);

		System.out.println("Enter Last Name ");
		lastName = sc.next();
		contact.setLastName(lastName);

		System.out.println("Enter Address ");
		address = sc.next();
		contact.setAddress(address);

		System.out.println("Enter City ");
		city = sc.next();
		contact.setCity(city);

		System.out.println("Enter State ");
		state = sc.next();
		contact.setState(state);

		System.out.println("Enter Zip ");
		zip = sc.nextInt();
		contact.setZip(zip);

		System.out.println("Enter Phone Number ");
		phoneNumber = sc.nextLong();
		contact.setPhoneNumber(phoneNumber);

		System.out.println("Enter mail id ");
		mail = sc.next();
		contact.setMail(mail);

		bookList.add(contact);
	}

	public void displayContact() {
		for (int i = 0; i < bookList.size(); i++) {

			System.out.println("Name : " + bookList.get(i).getFirstName() + " " + bookList.get(i).getLastName());
			System.out.println("Address : " + bookList.get(i).getAddress());
			System.out.println("City and State : " + bookList.get(i).getCity() + " " + bookList.get(i).getState());
			System.out.println("Zip : " + bookList.get(i).getZip());
			System.out.println("Phone Number : " + bookList.get(i).getPhoneNumber());
			System.out.println("Mail id : " + bookList.get(i).getMail() + "\n\n");
		}
	}

	public void editContact() {

		System.out.println("\n Enter the First Name of person to edit ");
		String personName = sc.next();

		if (bookList.size() > 0) {
			System.out.println(
					"\n 1 Edit First Name \n 2 Edit Last Name \n 3 Edit Address \n 4 Edit City \n 5 Edit State \n 6 Edit Zip \n 7 Edit PhoneNumber \n 8 Edit Mail");

			for (int i = 0; i < bookList.size(); i++) {
				if (bookList.get(i).getFirstName().equalsIgnoreCase(personName)) {
					int input = sc.nextInt();

					switch (input) {
					case 1:
						System.out.println("Enter new First Name ");
						bookList.get(i).setFirstName(sc.next());
						break;

					case 2:
						System.out.println("Enter new Last Name");
						bookList.get(i).setLastName(sc.next());
						break;

					case 3:
						System.out.println("Enter new Address");
						bookList.get(i).setAddress(sc.next());
						break;

					case 4:
						System.out.println("Enter new City");
						bookList.get(i).setCity(sc.next());
						break;

					case 5:
						System.out.println("Enter new State");
						bookList.get(i).setState(sc.next());
						break;

					case 6:
						System.out.println("Enter new Zip");
						bookList.get(i).setZip(sc.nextInt());
						break;

					case 7:
						System.out.println("Enter new Phone Number");
						bookList.get(i).setPhoneNumber(sc.nextLong());
						break;

					case 8:
						System.out.println("Enter new Mail id");
						bookList.get(i).setMail(sc.next());
						break;
					}
				}
			}
		} else {
			System.out.println("Address Book is empty");
		}
	}

	public static void main(String[] args) {

		AddressBookMain mainObj = new AddressBookMain();
		System.out.println("Welcome to Address Book Program");
		Scanner switchIn = new Scanner(System.in);
		boolean run = true;

		while (run) {
			System.out.println(
					"\n Enter 1 to Add a Contact \n Enter 2 to Edit a Contact \n Enter 3 to Display all Contact \n Enter 4 to Exit \n");
			int input = switchIn.nextInt();
			switch (input) {

			case 1:
				mainObj.addContact();
				break;

			case 2:
				mainObj.editContact();
				break;

			case 3:
				mainObj.displayContact();
				break;

			case 4:
				run = false;
				break;

			}
		}
	}
}
