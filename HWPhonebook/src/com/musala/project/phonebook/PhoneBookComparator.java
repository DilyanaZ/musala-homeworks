package com.musala.project.phonebook;

import java.util.Comparator;
import java.util.Map.Entry;

public class PhoneBookComparator implements Comparator<Entry<String, PhoneBookContact>> {

	@Override
	public int compare(Entry<String, PhoneBookContact> entry1, Entry<String, PhoneBookContact> entry2) {

		PhoneBookContact contact1 = entry1.getValue();
		PhoneBookContact contact2 = entry2.getValue();
		
		if (contact1.getNumberOfCalls() > contact2.getNumberOfCalls()) {
			return -1;//We want to sort in descending order
		}

		if (contact1.getNumberOfCalls() < contact2.getNumberOfCalls()) {
			return 1;//We want to sort in descending order
		}

		return 0;
	}
}
