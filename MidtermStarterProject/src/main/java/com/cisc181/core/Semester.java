package com.cisc181.core;

import java.util.Date;
import java.util.UUID;

public class Semester {

	private UUID SemesterID;
	private Date StartDate;
	private Date EndDate;

	/**
	 * 
	 * @param SemesterID
	 * @param StartDate
	 * @param EndDate
	 */
	public Semester(UUID SemesterID, Date StartDate, Date EndDate) {
		this.SemesterID = SemesterID;
		this.StartDate = StartDate;
		this.EndDate = EndDate;
	}

	// Getters and Setters
	public UUID getSemesterID() {
		return SemesterID;
	}

}
