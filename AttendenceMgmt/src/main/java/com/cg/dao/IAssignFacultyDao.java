package com.cg.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.entity.AssignFaculty;

@Repository
public interface IAssignFacultyDao extends JpaRepository<AssignFaculty, Long>{
	@Query("from AssignFaculty af inner join af.faculty f inner join af.subject s where s.subjectid=:subjectID")
	public List<AssignFaculty> findFacultyBySubjectId(@Param ("subjectID")long subjectid);
	
	public List<AssignFaculty> findByBatchName(String batchname); 
	
}
