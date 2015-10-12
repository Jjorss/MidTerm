package com.cisc181.core;

import java.util.UUID;

import com.cisc181.eNums.eMajor;

public class Course {

	private UUID CourseID;
	private String CourseName;
	private int GradePoints;
	private eMajor major;

	/**
	 * 
	 * @param CourseID
	 * @param CourseName
	 * @param GradePoints
	 */
	public Course(UUID CourseID, String CourseName, int GradePoints) {
		this.CourseID = CourseID;
		this.CourseName = CourseName;
		this.GradePoints = GradePoints;
	}

	public UUID getCourseID() {
		return CourseID;
	}

}
