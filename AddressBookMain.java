package com.addressBook;

public class AddressBookMain {

	public static void main(String[] args) {
		System.out.println("Welcome to Address Book Program");
		Contacts contact = new Contacts();
		contact.setFirstName("Bino");
		contact.setLastName("Agustus");
		contact.setAddress("13th Street ASHER");
		contact.setCity("Tirunelveli");
		contact.setState("Tamil Nadu");
		contact.setZip(627005);
		contact.setPhoneNumber(1234560789);
		contact.setMail("bino@gmail.com");
		System.out.println("Name : " + contact.getFirstName() + " " + contact.getLastName());
		System.out.println("Address : " + contact.getAddress());
		System.out.println("City and State : " + contact.getCity() + " " + contact.getState());
		System.out.println("Zip : " + contact.getZip());
		System.out.println("Phone Number : " + contact.getPhoneNumber());
		System.out.println("Mail id : " + contact.getMail());
	}

}
