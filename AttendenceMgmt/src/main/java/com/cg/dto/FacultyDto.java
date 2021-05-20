package com.cg.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;


import com.cg.util.SubjectConstants;

public class FacultyDto {
	@NotBlank(message=SubjectConstants.FIRSTNAME_REQUIRED)
	private String fristname;
	
	@NotBlank(message=SubjectConstants.LASTNAME_REQUIRED)
	private String lastname;
	
	@NotBlank(message = SubjectConstants.MOBILE_REQUIRED)
	@Pattern(regexp="[0-9]{10}",message = SubjectConstants.MOBILE_PATTERN)
	private String contactnumber;
	
	@NotBlank(message = SubjectConstants.GENDER_REQUIRED)
	@Pattern(regexp="(male|female)",message = SubjectConstants.GENDER_PATTERN)
	private String gender;
	
	@NotBlank(message =SubjectConstants.PROFILE_PIC)
	private String profilepic;
	public String getFristname() {
		return fristname;
	}
	
	public void setFristname(String fristname) {
		this.fristname = fristname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getContactnumber() {
		return contactnumber;
	}
	public void setContactnumber(String contactnumber) {
		this.contactnumber = contactnumber;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getProfilepic() {
		return profilepic;
	}
	public void setProfilepic(String profilepic) {
		this.profilepic = profilepic;
	}
	
	
}
