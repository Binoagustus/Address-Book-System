package com.addressBook;

public class Contacts {
	private String firstName;
	private String lastName;
	private String address;
	private String city;
	private String state;
	private int zip;
	private long phoneNumber;
	private String mail;

	public Contacts(String firstName, String lastName, String address, String city, String state, int zip,
			long phoneNumber, String mail) {

		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.phoneNumber = phoneNumber;
		this.mail = mail;
	}

	@Override
	public String toString() {
		return " Name = " + firstName + " " + lastName + "\n address = " + address + "\n city = " + city + "\n state = "
				+ state + "\n zip = " + zip + "\n phoneNumber = " + phoneNumber + "\n mail = " + mail;
	}

}
