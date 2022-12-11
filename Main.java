package com.addressBook;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		AddressBook mainObj = new AddressBook();
		System.out.println("Welcome to Address Book Program");
		Scanner sc = new Scanner(System.in);
		boolean run = true;
		String bookName;

		while (run) {
			System.out.println("\n Enter 1 to Add a Contact \n Enter 2 to Edit a Contact "
					+ "\n Enter 3 to Display a Book \n Enter 4 to Display single Contact "
					+ "\n Enter 5 to Delete a Contact \n Enter 6 to Display Books present \n Enter 7 to exit");
			int input = sc.nextInt();
			
			switch (input) {
			case 1:
				mainObj.bookOperations();
				break;

			case 2:
				System.out.println("Enter the Book Name");
				bookName = sc.next().toUpperCase();
				mainObj.editContact(bookName);
				break;

			case 3:
				System.out.println("Enter the Book Name");
				bookName = sc.next().toUpperCase();
				mainObj.displayBook(bookName);
				break;

			case 4:
				System.out.println("Enter the Book Name");
				bookName = sc.next().toUpperCase();
				mainObj.displayContact(bookName);
				break;

			case 5:
				System.out.println("Enter the Book Name");
				bookName = sc.next().toUpperCase();
				mainObj.deleteContact(bookName);
				break;

			case 6:
				mainObj.showBooks();
				break;

			case 7:
				run = false;
				break;
			}
		}
	}
}
