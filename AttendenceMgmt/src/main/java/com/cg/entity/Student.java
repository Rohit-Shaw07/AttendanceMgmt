package com.cg.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = "cg_student")
public class Student{
	

	@Id
	@SequenceGenerator(name="seq1",sequenceName = "student_seq1",allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq1")
	@Column(name = "student_id")
	private long id;
	
	/*@Column(name="student_fname")
	private String firstName;
	
	@Column(name="student_lname")
	private String lastName;*/
	
	@Column(name = "student_dob")
	private LocalDate dob;
	
	@Column(name = "mob_no")
	private String mobileNo;
	
	@Column(name = "email_id")
	private String emailId;
	
	@Column(name = "father_email_id")
	private String fatherEmailId;
	
	@Column(name = "father_mob_no")
	private String fatherMobileNo;
		
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	
	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getFatherEmailId() {
		return fatherEmailId;
	}

	public void setFatherEmailId(String fatherEmailId) {
		this.fatherEmailId = fatherEmailId;
	}

	public String getFatherMobileNo() {
		return fatherMobileNo;
	}

	public void setFatherMobileNo(String fatherMobileNo) {
		this.fatherMobileNo = fatherMobileNo;
	}

	@Override
	public String toString() {
	return "";
	}

	
}
