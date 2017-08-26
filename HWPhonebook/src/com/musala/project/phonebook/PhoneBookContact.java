package com.musala.project.phonebook;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class PhoneBookContact {

	private String name;
	
	private String phoneNumber;

	private int numberOfCalls;

	private PhoneBookContact() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) throws InvalidPhoneFormatException {
		this.phoneNumber = normalize(phoneNumber);

	}

	public int getNumberOfCalls() {
		return numberOfCalls;
	}

	private String normalize(String phoneNumber) throws InvalidPhoneFormatException {

		String normalizedPhoneNumber = phoneNumber;

		String regex1 = "\\+3598[7-9]{1}[2-9]{1}[0-9]{6}";
		String regex2 = "003598[7-9]{1}[2-9]{1}[0-9]{6}";
		String regex3 = "08[7-9]{1}[2-9]{1}[0-9]{6}";

		if (matchRegex(regex1, phoneNumber)) {
			normalizedPhoneNumber = phoneNumber;
		} else if (matchRegex(regex2, phoneNumber)) {
			normalizedPhoneNumber = phoneNumber.replace("00", "+");
		} else if (matchRegex(regex3, phoneNumber)) {
			normalizedPhoneNumber = phoneNumber.replace("0", "+359");
		} else {
			throw new InvalidPhoneFormatException(phoneNumber);
		}

		return normalizedPhoneNumber;
	}

	private boolean matchRegex(String regex, String phoneNumber) {
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(phoneNumber);
		return matcher.matches();
	}

	@Override
	public String toString() {
		return "name: " + getName() + ", phone number: " + getPhoneNumber();
	}

	public void call() {
		numberOfCalls++;
	}

	// static nested class
	public static class Builder {

		PhoneBookContact contact;

		public Builder() {
			contact = new PhoneBookContact();
		}

		public Builder createFromLine(String line) throws InvalidPhoneFormatException {
			String[] parts = line.split(", ");
			contact.setName(parts[0]);
			contact.setPhoneNumber(parts[1]);
			return this;
		}

		public Builder withName(String name) {
			contact.setName(name);
			return this;
		}

		public Builder withPhoneNumber(String phoneNumber) throws InvalidPhoneFormatException {
			contact.setPhoneNumber(phoneNumber);
			return this;
		}

		public PhoneBookContact build() {
			return contact;
		}
	}

}
