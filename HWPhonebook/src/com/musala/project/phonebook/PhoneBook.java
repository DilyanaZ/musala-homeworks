package com.musala.project.phonebook;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class PhoneBook {

	private Map<String, PhoneBookContact> contacts;

	public PhoneBook() {
		contacts = new TreeMap<>();
	}

	public void createNewPhonebook(String fileLocation) {
		File phonebookFile = new File(fileLocation);
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(phonebookFile)))) {
			String line;

			while ((line = reader.readLine()) != null) {

				try {
					PhoneBookContact contact = new PhoneBookContact.Builder().createFromLine(line).build();
					contacts.put(contact.getName(), contact);
				} catch (InvalidPhoneFormatException e) {
					System.out.println(e.getMessage());
				}

			}
		} catch (FileNotFoundException e1) {
			System.out.println("Niama ti go file-a");
		} catch (IOException e) {
			System.out.println("Reader cannot read the line");
		}

	}

	public void addPair(String name, String phoneNum) {

		try {
			PhoneBookContact newContact = new PhoneBookContact.Builder().withName(name).withPhoneNumber(phoneNum)
					.build();
			contacts.put(newContact.getName(), newContact);
		} catch (InvalidPhoneFormatException e) {
			System.out.println(e.getMessage());
		}

	}

	public void removeContact(String key) {
		if (key == null) {
			System.out.println("There is no phonebook entry for that name.");
			return;
		}
		contacts.remove(key);
	}

	public PhoneBookContact accessContactByName(String name) {
		return contacts.get(name);
	}

	public void printAll() {
		// entries.keySet() returns a Set of all keys in the map
		for (String key : contacts.keySet()) {
			PhoneBookContact singleContact = contacts.get(key);
			System.out.println(singleContact);
		}
	}

	public void printFiveMostCalled() {

		PhoneBookComparator comparator = new PhoneBookComparator();

		Set<Entry<String, PhoneBookContact>> mapContacts = contacts.entrySet();

		TreeSet<Entry<String, PhoneBookContact>> sortedMapContacts = new TreeSet<>(comparator);
		sortedMapContacts.addAll(mapContacts);

		int index = 0;
		for (Entry<String, PhoneBookContact> entry : sortedMapContacts) {
			System.out.println(entry.getValue());
			index++;
			if (index == 5) {
				break;
			}
		}
	}
}