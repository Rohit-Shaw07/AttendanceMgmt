package com.cg.service;

import java.util.List;

import com.cg.dto.FacultyDto;
import com.cg.entity.Faculty;
import com.cg.exception.FacultyNotFoundException;

public interface IFacultyService {
	public Faculty addFaculty(FacultyDto facultydto);
	public List<Faculty> viewAllFaculty()throws FacultyNotFoundException;
	public Faculty viewFacultyById(long facultyid)throws FacultyNotFoundException;
}
