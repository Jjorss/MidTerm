package com.cisc181.core;

import java.util.UUID;

public class Section {

	private UUID CourseID;
	private UUID SemesterID;
	private UUID SectionID;
	private int RoomID;

	/**
	 * 
	 * @param CourseID
	 * @param SemesterID
	 * @param SectionID
	 * @param RoomID
	 */
	public Section(UUID CourseID, UUID SemesterID, UUID SectionID, int RoomID) {
		this.CourseID = CourseID;
		this.SemesterID = SemesterID;
		this.SectionID = SectionID;
		this.RoomID = RoomID;
	}

	// Gettters and Setters
	public UUID getSectionID() {
		return SectionID;
	}

	public UUID getCourseID() {
		return CourseID;
	}
}
