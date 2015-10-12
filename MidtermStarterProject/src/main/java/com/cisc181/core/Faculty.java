package com.cisc181.core;

import java.util.Date;

public class Faculty extends Employee {

	private String officeHours;
	private int rank;

	// Getters and Setters
	public void setofficeHours(String officeHours) {
		this.officeHours = officeHours;
	}

	public String getofficeHours() {
		return this.officeHours;
	}

	public void setrank(int rank) {
		this.rank = rank;
	}

	public int getrank() {
		return this.rank;
	}

	/**
	 * 
	 * @param FirstName
	 * @param MiddleName
	 * @param LastName
	 * @param DOB
	 * @param Address
	 * @param Phone_number
	 * @param Email
	 * @param officeHours
	 * @param rank
	 * @param salary
	 * @param hireDate
	 */
	public Faculty(String FirstName, String MiddleName, String LastName, Date DOB, String Address, String Phone_number,
			String Email, String officeHours, int rank, double salary, Date hireDate)

	{
		super(FirstName, MiddleName, LastName, DOB, Address, Phone_number, Email, officeHours, salary, hireDate);

		this.officeHours = officeHours;
		this.rank = rank;
	}

}