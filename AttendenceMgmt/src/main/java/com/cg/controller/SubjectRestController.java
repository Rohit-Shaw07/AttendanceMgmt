package com.cg.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.dto.SubjectDto;
import com.cg.dto.SuccessMessage;
import com.cg.entity.Subject;
import com.cg.exception.SubjectNotFoundException;
import com.cg.exception.ValidateException;
import com.cg.service.ISubjectService;
import com.cg.util.SubjectConstants;

@CrossOrigin()
@RestController
public class SubjectRestController {
	@Autowired
	private ISubjectService subjectservice;
	@PostMapping("addsubject")
	public SuccessMessage addSubject(@Valid @RequestBody SubjectDto subjectdto,BindingResult br) throws ValidateException {
		if(br.hasErrors())
			throw new ValidateException(br.getFieldErrors());
		Subject obj= subjectservice.addSubject(subjectdto);
		return new SuccessMessage(SubjectConstants.SUBJECT_ADDED + obj.getSubjectid());
		}
	
	@GetMapping("viewsubject/{subjectid}")
	public Subject getSubject(@PathVariable("subjectid")long subjectid) throws SubjectNotFoundException {
		return subjectservice.viewSubject(subjectid);
	}
	
	@GetMapping("viewallsubjects")
	public List<Subject> getallsubject() throws SubjectNotFoundException{
		return subjectservice.viewAllSubject();
	}
}
