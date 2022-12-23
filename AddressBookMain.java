package com.addressBook;

import java.util.InputMismatchException;
import java.util.Scanner;

public class AddressBookMain {

	public static void main(String[] args) {

		AddressBookMain start = new AddressBookMain();
		System.out.println("Welcome to Address Book Program");
		start.menu();
	}
	
	public void menu() {
		
		AddressBook bookObj = new AddressBook();
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		boolean run = true;
		String bookName;
		
		while (run) {
			
			System.out.println("************Main Menu************");
			System.out.println(" 1.Add a Contact \n 2.Edit a Contact "
					+ "\n 3.Display a Book \n 4.Display single Contact "
					+ "\n 5.Delete a Contact \n 6.Search Person " 
					+ "\n 7.Display Books present \n 8.Count Contacts"
					+ "\n 9.Sort Person \n 10.Write To File \n 11.Exit");

			try {
				int input = sc.nextInt();
				switch (input) {
				case 1:
					bookObj.bookAddOperation();
					break;

				case 2:
					System.out.println("Enter the Book Name");
					bookName = sc.next().toUpperCase();
					bookObj.editContact(bookName);
					break;

				case 3:
					System.out.println("Enter the Book Name");
					bookName = sc.next().toUpperCase();
					bookObj.displayBook(bookName);
					break;

				case 4:
					System.out.println("Enter the Book Name");
					bookName = sc.next().toUpperCase();
					bookObj.displayContact(bookName);
					break;

				case 5:
					System.out.println("Enter the Book Name");
					bookName = sc.next().toUpperCase();
					bookObj.deleteContact(bookName);
					break;

				case 6:
					bookObj.searchOperations();
					break;

				case 7:
					bookObj.showBooks();
					break;

				case 8:
					bookObj.countContactsByCategory();
					break;
					
				case 9:
					bookObj.sortContactsByCategory();
					break;
					
				case 10:
					bookObj.writeToFile();
					break;
					
				case 11:
					run = false;
					break;
				}

			} catch (InputMismatchException e) {
				System.out.println("Input integer values only");
				sc.nextLine();
			}
		}
	}
}
