package com.cg.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "cg_attendence")
public class AttendanceEntity{
	
	@Id
	@Column(name="attn_id")
	private long id;
	
	@Column(name="subject_id")
	private long subjectId;
	
	@Column(name="student_id")
	private long studentId;
	
	@Column(name="date")
	private Date date;
	
}
