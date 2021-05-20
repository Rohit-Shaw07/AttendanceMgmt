package com.cg.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.dao.IFacultyDao;
import com.cg.dto.FacultyDto;
import com.cg.entity.Faculty;
import com.cg.exception.FacultyNotFoundException;
import com.cg.util.SubjectConstants;

@Service
@Transactional
public class FacultyServiceImpl implements IFacultyService{
	
	@Autowired
	private IFacultyDao facultydao;
	
	@Override
	public Faculty addFaculty(FacultyDto facultydto) {
		Faculty fac=new Faculty();
		fac.setFirstName(facultydto.getFristname());
		fac.setLastName(facultydto.getLastname());
		fac.setMobileNo(facultydto.getContactnumber());
		fac.setGender(facultydto.getGender());
		fac.setProfilePic(facultydto.getProfilepic());
		Faculty persistencefaculty=facultydao.save(fac);
		return persistencefaculty;
	}

	@Override
	public List<Faculty> viewAllFaculty() throws FacultyNotFoundException {
		List<Faculty> lst=facultydao.findAll();
		if(lst.isEmpty())
			throw new FacultyNotFoundException(SubjectConstants.FACULTY_NOT_FOUND);
		lst.sort((e1,e2)->e1.getFirstName().compareTo(e2.getFirstName()));
		return lst;
	}

	@Override
	public Faculty viewFacultyById(long facultyid) throws FacultyNotFoundException {
		Optional<Faculty> optfaculty=facultydao.findById(facultyid);
		if(!optfaculty.isPresent())
			throw new FacultyNotFoundException(SubjectConstants.FACULTY_NOT_FOUND);
		return optfaculty.get();
	}

}
