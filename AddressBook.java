package com.addressBook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AddressBook implements AddressBookOperable {

	String firstName;
	String lastName;
	String address;
	String city;
	String state;
	int zip;
	String phoneNumber;
	String mail;

	Scanner sc = new Scanner(System.in);
	BookOperations operations = new BookOperations();
	Map<String, List<Contact>> addressBooks = new HashMap<String, List<Contact>>();
	List<Contact> groupList = new ArrayList<Contact>();
	
	@Override
	public List<Contact> addContact(String bookName) {

		Contact contact = new Contact();
		List<Contact> contacts = new ArrayList<Contact>();

		System.out.println("Enter First Name ");
		firstName = sc.next();

		System.out.println("Enter Last Name ");
		lastName = sc.next();

		boolean isDuplicateFound = false;
		boolean isBookNotPresent = false;
		isBookNotPresent = addressBooks.get(bookName) == null;

		try {
			if ((!(addressBooks.isEmpty())) && !(isBookNotPresent)) {
				isDuplicateFound = addressBooks.get(bookName).stream()
						.anyMatch(cs -> cs.getFirstName().equalsIgnoreCase(firstName)
								&& cs.getLastName().equalsIgnoreCase(lastName));
			}
		} catch (NullPointerException e) {
			e.printStackTrace();
		}

		if (isDuplicateFound == false) {

			contact.setFirstName(firstName);
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
			phoneNumber = sc.next();
			contact.setPhoneNumber(phoneNumber);

			System.out.println("Enter mail id ");
			mail = sc.next();
			contact.setMail(mail);

			contacts.add(contact);

		} else if (isDuplicateFound == true) {

			return null;
		}
		return contacts;
	}

	// Edit a contact using Name as input from user
	@Override
	public void editContact(String bookName) {

		boolean isBookPresent = isBookPresent(bookName);

		System.out.println("\n Enter the First Name and Last Name of person to edit ");
		String personFirstName = sc.next();
		String personLastName = sc.next();

		if (isBookPresent) {
			boolean isFound = false;

			List<Contact> contacts = addressBooks.get(bookName).stream().collect(Collectors.toList());

			for (int i = 0; i < contacts.size(); i++) {
				boolean check = ((contacts.get(i).getFirstName().equalsIgnoreCase(personFirstName))
						&& (contacts.get(i).getLastName().equalsIgnoreCase(personLastName)));

				if (check) {
					System.out.println("\n 1 Edit First Name \n 2 Edit Last Name \n 3 Edit Address "
							+ "\n 4 Edit City \n 5 Edit State \n 6 Edit Zip \n 7 Edit PhoneNumber \n 8 Edit Mail");
					int input = sc.nextInt();
					isFound = true;
					switch (input) {
					case 1:
						System.out.println("Enter new First Name ");
						contacts.get(i).setFirstName(sc.next());
						break;

					case 2:
						System.out.println("Enter new Last Name");
						contacts.get(i).setLastName(sc.next());
						break;

					case 3:
						System.out.println("Enter new Address");
						contacts.get(i).setAddress(sc.next());
						break;

					case 4:
						System.out.println("Enter new City");
						contacts.get(i).setCity(sc.next());
						break;

					case 5:
						System.out.println("Enter new State");
						contacts.get(i).setState(sc.next());
						break;

					case 6:
						System.out.println("Enter new Zip");
						contacts.get(i).setZip(sc.nextInt());
						break;

					case 7:
						System.out.println("Enter new Phone Number");
						contacts.get(i).setPhoneNumber(sc.nextLine());
						break;

					case 8:
						System.out.println("Enter new Mail id");
						contacts.get(i).setMail(sc.next());
						break;
					}
				}
			}
			if (!isFound) {
				System.out.println("Contact not found");
			}
		} else {
			System.out.println("Address Book is empty");
		}
	}

	// Display all Contacts
	@Override
	public void displayBook(String bookName) {
		addressBooks.keySet().stream().filter(book -> book.equals(bookName)).map(book -> addressBooks.get(bookName))
				.forEach(System.out::println);

	}

	// Display a single contact
	@Override
	public void displayContact(String bookName) {
		System.out.println("Enter first name and last name to diplay the contact details");
		String personFirstName = sc.next();
		String personLastName = sc.next();
		boolean isFound = false;
		boolean isBookPresent = isBookPresent(bookName);

		if (isBookPresent) {
			List<Contact> contacts = addressBooks.get(bookName).stream().collect(Collectors.toList());

			for (int i = 0; i < contacts.size(); i++) {
				if ((contacts.get(i).getFirstName().equalsIgnoreCase(personFirstName))
						&& (contacts.get(i).getLastName().equalsIgnoreCase(personLastName))) {
					isFound = true;
					System.out
							.println("Name : " + contacts.get(i).getFirstName() + " " + contacts.get(i).getLastName());
					System.out.println("Address : " + contacts.get(i).getAddress());
					System.out.println(
							"City and State : " + contacts.get(i).getCity() + ", " + contacts.get(i).getState());
					System.out.println("Zip : " + contacts.get(i).getZip());
					System.out.println("Phone Number : " + contacts.get(i).getPhoneNumber());
					System.out.println("Mail id : " + contacts.get(i).getMail() + "\n");

				}
			}
			if (!isFound) {
				System.out.println("Enter a correct name to Display the contact \n");
			}

		} else {
			System.out.println("Address Book is not present");
		}
	}

	// Delete a contact by getting firstName as user input
	@Override
	public void deleteContact(String bookName) {

		System.out.println("Enter first name and last name to delete the contact");
		String personFirstName = sc.next();
		String personLastName = sc.next();
		boolean isBookPresent = isBookPresent(bookName);
		String userChoice;

		if (isBookPresent) {
			List<Contact> contacts = addressBooks.get(bookName).stream().collect(Collectors.toList());

			for (int i = 0; i < contacts.size(); i++) {
				if ((contacts.get(i).getFirstName().equalsIgnoreCase(personFirstName))
						&& (contacts.get(i).getLastName().equalsIgnoreCase(personLastName))) {

					do {
						addressBooks.get(bookName).remove(i);
						System.out.println("contact deleted");
						System.out.println("Are you wish to delete other Address fields: Y?N");
						userChoice = sc.next();
					} while (userChoice.toUpperCase().equals("Y"));
				}
			}
		} else {
			System.out.println("Address Book is empty");
		}
	}

	public boolean isBookPresent(String bookName) {

		boolean isBookPresent = false;

		try {
			isBookPresent = addressBooks.containsKey(bookName);

		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		return isBookPresent;
	}

	@Override
	public void bookAddOperation() {

		System.out.println("Enter the Book Name ");
		String bookName = sc.next().toUpperCase();
		List<Contact> contactList = this.addContact(bookName);
		
		if (addressBooks.containsKey(bookName.toUpperCase())) {
			try {
				if (contactList == null) {
					System.out.println("Contact of person is already present in book");

				} else {
					addressBooks.get(bookName).addAll(contactList);
					System.out.println(" Added a contact to " + bookName);
				}
			} catch (NullPointerException e) {
				e.printStackTrace();
			}

		} else {
			addressBooks.put(bookName, contactList);
			System.out.println(" New book " + bookName + " is created");
			System.out.println(" Contact is added to " + bookName);
		}
		
		// Adding all values of addressBook to groupList and create maps needed
		groupList.addAll(contactList);
		operations.createpersonByCategory(groupList);
	}

	@Override
	public void searchOperations() {

		boolean run = true;
		while (run) {
			System.out.println("1.Search By City \n2.Search By State \n3.Exit to Main Menu");
			byte input = sc.nextByte();
			String cityName, stateName;

			switch (input) {
			case 1:
				System.out.println("Enter City");
				cityName = sc.next();
				operations.searchPersonByCity(cityName, addressBooks);
				break;

			case 2:
				System.out.println("Enter State");
				stateName = sc.next();
				operations.searchPersonByState(stateName, addressBooks);
				break;

			case 3:
				run = false;
				break;
			}
		}
	}

	@Override
	public void showBooks() {

		boolean run = true;
		while(run) {
			System.out.println("*******Contacts View By Category******");
			System.out.println("1.Show All AddressBooks \n2.Show Person By City \n3.Show Person By State \n4.Exit to main menu");
			int input = sc.nextInt();
			
			switch(input) {
			case 1:
				for (Map.Entry<String, List<Contact>> set : addressBooks.entrySet()) {
					System.out.println(set.getKey());
					System.out.println(set.getValue());
				}
				break;
				
			case 2:
				operations.showPersonByCity();
				break;
				
			case 3:
				operations.showPersonByState();
				break;
				
			case 4:
				run = false;
				break;
			}
		}
	}
	
	@Override
	public void countContactsByCategory() {
		
		boolean run = true;
		while(run) {
			System.out.println("********Contacts Count By Category********");
			System.out.println("1.Count By City \n2.Count By State \n3.Exit");
			int input = sc.nextInt();
			
			switch(input) {
			case 1:
				operations.countByCity();
				break;
				
			case 2:
				operations.countByState();
				break;
				
			case 3:
				run = false;
				break;
			}
		}
	}
	
	@Override
	public void sortContactsByCategory() {
	
		boolean run = true;
		while(run) {
			System.out.println("********Sort Contacts By Category********");
			System.out.println("1.Sort By Name \n2.Exit ");
			int input = sc.nextInt();
			
			switch(input) {
			case 1:
				operations.sortByName(addressBooks);
				break;
				
			case 2:
				run = false;
				break;
			}
		}
	}
}
