package com.cisc181.exceptions;

import com.cisc181.core.Person;

public class PersonException extends Exception {

	private Person p;

	public PersonException(Person p) {
		this.p = p;
	}

	// Explains what is wrong with age
	public String ageException() {
		return this.p.getFirstName() + " " + this.p.getMiddleName() + " " + this.p.getLastName()
				+ " is older than 100, a Person cannot be older than 100 years old";
	}

	// Explains what is wrong with the format of your phone number
	public String phoneException() {
		return this.p.getPhone() + " is not formatted correctly, please format it like \"(###)-###-####\" ";
	}
}
