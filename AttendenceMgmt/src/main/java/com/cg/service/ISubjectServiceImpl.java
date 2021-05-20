package com.cg.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.dao.ISubjectDao;
import com.cg.dto.SubjectDto;
import com.cg.entity.Subject;
import com.cg.exception.SubjectNotFoundException;
import com.cg.util.SubjectConstants;


@Service
public class ISubjectServiceImpl implements ISubjectService {
	
	@Autowired
	private ISubjectDao subjectdao;
	
	@Override
	@Transactional
	public Subject addSubject(SubjectDto subjectdto) {
		Subject subj=new Subject();
		subj.setDescription(subjectdto.getDescription());
		subj.setSubjectCode(subjectdto.getSubjectCode());
		
		Subject persistedsubj= subjectdao.save(subj);
		return persistedsubj;
		
	}

	@Override
	public Subject viewSubject(long subjectId)throws SubjectNotFoundException {
		Optional<Subject> sub = subjectdao.findById(subjectId);
		
		if (!sub.isPresent()) {
			throw new SubjectNotFoundException(SubjectConstants.SUBJECT_NOT_FOUND);
		}
		return sub.get();
	}

	@Override
	public List<Subject> viewAllSubject() throws SubjectNotFoundException {
		List<Subject> lst = subjectdao.findAll();
		if (lst.isEmpty()) {
			throw new SubjectNotFoundException(SubjectConstants.SUBJECT_EMPTY);
		}
		lst.sort((e1, e2) -> e1.getSubjectCode().compareTo(e2.getSubjectCode()));
		return lst;
	}
	


}