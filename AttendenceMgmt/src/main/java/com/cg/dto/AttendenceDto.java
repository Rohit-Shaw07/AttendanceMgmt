package com.cg.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.cg.util.SubjectConstants;


public class AttendenceDto {

	@NotNull(message=SubjectConstants.STUDENT_ID_REQUIRED)
	private Long studentid;
	
	@NotNull(message = SubjectConstants.FACULTY_ID_REQUIRED)
	private Long facultyid;
	@NotNull(message =SubjectConstants.SUBJECT_ID_REQUIRED)
	private Long subjectid;
	
	@NotNull(message =SubjectConstants.DATE_REQUIRED)
	private LocalDate dateofattendence;
	@NotNull(message = SubjectConstants.STATUS_REQUIRED)
	@Pattern(regexp="(A|P)",message = SubjectConstants.INVALID_STATUS)
	private String presentstatus;
	
	public String getPresentstatus() {
		return presentstatus;
	}
	public void setPresentstatus(String presentstatus) {
		this.presentstatus = presentstatus;
	}
	public Long getStudentid() {
		return studentid;
	}
	public void setStudentid(Long studentid) {
		this.studentid = studentid;
	}
	public Long getFacultyid() {
		return facultyid;
	}
	public void setFacultyid(Long facultyid) {
		this.facultyid = facultyid;
	}
	public Long getSubjectid() {
		return subjectid;
	}
	public void setSubjectid(Long subjectid) {
		this.subjectid = subjectid;
	}
	public LocalDate getDateofattendence() {
		return dateofattendence;
	}
	public void setDateofattendence(LocalDate dateofattendence) {
		this.dateofattendence = dateofattendence;
	}
	
	
}
