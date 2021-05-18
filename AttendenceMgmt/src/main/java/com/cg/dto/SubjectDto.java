package com.cg.dto;

import javax.validation.constraints.NotBlank;

import com.cg.util.SubjectConstants;

public class SubjectDto {
	
	@NotBlank(message = SubjectConstants.CODE_REQUIRED)
	private String subjectCode;
	@NotBlank(message = SubjectConstants.DESCRIPTION_REQUIRED)
	private String description;
	
	

	public SubjectDto() {
		
	}
	
	
	public String getSubjectCode() {
		return subjectCode;
	}
	public void setSubjectCode(String subjectCode) {
		this.subjectCode = subjectCode;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}



}
