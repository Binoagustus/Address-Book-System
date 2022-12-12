package com.addressBook;

import java.util.ArrayList;

public interface AddressBookOperable {

	public abstract void bookAddOperation();
	
	public abstract ArrayList<Contact> addContact(String bookName);
	
	public abstract void editContact(String bookName);
	
	public abstract void displayBook(String bookName);
	
	public abstract void displayContact(String bookName);
	
	public abstract void deleteContact(String bookName);
	
	public abstract void searchOperations();
	
	public abstract void showBooks();
}
