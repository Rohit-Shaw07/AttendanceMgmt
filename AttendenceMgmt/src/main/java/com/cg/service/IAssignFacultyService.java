package com.cg.service;

import java.util.List;

import com.cg.dto.AssignFacultyDto;
import com.cg.entity.AssignFaculty;
import com.cg.exception.FacultyNotFoundException;
import com.cg.exception.SubjectNotFoundException;

public interface IAssignFacultyService {
	public AssignFaculty assignFaculty(AssignFacultyDto assignfacultydto) throws SubjectNotFoundException,FacultyNotFoundException;
	public List<AssignFaculty> findFacultyForSubject(long subjectid)throws SubjectNotFoundException,FacultyNotFoundException;
	public List<AssignFaculty> findFacultyByBatch(String batchname)throws FacultyNotFoundException;
}
