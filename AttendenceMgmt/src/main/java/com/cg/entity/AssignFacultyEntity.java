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

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public long getCourseId() {
		return courseId;
	}

	public void setCourseId(long courseId) {
		this.courseId = courseId;
	}

	public long getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(long subjectId) {
		this.subjectId = subjectId;
	}
	
	

}
