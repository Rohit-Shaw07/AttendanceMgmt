package com.cg.dto;

import com.cg.entity.Student;

public class AttendenceResponseDto {

	private Student student;
	private String subject;
	private String facultyname;
	private double attendencepercent;
	private int numberofdayspresent;
	private int totalnoofdays;
	
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getFacultyname() {
		return facultyname;
	}
	public void setFacultyname(String facultyname) {
		this.facultyname = facultyname;
	}
	public double getAttendencepercent() {
		return attendencepercent;
	}
	public void setAttendencepercent(double attendencepercent) {
		this.attendencepercent = attendencepercent;
	}
	public int getNumberofdayspresent() {
		return numberofdayspresent;
	}
	public void setNumberofdayspresent(int numberofdayspresent) {
		this.numberofdayspresent = numberofdayspresent;
	}
	public int getTotalnoofdays() {
		return totalnoofdays;
	}
	public void setTotalnoofdays(int totalnoofdays) {
		this.totalnoofdays = totalnoofdays;
	}
}
