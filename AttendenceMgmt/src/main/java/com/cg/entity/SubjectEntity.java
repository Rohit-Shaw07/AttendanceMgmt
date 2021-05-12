package com.cg.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "cg_subject")
public class SubjectEntity{
	
	@Id
	@Column(name = "student_id")
	private long id;
	
	
	@Column(name = "course_id")
	private long courseId;
	
	@Column(name = "student_name")
	private String name;
	
	@Column(name = "subject_code")
	private String subjectCode;
	
	@Column(name = "sem_no")
	private String semester;
	
	@Column(name = "desc")
	private String description;
	
	
}
