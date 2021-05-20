package com.cg.service;

import java.time.LocalDate;
import java.util.List;

import com.cg.dto.AttendenceDto;
import com.cg.dto.AttendenceResponseDto;
import com.cg.entity.Attendance;
import com.cg.exception.AttendenceException;
import com.cg.exception.FacultyNotFoundException;
import com.cg.exception.StudentNotFoundException;
import com.cg.exception.SubjectNotFoundException;

public interface IAttendenceService {
	public boolean markattendence(AttendenceDto attendencedto)throws StudentNotFoundException,SubjectNotFoundException,FacultyNotFoundException;
	public boolean markattendence(List<AttendenceDto> attendencelist)throws StudentNotFoundException,SubjectNotFoundException,FacultyNotFoundException;
	public List<Attendance> getAttendence(LocalDate dateofattendence)throws AttendenceException;
	public AttendenceResponseDto getAttendenceReport(Long studentid)throws StudentNotFoundException;
}
