package com.cg.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.dao.IAssignFacultyDao;
import com.cg.dao.IFacultyDao;
import com.cg.dao.ISubjectDao;
import com.cg.dto.AssignFacultyDto;
import com.cg.entity.AssignFaculty;
import com.cg.entity.Faculty;
import com.cg.entity.Subject;
import com.cg.exception.FacultyNotFoundException;
import com.cg.exception.SubjectNotFoundException;
import com.cg.util.SubjectConstants;

@Service
@Transactional
public class AssignFacultyServiceImp implements IAssignFacultyService{

	@Autowired
	private IAssignFacultyDao iassignfacultydao;
	@Autowired
	private IFacultyDao ifacultydao;
	@Autowired
	private ISubjectDao isubjectdao;
	
	@Override
	public AssignFaculty assignFaculty(AssignFacultyDto assignfacultydto)
			throws SubjectNotFoundException, FacultyNotFoundException {
		Optional<Subject> optsubject=isubjectdao.findById(assignfacultydto.getSubjectid());
		if(!optsubject.isPresent()) {
			throw new SubjectNotFoundException(SubjectConstants.SUBJECT_NOT_FOUND);
		}
		Optional<Faculty> optfaculty=ifacultydao.findById(assignfacultydto.getFacultyid());
		if(!optfaculty.isPresent()) {
			throw new FacultyNotFoundException(SubjectConstants.FACULTY_NOT_FOUND);
		}
		AssignFaculty assignfaculty=new AssignFaculty();
		assignfaculty.setSubject(optsubject.get());
		assignfaculty.setFaculty(optfaculty.get());
		assignfaculty.setBatchName(assignfacultydto.getBatchname());
		
		return iassignfacultydao.save(assignfaculty);
	}

	@Override
	public List<AssignFaculty> findFacultyForSubject(long subjectid)
			throws SubjectNotFoundException, FacultyNotFoundException {
		List<AssignFaculty> lst= iassignfacultydao.findFacultyBySubjectId(subjectid);
		if(lst.isEmpty())
			throw new FacultyNotFoundException(SubjectConstants.FACULTY_NOT_FOUND);
		lst.sort((e1,e2)->e1.getFaculty().getFirstName().compareTo(e2.getFaculty().getFirstName()));
		return lst;
	}

	@Override
	public List<AssignFaculty> findFacultyByBatch(String batchname) throws FacultyNotFoundException {
		
		List<AssignFaculty> lst= iassignfacultydao.findByBatchName(batchname);
		if(lst.isEmpty())
			throw new FacultyNotFoundException(SubjectConstants.FACULTY_NOT_FOUND);
		lst.sort((e1,e2)->e1.getFaculty().getFirstName().compareTo(e2.getFaculty().getFirstName()));
		return lst;
	}

}
