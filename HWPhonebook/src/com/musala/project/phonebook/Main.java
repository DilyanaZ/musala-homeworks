package com.musala.project.phonebook;

public class Main {

	public static void main(String[] args) {
		 PhoneBook ph = new PhoneBook();
		 ph.createNewPhonebook("phonebook.txt");
		
		 ph.printAll();
		 System.out.println();
		 
		 call(ph, "Pencho", 3);
		 call(ph, "Gencho", 2);
		 call(ph, "Petkan", 4);
		 call(ph, "Spas", 7);
		 call(ph, "Ivan", 10);
		 
		 ph.printFiveMostCalled();
	}
	
	private static void call(PhoneBook ph, String name, int numberOfCalls) {
		PhoneBookContact contact = ph.accessContactByName(name);
		if(contact != null) {
			for(int i = 0; i <= numberOfCalls; i++) {
				contact.call();
			}
		}
	}

}
