package com.cg.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.dao.IAssignFacultyDao;
import com.cg.dao.IAttendenceDao;
import com.cg.dao.IFacultyDao;
import com.cg.dao.IStudentDao;
import com.cg.dao.ISubjectDao;
import com.cg.dto.AttendenceDto;
import com.cg.dto.AttendenceResponseDto;
import com.cg.entity.AssignFaculty;
import com.cg.entity.Attendance;
import com.cg.entity.Faculty;
import com.cg.entity.Student;
import com.cg.entity.Subject;
import com.cg.exception.AttendenceException;
import com.cg.exception.BatchNotFoundException;
import com.cg.exception.FacultyNotFoundException;
import com.cg.exception.StudentNotFoundException;
import com.cg.exception.SubjectNotFoundException;
import com.cg.util.SubjectConstants;

@Service
@Transactional
public class AttendenceServiceImpl implements IAttendenceService{
	
	@Autowired
	private IStudentDao studentdao;
	@Autowired
	private IFacultyDao facultydao;
	@Autowired
	private ISubjectDao subjectdao;
	@Autowired
	private IAttendenceDao attendencedao;
	@Autowired
	private IAssignFacultyDao assignfacultydao;
	

	@Override
	public boolean markattendence(AttendenceDto attendencedto)
			throws StudentNotFoundException, SubjectNotFoundException, FacultyNotFoundException {
		Optional<Student> optstudent=studentdao.findById(attendencedto.getStudentid());
		if(!optstudent.isPresent())
			throw new StudentNotFoundException(SubjectConstants.STUDENT_NOT_FOUND);
		Optional<Subject> optsubject=subjectdao.findById(attendencedto.getSubjectid());
		if(!optsubject.isPresent())
			throw new SubjectNotFoundException(SubjectConstants.SUBJECT_NOT_FOUND);
		Optional<Faculty> optfaculty=facultydao.findById(attendencedto.getFacultyid());
		if(!optfaculty.isPresent())
			throw new FacultyNotFoundException(SubjectConstants.FACULTY_NOT_FOUND);
		
		Attendance att=new Attendance();
		att.setAttendencedate(attendencedto.getDateofattendence());
		att.setStudent(optstudent.get());
		att.setFaculty(optfaculty.get());
		att.setSubject(optsubject.get());
		att.setStatus(attendencedto.getPresentstatus());
		attendencedao.save(att);
		return true;
	}



	@Override
	public boolean markattendence(List<AttendenceDto> attendencelist)
			throws StudentNotFoundException, SubjectNotFoundException, FacultyNotFoundException {
		
		for(AttendenceDto dto:attendencelist) {
			markattendence(dto);
			
		}
		return true;
	}



	@Override
	public List<Attendance> getAttendence(LocalDate dateofattendence) throws AttendenceException {
		List<Attendance> lst=attendencedao.findByAttendencedate(dateofattendence);
		if(lst.isEmpty())
			throw new AttendenceException(SubjectConstants.ATTENDENCE_EMPTY);
		lst.sort((e1,e2)->e1.getStudent().getFirstName().compareTo(e2.getStudent().getFirstName()));
		return lst;
	}



	@Override
	public AttendenceResponseDto getAttendenceReport(Long studentid) throws StudentNotFoundException {
		Optional<Student> optstudent=studentdao.findById(studentid);
		if(!optstudent.isPresent())
			throw new StudentNotFoundException(SubjectConstants.STUDENT_NOT_FOUND);
		List<Attendance> lst=attendencedao.findByStudentID(studentid);
		long numberofdayspresent = lst.stream().filter(e->e.getStatus().equals(SubjectConstants.PRESENT)).count();
		AttendenceResponseDto dto = new AttendenceResponseDto();
		dto.setStudent(optstudent.get());
		dto.setNumberofdayspresent((int)numberofdayspresent);
		dto.setTotalnoofdays(lst.size());
		dto.setAttendencepercent((numberofdayspresent/(double)lst.size())* SubjectConstants.PRECENTAGE);
		dto.setSubject(lst.get(SubjectConstants.FIRST_INDEX).getSubject().getSubjectCode());
		dto.setFacultyname(lst.get(SubjectConstants.FIRST_INDEX).getFaculty().getFirstName());
		return dto;
	}



	@Override
	public List<AssignFaculty> findStudentByBatch(String batchname) throws BatchNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

}