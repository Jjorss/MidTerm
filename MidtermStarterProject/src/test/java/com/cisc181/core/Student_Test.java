package com.cisc181.core;

import static org.junit.Assert.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.UUID;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.cisc181.eNums.eMajor;

public class Student_Test {

	static ArrayList<Course> courseList = new ArrayList<Course>();
	static ArrayList<Semester> semesterList = new ArrayList<Semester>();
	static ArrayList<Section> sectionList = new ArrayList<Section>();
	static ArrayList<Student> studentList = new ArrayList<Student>();
	static ArrayList<Enrollment> enrollList = new ArrayList<Enrollment>();

	/**
	 * 
	 * @throws Exception
	 */
	@SuppressWarnings("deprecation")
	@BeforeClass
	public static void setUpBefore() throws Exception {

		Course c1 = new Course(UUID.randomUUID(), "Cisc181", 100);
		Course c2 = new Course(UUID.randomUUID(), "Cisc108", 85);
		Course c3 = new Course(UUID.randomUUID(), "Cisc220", 90);

		courseList.add(c1);
		courseList.add(c2);
		courseList.add(c3);

		Semester fall = new Semester(UUID.randomUUID(), new Date(15, 9, 01), new Date(15, 12, 19));
		Semester spring = new Semester(UUID.randomUUID(), new Date(16, 2, 01), new Date(16, 5, 30));

		semesterList.add(fall);
		semesterList.add(spring);

		Section s1 = new Section(c1.getCourseID(), fall.getSemesterID(), UUID.randomUUID(), 32);
		Section s2 = new Section(c1.getCourseID(), spring.getSemesterID(), UUID.randomUUID(), 56);

		Section s3 = new Section(c2.getCourseID(), fall.getSemesterID(), UUID.randomUUID(), 32);
		Section s4 = new Section(c2.getCourseID(), spring.getSemesterID(), UUID.randomUUID(), 56);

		Section s5 = new Section(c3.getCourseID(), fall.getSemesterID(), UUID.randomUUID(), 32);
		Section s6 = new Section(c3.getCourseID(), spring.getSemesterID(), UUID.randomUUID(), 56);

		sectionList.add(s1);
		sectionList.add(s2);
		sectionList.add(s3);
		sectionList.add(s4);
		sectionList.add(s5);
		sectionList.add(s6);

		Student stud1 = new Student("Jackson", "Karl", "Jorss", new Date(96, 3, 21), eMajor.COMPSI, "279 The Green",
				"(000)-000-0000", "jorss@udel.edu");
		Student stud2 = new Student("Jackson", "Karl", "Jorss", new Date(96, 3, 21), eMajor.COMPSI, "279 The Green",
				"(000)-000-0000", "jorss@udel.edu");
		Student stud3 = new Student("Jackson", "Karl", "Jorss", new Date(96, 3, 21), eMajor.COMPSI, "279 The Green",
				"(000)-000-0000", "jorss@udel.edu");
		Student stud4 = new Student("Jackson", "Karl", "Jorss", new Date(96, 3, 21), eMajor.COMPSI, "279 The Green",
				"(000)-000-0000", "jorss@udel.edu");
		Student stud5 = new Student("Jackson", "Karl", "Jorss", new Date(96, 3, 21), eMajor.COMPSI, "279 The Green",
				"(000)-000-0000", "jorss@udel.edu");
		Student stud6 = new Student("Jackson", "Karl", "Jorss", new Date(96, 3, 21), eMajor.COMPSI, "279 The Green",
				"(000)-000-0000", "jorss@udel.edu");
		Student stud7 = new Student("Jackson", "Karl", "Jorss", new Date(96, 3, 21), eMajor.COMPSI, "279 The Green",
				"(000)-000-0000", "jorss@udel.edu");
		Student stud8 = new Student("Jackson", "Karl", "Jorss", new Date(96, 3, 21), eMajor.COMPSI, "279 The Green",
				"(000)-000-0000", "jorss@udel.edu");
		Student stud9 = new Student("Jackson", "Karl", "Jorss", new Date(96, 3, 21), eMajor.COMPSI, "279 The Green",
				"(000)-000-0000", "jorss@udel.edu");
		Student stud10 = new Student("Jackson", "Karl", "Jorss", new Date(96, 3, 21), eMajor.COMPSI, "279 The Green",
				"(000)-000-0000", "jorss@udel.edu");
		studentList.add(stud1);
		studentList.add(stud2);
		studentList.add(stud3);
		studentList.add(stud4);
		studentList.add(stud5);
		studentList.add(stud6);
		studentList.add(stud7);
		studentList.add(stud8);
		studentList.add(stud9);
		studentList.add(stud10);
		double baseGrade = 60;

		for (Section s : sectionList) {
			for (Student stud : studentList) {
				Enrollment e = new Enrollment(s.getSectionID(), stud.getStudentID());
				e.setGrade(baseGrade++);
				enrollList.add(e);
			}
		}
	}

	// This method goes through the enrollment list and finds a certain
	// student's grade, add all their grades together
	// then divides by 6 (The total number of class)
	public static double GPA(Student stud) {
		double totalGrades = 0;
		for (Enrollment e : enrollList) {
			if (e.getStudentID() == stud.getStudentID()) {
				totalGrades += e.getGrade();
			}
		}
		return totalGrades / 6;
	}

	@Test
	public void testGPA() {
		assertEquals(GPA(studentList.get(0)), 85, 0.0);
		assertEquals(GPA(studentList.get(1)), 86, 0.0);
		assertEquals(GPA(studentList.get(2)), 87, 0.0);
		assertEquals(GPA(studentList.get(3)), 88, 0.0);
		assertEquals(GPA(studentList.get(4)), 89, 0.0);
		assertEquals(GPA(studentList.get(5)), 90, 0.0);
		assertEquals(GPA(studentList.get(6)), 91, 0.0);
		assertEquals(GPA(studentList.get(7)), 92, 0.0);
		assertEquals(GPA(studentList.get(8)), 93, 0.0);
		assertEquals(GPA(studentList.get(9)), 94, 0.0);
	}

	// This method finds the sections in a course, then who is enrolled in that
	// section, then adds up all
	// the grade of both sections of that course. Divides by 20 because each
	// section has 20 students and
	// each course has 2 section.
	public static double courseAverageGrade(Course c) {
		double totalGrade = 0;
		for (Section s : sectionList) {
			if (c.getCourseID() == s.getCourseID()) {
				for (Enrollment e : enrollList) {
					if (s.getSectionID() == e.getSectionID()) {
						for (Student stud : studentList) {
							if (stud.getStudentID() == e.getStudentID()) {
								totalGrade += e.getGrade();
							}
						}
					}
				}
			}
		}
		return totalGrade / 20;
	}

	@Test
	public void TestCourseAverageGrade() {
		assertEquals(courseAverageGrade(courseList.get(0)), 69.5, 0.0);
		assertEquals(courseAverageGrade(courseList.get(1)), 89.5, 0.0);
		assertEquals(courseAverageGrade(courseList.get(2)), 109.5, 0.0);
	}

	@Test
	public void changeMajor() {
		eMajor newMajor = eMajor.CHEM;
		System.out.println(studentList.get(2).getMajor());
		studentList.get(2).setMajor(newMajor);
		System.out.println(studentList.get(2).getMajor());
	}
}
