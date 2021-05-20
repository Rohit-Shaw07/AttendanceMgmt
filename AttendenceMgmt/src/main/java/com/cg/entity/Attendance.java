package com.cg.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = "cg_attendence")
public class Attendance{
	
	@Id
	@SequenceGenerator(name="seq1",sequenceName = "attendence_seq1",allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq1")
	@Column(name="attendance_id")
	private long id;
	
	@Column(name="attendence_date")
	private LocalDate attendencedate;
	
	@ManyToOne
	@JoinColumn(name="student_id",referencedColumnName = "student_id")
	private Student student;
	
	@ManyToOne
	@JoinColumn(name="subject_id",referencedColumnName = "subject_id")
	private Subject subject;
	
	@ManyToOne
	@JoinColumn(name="faculty_id",referencedColumnName = "faculty_id")
	private Faculty faculty;
	
	@Column(name="att_status")
	private String status;
	
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	

	public LocalDate getAttendencedate() {
		return attendencedate;
	}

	public void setAttendencedate(LocalDate attendencedate) {
		this.attendencedate = attendencedate;
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
