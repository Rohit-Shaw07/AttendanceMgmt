package com.cg.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "cg_student")
public class StudentEntity{
	

	@Id
	@Column(name = "student_id")
	private long id;
	
	@Column(name = "roll_no")
	private long rollNo;
	
	@Column(name = "student_dob")
	private Date dob;
	
	@Column(name = "mob_no")
	private String mobileNo;
	
	@Column(name = "course_id")
	private long courseId;
	
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
		
}
