package com.cg.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.dto.StudentDto;
import com.cg.entity.Student;
import com.cg.exception.StudentNotFoundException;

public interface IStudentService {
	
	public Student addStudent(StudentDto studentdto);
	public Student viewStudentById(long studentid)throws StudentNotFoundException;
	public List<Student> viewStudentByName(String studentname)throws StudentNotFoundException;
	//public Student viewStudentByBatchId(String studentbatchid)throws StudentNotFoundException;
	

}
