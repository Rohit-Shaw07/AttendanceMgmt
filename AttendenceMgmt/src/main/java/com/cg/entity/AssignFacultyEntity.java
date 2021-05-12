package com.cg.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cg_assignfaculty")
public class AssignFacultyEntity{
	
	
	@Column(name="role_id")
	private long id;
	
	@Id
	@Column(name="asfac_id")
	private long userId;
	
	
	@Column(name="course_id")
	private long courseId;
	
	
	@Column(name="subject_id")
	private long subjectId;
	

}
