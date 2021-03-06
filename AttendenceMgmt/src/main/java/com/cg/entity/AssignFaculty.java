package com.cg.entity;

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
@Table(name = "cg_assignfaculty")
public class AssignFaculty{
	
	
	@Id
	@SequenceGenerator(name="seq1",sequenceName = "assign_faculty_seq1",allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq1")
	@Column(name="assign_faculty_id")
	private long id;
	
	@ManyToOne
	@JoinColumn(name="faculty_id",referencedColumnName = "faculty_id")
	private Faculty faculty; 
	
	@ManyToOne
	@JoinColumn(name="subject_id",referencedColumnName = "subject_id")
	private Subject subject;
	
	@Column(name="batch_name")
	private String batchName;
	
	public Faculty getFaculty() {
		return faculty;
	}

	public void setFaculty(Faculty faculty) {
		this.faculty = faculty;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public String getBatchName() {
		return batchName;
	}

	public void setBatchName(String batchName) {
		this.batchName = batchName;
	}
	
}
