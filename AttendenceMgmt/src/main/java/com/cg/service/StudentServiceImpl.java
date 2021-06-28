package com.cg.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.dao.IStudentDao;
import com.cg.dto.StudentDto;
import com.cg.entity.AssignFaculty;
import com.cg.entity.Faculty;
import com.cg.entity.Student;
import com.cg.exception.FacultyNotFoundException;
import com.cg.exception.StudentNotFoundException;
import com.cg.util.SubjectConstants;

@Service
public class StudentServiceImpl implements IStudentService{
	
	@Autowired
	private IStudentDao istudentdao;
	
	
	@Override
	@Transactional
	public Student addStudent(StudentDto studentdto) {
		Student st=new Student();
		st.setFirstName(studentdto.getFirstName());
		st.setLastName(studentdto.getLastName());
		st.setDob(studentdto.getDob());
		st.setBatchId(studentdto.getBatchId());
		st.setEmailId(studentdto.getEmailId());
		st.setMobileNo(studentdto.getMobileNo());
		st.setFatherMobileNo(studentdto.getFatherMobileNo());
		Student persiststudent=istudentdao.save(st);
		
		return persiststudent;
	}

	@Override
	public Student viewStudentById(long studentid) throws StudentNotFoundException {
		
		Optional<Student> optstudent=istudentdao.findById(studentid);
		if(!optstudent.isPresent())
			throw new StudentNotFoundException(SubjectConstants.STUDENT_NOT_FOUND);
		return optstudent.get();
	}


	@Override
	public List<Student> viewStudentByName(String studentname) throws StudentNotFoundException {
		/*List<Student> lst=istudentdao.findByStudentName(studentname)
		if(lst.isEmpty())
			throw new StudentNotFoundException(SubjectConstants.STUDENT_NOT_FOUND);
		lst.sort((e1,e2)->e1.getFirstName().compareTo(e2.getFirstName()));*/
		return null;
	}

	@Override
	public List<Student> viewAllStudent() throws StudentNotFoundException {
		List<Student> lst= istudentdao.findAll();
		if(lst.isEmpty()) {
			throw new StudentNotFoundException(SubjectConstants.STUDENT_NOT_FOUND);
		}
		lst.sort((e1,e2)->e1.getFirstName().compareTo(e2.getFirstName()));
		return lst;
		
	}
}
