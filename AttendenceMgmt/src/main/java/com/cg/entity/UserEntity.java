package com.cg.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cg_user")
public class UserEntity {
	
	@Id
	@Column(name="user_id")
	private String id;
	
	@Column(name="user_fname")
	private String firstName;
	
	@Column(name="user_lname")
	private String lastName;
	
	@Column(name="login")
	private String login;
	
	@Column(name="pswd")
	private String password;
	
	@Column(name="cnfm_pswd")
	private String confirmPassword;
	
	@Column(name="user_dob")
	private Date dob;
	
	@Column(name="user_phno")
	private String mobileNo;
	
	@Column(name="user_roleid")
	private long roleId;
	
	@Column(name="user_gen")
	private String gender;
	
	@Column(name="user_propic")
	private String profilePic;
}
