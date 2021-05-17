package com.cg.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "cg_attendence")
public class Attendance{
	
	@Id
	@Column(name="attn_id")
	private long id;
	
	@Column(name="date")
	private LocalDate date;
	
	@ManyToOne
	@JoinColumn(name="student_id",referencedColumnName = "student_id")
	private Student student;
	
	@ManyToOne
	@JoinColumn(name="subject_id",referencedColumnName = "subject_id")
	private Subject subject;
	
	@ManyToOne
	@JoinColumn(name="faculty_id",referencedColumnName = "faculty_id")
	private Faculty faculty;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public Faculty getFaculty() {
		return faculty;
	}

	public void setFaculty(Faculty faculty) {
		this.faculty = faculty;
	}	
	
	
}
