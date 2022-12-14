package com.addressBook;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BookOperations {

	Map<String, List<Contact>> personByCity = new HashMap<String, List<Contact>>();
	Map<String, List<Contact>> personByState = new HashMap<String, List<Contact>>();
	Scanner sc = new Scanner(System.in);
	String firstName;
	String lastName;

	public void searchPersonByCity(String searchCity, Map<String, List<Contact>> addressBooks) {

		System.out.println("Enter First Name");
		firstName = sc.next();
		System.out.println("Enter Last Name");
		lastName = sc.next();

		for (Map.Entry<String, List<Contact>> set : addressBooks.entrySet()) {
			set.getValue().stream().filter(ctct -> ctct.getCity().equalsIgnoreCase(searchCity)
					&& ctct.getFirstName().equalsIgnoreCase(firstName) && ctct.getLastName().equalsIgnoreCase(lastName))
					.map(ctct -> ctct).forEach(System.out::println);
		}
	}

	public void searchPersonByState(String searchState, Map<String, List<Contact>> addressBooks) {

		System.out.println("Enter First Name");
		firstName = sc.next();
		System.out.println("Enter Last Name");
		lastName = sc.next();

		for (Map.Entry<String, List<Contact>> set : addressBooks.entrySet()) {
			set.getValue().stream().filter(ctct -> ctct.getState().equalsIgnoreCase(searchState)
					&& ctct.getFirstName().equalsIgnoreCase(firstName) && ctct.getLastName().equalsIgnoreCase(lastName))
					.map(ctct -> ctct).forEach(System.out::println);
		}
	}

	public void personByCategory(List<Contact> groupList) {

		personByCity = groupList.stream().collect(Collectors.groupingBy(Contact::getCity));

		personByState = groupList.stream().collect(Collectors.groupingBy(Contact::getState));

	}

	public void countByCity() {
		for (Map.Entry<String, List<Contact>> set : (personByCity).entrySet()) {
			System.out.print(set.getKey() + " city = " + set.getValue().stream().count() + " contacts\n");
		}
	}

	public void countByState() {
		for (Map.Entry<String, List<Contact>> set : (personByState).entrySet()) {
			System.out.print(set.getKey() + " state = " + set.getValue().stream().count() + " contacts\n");
		}
	}

	public void showPersonByCity() {
		for (Map.Entry<String, List<Contact>> set : (personByCity).entrySet()) {
			System.out.println(set.getKey());
			System.out.println(set.getValue());
		}
	}

	public void showPersonByState() {
		for (Map.Entry<String, List<Contact>> set : (personByState).entrySet()) {
			System.out.println(set.getKey());
			System.out.println(set.getValue());
		}
	}
}
