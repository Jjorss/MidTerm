package com.cisc181.core;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import com.cisc181.eNums.eTitle;
import com.cisc181.exceptions.PersonException;

public class Staff_Test {

	ArrayList<Staff> staffList = new ArrayList<Staff>();
	Staff s1;
	Staff s2;

	/**
	 * 
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		s1 = new Staff("Jackson", "Karl", "Jorss", new Date(96, 03, 21), "32499 McCary Road Frankford Delaware 19945",
				"(302)-930-8197", "jorss@udel.edu", "3-6", 2, 100000.5, new Date(), eTitle.PRESIDENT);
		s2 = new Staff("Jackson", "Karl", "Jorss", new Date(14, 02, 21), "32499 McCary Road Frankford Delaware 19945",
				"30930-8197", "jorss@udel.edu", "3-6", 2, 100000.5, new Date(), eTitle.PRESIDENT);

		staffList.add(new Staff("Jackson", "Karl", "Jorss", new Date(), "32499 McCary Road Frankford Delaware 19945",
				"(302) 930-8197", "jorss@udel.edu", "3-6", 2, 100000.5, new Date(), eTitle.PRESIDENT));
		staffList.add(new Staff("Jackson", "Karl", "Jorss", new Date(), "32499 McCary Road Frankford Delaware 19945",
				"(302) 930-8197", "jorss@udel.edu", "3-6", 2, 90000.5, new Date(), eTitle.PRESIDENT));
		staffList.add(new Staff("Jackson", "Karl", "Jorss", new Date(), "32499 McCary Road Frankford Delaware 19945",
				"(302) 930-8197", "jorss@udel.edu", "3-6", 2, 80000.5, new Date(), eTitle.PRESIDENT));
		staffList.add(new Staff("Jackson", "Karl", "Jorss", new Date(), "32499 McCary Road Frankford Delaware 19945",
				"(302) 930-8197", "jorss@udel.edu", "3-6", 2, 30000.5, new Date(), eTitle.PRESIDENT));
		staffList.add(new Staff("Jackson", "Karl", "Jorss", new Date(), "32499 McCary Road Frankford Delaware 19945",
				"(302) 930-8197", "jorss@udel.edu", "3-6", 2, 50000.5, new Date(), eTitle.PRESIDENT));
	}

	@Test
	public void testSalAverage() {
		double total = 0;
		double average = 0;
		for (Staff staff : staffList) {
			total += staff.getSalary();
		}
		average = total / staffList.size();
		assertTrue(average == 70000.5);
		System.out.println(total);
		System.out.println(average);
	}

	@Test
	public void testPhoneNumber() {
		try {
			s1.checkPhoneNumber();
		} catch (PersonException e) {
			System.out.println(e.phoneException());
		}

	}

	@Test
	public void testInvalidPhoneNumber() {
		try {
			s2.checkPhoneNumber();
		} catch (PersonException e) {
			System.out.println(e.phoneException());
		}

	}

	@Test
	public void testDate() {
		try {
			System.out.println(s1.PrintAge());
		} catch (PersonException e) {
			System.out.println(e.ageException());
		}
	}

	@Test
	public void testInvalidDate() {
		try {
			System.out.println(s2.PrintAge());
		} catch (PersonException e) {
			System.out.println(e.ageException());
		}
	}

}
