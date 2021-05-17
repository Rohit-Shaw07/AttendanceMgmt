package com.cg.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "cg_student")
public class Student{
	

	@Id
	@Column(name = "student_id")
	private long id;
	
	@Column(name="batch_name")
	private String batchNname;
	
	@Column(name="user_fname")
	private String firstName;
	
	@Column(name="user_lname")
	private String lastName;
	
	@Column(name = "student_dob")
	private Date dob;
	
	@Column(name = "mob_no")
	private String mobileNo;
	
	@Column(name = "course_name")
	private String courseName;
	
	@Column(name = "subject_id")
	private long subjectId;
	
	@Column(name = "subject_name")
	private String subjectName;
	
	
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


	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public long getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(long subjectId) {
		this.subjectId = subjectId;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
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
