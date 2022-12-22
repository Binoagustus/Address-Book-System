package com.addressBook;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

	public void createpersonByCategory(List<Contact> groupList) {

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

	public void sortByName(Map<String, List<Contact>> addressBook) {
		
		for (Map.Entry<String, List<Contact>> set : (addressBook).entrySet()) {
			set.getValue().stream().sorted((o1, o2) -> o1.getFirstName().compareTo(o2.getFirstName()));
			System.out.println(set.getKey());
			System.out.println(set.getValue());
		}
	}
	
	public void sortByState(Map<String, List<Contact>> addressBook) {
		
		for (Map.Entry<String, List<Contact>> set : (addressBook).entrySet()) {
			set.getValue().stream().sorted((o1, o2) -> o1.getState().compareTo(o2.getState()));
			System.out.println(set.getKey());
			System.out.println(set.getValue());
		}
	}

	public void sortByCity(Map<String, List<Contact>> addressBook) {
		
		for (Map.Entry<String, List<Contact>> set : (addressBook).entrySet()) {
			set.getValue().stream().sorted((o1, o2) -> o1.getCity().compareTo(o2.getCity()));
			System.out.println(set.getKey());
			System.out.println(set.getValue());
		}
	}

	public void sortByZip(Map<String, List<Contact>> addressBook) {
		
		for (Map.Entry<String, List<Contact>> set : (addressBook).entrySet()) {
			Stream<Contact> tempBookContacts = set.getValue().stream().sorted(Comparator.comparingInt(Contact::getZip));
			System.out.println(set.getKey());
			tempBookContacts.forEach(System.out::println);
		}
	}
}
