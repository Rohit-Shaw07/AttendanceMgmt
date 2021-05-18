package com.cg.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.entity.Subject;

@Repository
public interface ISubjectDao extends JpaRepository<Subject,Long>{
	
	public Subject findbySubId(Long subjectId);


}
