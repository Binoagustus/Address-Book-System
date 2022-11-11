package com.addressBook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class AddressBookMain {

	String bookName;
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
	HashMap<String, ArrayList<Contacts>> addressBooks = new HashMap<String, ArrayList<Contacts>>();

	// Add Multiple Contacts
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
		System.out.println("\n Enter the Book Name to add the contact ");
		bookName = sc.next();

		if (addressBooks.containsKey(bookName)) {
			addressBooks.put(bookName, bookList);
			System.out.println(" Added a contact to " + bookName);
		} else {
			addressBooks.put(bookName, bookList);
			System.out.println(" New book " + bookName + " is created");
			System.out.println(" Contact is added to " + bookName);
		}
	}

	// Display all Contacts
	public void displayallContact() {

		for (int i = 0; i < bookList.size(); i++) {

			System.out.println("Name : " + bookList.get(i).getFirstName() + " " + bookList.get(i).getLastName());
			System.out.println("Address : " + bookList.get(i).getAddress());
			System.out.println("City and State : " + bookList.get(i).getCity() + ", " + bookList.get(i).getState());
			System.out.println("Zip : " + bookList.get(i).getZip());
			System.out.println("Phone Number : " + bookList.get(i).getPhoneNumber());
			System.out.println("Mail id : " + bookList.get(i).getMail() + "\n");

		}
	}

	// Display a single contact
	public void displayaContact() {
		System.out.println("Enter first name and last name to diplay the contact details");
		String personFirstName = sc.next();
		String personLastName = sc.next();

		if (bookList.size() > 0) {
			for (int i = 0; i < bookList.size(); i++) {
				if ((bookList.get(i).getFirstName().equalsIgnoreCase(personFirstName))
						&& (bookList.get(i).getLastName().equalsIgnoreCase(personLastName))) {

					System.out
					.println("Name : " + bookList.get(i).getFirstName() + " " + bookList.get(i).getLastName());
					System.out.println("Address : " + bookList.get(i).getAddress());
					System.out.println(
							"City and State : " + bookList.get(i).getCity() + ", " + bookList.get(i).getState());
					System.out.println("Zip : " + bookList.get(i).getZip());
					System.out.println("Phone Number : " + bookList.get(i).getPhoneNumber());
					System.out.println("Mail id : " + bookList.get(i).getMail() + "\n");
					break;

				} else {
					System.out.println("Enter a correct name to Display the contact \n");
					break;
				}
			}
		} else {
			System.out.println("Address Book is empty");
		}
	}

	// Edit a contact using firstName as input from user
	public void editContact() {

		System.out.println("\n Enter the First Name and Last Name of person to edit ");
		String personFirstName = sc.next();
		String personLastName = sc.next();

		if (bookList.size() > 0) {
			for (int i = 0; i < bookList.size(); i++) {
				boolean check = ((bookList.get(i).getFirstName().equalsIgnoreCase(personFirstName))
						&& (bookList.get(i).getLastName().equalsIgnoreCase(personLastName)));
				if (check) {
					System.out.println(
							"\n 1 Edit First Name \n 2 Edit Last Name \n 3 Edit Address "
							+ "\n 4 Edit City \n 5 Edit State \n 6 Edit Zip \n 7 Edit PhoneNumber \n 8 Edit Mail");
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

	// Delete a contact by getting firstName as user input
	public void deleteContact() {

		System.out.println("Enter first name and last name to delete the contact");
		String personFirstName = sc.next();
		String personLastName = sc.next();

		if (bookList.size() > 0) {
			for (int i = 0; i < bookList.size(); i++) {
				if ((bookList.get(i).getFirstName().equalsIgnoreCase(personFirstName))
						&& (bookList.get(i).getLastName().equalsIgnoreCase(personLastName))) {

					bookList.remove(i);
					System.out.println("Contact is deleted");
					break;

				}
			}
		} else {
			System.out.println("Address Book is empty");
		}
	}

	public void showBookName() {

		for(String keys : addressBooks.keySet()) {
			System.out.println(keys + " ");
		}
	}

	public static void main(String[] args) {

		AddressBookMain mainObj = new AddressBookMain();
		System.out.println("Welcome to Address Book Program");
		Scanner switchIn = new Scanner(System.in);
		boolean run = true;

		while (run) {
			System.out.println("\n Enter 1 to Add a Contact \n Enter 2 to Edit a Contact "
					+ "\n Enter 3 to Display all Contact \n Enter 4 to Display single Contact "
					+ "\n Enter 5 to Delete a Contact \n Enter 6 to Display Books present \n Enter 7 to exit");
			int input = switchIn.nextInt();
			switch (input) {

			case 1:
				mainObj.addContact();
				break;

			case 2:
				mainObj.editContact();
				break;

			case 3:
				mainObj.displayallContact();
				break;

			case 4:
				mainObj.displayaContact();
				break;

			case 5:
				mainObj.deleteContact();
				break;

			case 6:
				mainObj.showBookName();
				break;

			case 7:
				run = false;
				break;

			}
		}
	}
}
