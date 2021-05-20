package com.cg.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.entity.Attendance;

@Repository
public interface IAttendenceDao extends JpaRepository<Attendance, Long>{
public List<Attendance> findByAttendencedate(LocalDate attdate);

@Query("from Attendance a inner join a.student s inner join a.subject su inner join a.faculty f where s.id=:stuid")
public List<Attendance> findByStudentID(@Param ("stuid") long studentid);

}
