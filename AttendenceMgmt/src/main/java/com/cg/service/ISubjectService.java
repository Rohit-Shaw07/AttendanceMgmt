package com.cg.service;

import java.util.List;

import com.cg.dto.SubjectDto;
import com.cg.entity.Subject;
import com.cg.exception.SubjectNotFoundException;

public interface ISubjectService  {
	
	public Subject addSubject(SubjectDto subjectdto);
	public Subject viewSubject(long subjectId)throws SubjectNotFoundException;
	public List <Subject> viewAllSubject()throws SubjectNotFoundException ;

}
