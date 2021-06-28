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
import com.cg.dto.StudentDto;
import com.cg.dto.SuccessMessage;
import com.cg.entity.Faculty;
import com.cg.entity.Student;
import com.cg.exception.FacultyNotFoundException;
import com.cg.exception.StudentNotFoundException;
import com.cg.exception.ValidateException;
import com.cg.service.IStudentService;
import com.cg.util.SubjectConstants;

@CrossOrigin()
@RestController
public class StudentRestController {

	
	@Autowired
	private IStudentService studentservice;
	
	@PostMapping("addstudent")
	public SuccessMessage addStudent(@Valid @RequestBody StudentDto studentdto,BindingResult br) throws ValidateException {
		if(br.hasErrors())
			throw new ValidateException(br.getFieldErrors());
		Student obj= studentservice.addStudent(studentdto);
		return new SuccessMessage(SubjectConstants.STUDENT_ADDED + obj.getId());
		}
	
	
	@GetMapping("viewstudentid/{studentid}")
	public Student viewStudentById(@PathVariable("studentid")long studentid) throws StudentNotFoundException {
		return studentservice.viewStudentById(studentid);
	}
	
	@GetMapping("viewstudentname/{studentname}")
	public List<Student> viewStudentByName(@PathVariable("studentname") String studentname)throws StudentNotFoundException{
		return studentservice.viewStudentByName(studentname);
	}
	
	@GetMapping("viewallstudent")
	public List<Student> getAllStudent() throws StudentNotFoundException{
		return studentservice.viewAllStudent();
	
    }
}
