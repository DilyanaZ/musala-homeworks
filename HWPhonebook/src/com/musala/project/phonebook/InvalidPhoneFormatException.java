package com.musala.project.phonebook;

public class InvalidPhoneFormatException extends Exception {

	private static final long serialVersionUID = -8511979404053855786L;

	private String phoneNum;

	public InvalidPhoneFormatException(String number) {
		phoneNum = number;

	}

	@Override
	public String getMessage() {
		return "Phone number " + phoneNum + " is with invalid format.";
	}

}
