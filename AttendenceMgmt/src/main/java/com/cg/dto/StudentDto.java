package com.cg.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;

import com.cg.util.SubjectConstants;


public class StudentDto {

	@Past(message=SubjectConstants.INVALID_DATE)
	private LocalDate dob;
	
	@NotBlank(message = SubjectConstants.MOBILE_REQUIRED)
	@Pattern(regexp="[0-9]{10}",message = SubjectConstants.MOBILE_PATTERN)
	private String mobileNo;
	
	@NotBlank(message = SubjectConstants.EMAIL_REQUIRED)
	@Pattern(regexp="^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$",message = SubjectConstants.EMAIL_PATTERN)
	private String emailId;
	
	@NotBlank(message = SubjectConstants.ID_REQUIRED)
	private String batchId;
	
	@NotBlank(message =SubjectConstants.MOBILE_REQUIRED )
	@Pattern(regexp="[0-9]{10}",message = SubjectConstants.MOBILE_PATTERN)
	private String fatherMobileNo;
	
	@NotBlank(message = SubjectConstants.FIRSTNAME_REQUIRED)
	private String firstName;
	
	@NotBlank(message = SubjectConstants.LASTNAME_REQUIRED)
	private String lastName;
	
	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getBatchId() {
		return batchId;
	}

	public void setBatchId(String batchId) {
		this.batchId = batchId;
	}

	public String getFatherMobileNo() {
		return fatherMobileNo;
	}

	public void setFatherMobileNo(String fatherMobileNo) {
		this.fatherMobileNo = fatherMobileNo;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	
	
	
	
}
