package com.cg.controller;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.dto.AttendenceDto;
import com.cg.dto.AttendenceResponseDto;
import com.cg.dto.SuccessMessage;
import com.cg.entity.Attendance;
import com.cg.exception.AttendenceException;
import com.cg.exception.FacultyNotFoundException;
import com.cg.exception.StudentNotFoundException;
import com.cg.exception.SubjectNotFoundException;
import com.cg.exception.ValidateException;
import com.cg.service.AttendenceServiceImpl;
import com.cg.service.IAttendenceService;
import com.cg.util.SubjectConstants;

@RestController
public class AttendenceRestController {
	
	@Autowired
	private IAttendenceService iattendenceservice;
	
	@PostMapping("markattendence")
	public SuccessMessage markAttendence(@Valid @RequestBody AttendenceDto attendencedto,BindingResult br) throws ValidateException, StudentNotFoundException, SubjectNotFoundException, FacultyNotFoundException {
		if(br.hasErrors())
			throw new ValidateException(br.getFieldErrors());
		iattendenceservice.markattendence(attendencedto);
		return new SuccessMessage(SubjectConstants.ATTENDENCE_MARKED_SUCCESS);
		
	}
	
	@PostMapping("markattendencemany")
	public SuccessMessage markAttendenceMany(@Valid @RequestBody List<AttendenceDto> attendencedtolist,BindingResult br) throws ValidateException, StudentNotFoundException, SubjectNotFoundException, FacultyNotFoundException {
		if(br.hasErrors())
			throw new ValidateException(br.getFieldErrors());
		iattendenceservice.markattendence(attendencedtolist);
		return new SuccessMessage(SubjectConstants.ATTENDENCE_MARKED_SUCCESS);
		
	}
	
	@GetMapping("viewattendencebydate/{attdate}")
	public List<Attendance> viewAttendence(@DateTimeFormat (pattern = "yyyy-MM-dd") @PathVariable ("attdate") LocalDate attdate) throws AttendenceException{
		return iattendenceservice.getAttendence(attdate);
	}
	
	@GetMapping("viewreportbystudentid/{studentid}")
	public AttendenceResponseDto viewAttendenceReport(@PathVariable ("studentid") long studentid) throws StudentNotFoundException {
		return iattendenceservice.getAttendenceReport(studentid);
	}
	
}
