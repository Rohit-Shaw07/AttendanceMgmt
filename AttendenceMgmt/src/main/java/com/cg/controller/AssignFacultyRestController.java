package com.cg.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.dao.IAssignFacultyDao;
import com.cg.dto.AssignFacultyDto;
import com.cg.dto.SuccessMessage;
import com.cg.entity.AssignFaculty;
import com.cg.entity.Faculty;
import com.cg.exception.FacultyNotFoundException;
import com.cg.exception.SubjectNotFoundException;
import com.cg.exception.ValidateException;
import com.cg.service.IAssignFacultyService;
import com.cg.util.SubjectConstants;

@RestController
public class AssignFacultyRestController {
	@Autowired
	private IAssignFacultyService iassignfacultyservice;
	
	@PostMapping("assignfaculty")
	public SuccessMessage assignFaculty(@Valid @RequestBody AssignFacultyDto assignfacultydto,BindingResult br) throws ValidateException, SubjectNotFoundException, FacultyNotFoundException {
		if(br.hasErrors())
			throw new ValidateException(br.getFieldErrors());
		iassignfacultyservice.assignFaculty(assignfacultydto);
		return new SuccessMessage(SubjectConstants.ASSIGNED_FACULTY );
	}
	
	@GetMapping("getfacultybysubject/{subjectid}")
	public List<AssignFaculty> getFacultyBySubjectId(@PathVariable ("subjectid") long subjectid) throws SubjectNotFoundException, FacultyNotFoundException{
		
		return iassignfacultyservice.findFacultyForSubject(subjectid);
	}
	
	@GetMapping("getfacultybybatch/{batchname}")
	public List<AssignFaculty> getFacultyByBatchName(@PathVariable ("batchname") String batchname) throws FacultyNotFoundException{
		return iassignfacultyservice.findFacultyByBatch(batchname);
	}
}
