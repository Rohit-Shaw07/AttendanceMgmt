package com.cg.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.dto.FacultyDto;
import com.cg.dto.SubjectDto;
import com.cg.dto.SuccessMessage;
import com.cg.entity.Faculty;
import com.cg.entity.Subject;
import com.cg.exception.FacultyNotFoundException;
import com.cg.exception.ValidateException;
import com.cg.service.IFacultyService;
import com.cg.util.SubjectConstants;

@CrossOrigin()
@RestController
public class FacultyRestController {
	
	@Autowired
	private IFacultyService ifacultyservice;
	
	@PostMapping("addfaculty")
	public SuccessMessage addFaculty(@Valid @RequestBody FacultyDto facultydto,BindingResult br) throws ValidateException {
		if(br.hasErrors())
			throw new ValidateException(br.getFieldErrors());
		Faculty obj= ifacultyservice.addFaculty(facultydto);
		return new SuccessMessage(SubjectConstants.FACULTY_ADDED + obj.getFacultyid());
		}
	
	@GetMapping("viewfacultybyid/{facultyid}")
	public Faculty getFaculty(@PathVariable ("facultyid") long facultyid)throws FacultyNotFoundException {
		return ifacultyservice.viewFacultyById(facultyid);
		
	}
	
	@GetMapping("viewallfaculty")
	public List<Faculty> getAllFaculty() throws FacultyNotFoundException{
		return ifacultyservice.viewAllFaculty();
		
	}

}
