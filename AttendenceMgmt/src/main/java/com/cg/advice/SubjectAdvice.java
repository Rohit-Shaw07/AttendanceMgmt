package com.cg.advice;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageConversionException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.cg.dto.ErrorMessage;
import com.cg.exception.AttendenceException;
import com.cg.exception.FacultyNotFoundException;
import com.cg.exception.SubjectNotFoundException;
import com.cg.exception.ValidateException;
import com.cg.util.SubjectConstants;

@RestControllerAdvice
public class SubjectAdvice {
	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ErrorMessage handleExceptionForDate(MethodArgumentTypeMismatchException ex) {
		if (ex.getMessage().contains(SubjectConstants.LOCAL_DATE))
			return new ErrorMessage(HttpStatus.BAD_REQUEST.toString(), SubjectConstants.INVALID_DATE);
		return new ErrorMessage(HttpStatus.BAD_REQUEST.toString(), SubjectConstants.NUMERIC_VALUE);
	}

	@ExceptionHandler(HttpMessageConversionException.class)
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ErrorMessage handleException3(HttpMessageConversionException ex) {
		if (ex.getMessage().contains(SubjectConstants.LOCAL_DATE))
			return new ErrorMessage(HttpStatus.BAD_REQUEST.toString(), SubjectConstants.INVALID_DATE);
		return new ErrorMessage(HttpStatus.BAD_REQUEST.toString(), SubjectConstants.NUMERIC_VALUE);
	}

	@ExceptionHandler(ValidateException.class)
	@ResponseStatus(code = HttpStatus.FORBIDDEN)
	public ErrorMessage handleException2(ValidateException ex) {
		List<String> errors = ex.getErrors().stream().map(err -> err.getDefaultMessage()).collect(Collectors.toList());
		return new ErrorMessage(HttpStatus.FORBIDDEN.toString(), errors);
	}
	@ExceptionHandler(SubjectNotFoundException.class)
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ErrorMessage handleSubjectNotFound(SubjectNotFoundException ex) {
		return new ErrorMessage(HttpStatus.BAD_REQUEST.toString(), ex.getMessage());
	}
	
	@ExceptionHandler(FacultyNotFoundException.class)
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ErrorMessage handleFacultyNotFound(FacultyNotFoundException ex) {
		return new ErrorMessage(HttpStatus.BAD_REQUEST.toString(), ex.getMessage());
	}
	
	@ExceptionHandler(AttendenceException.class)
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ErrorMessage handleAttendenceNotFound(AttendenceException ex) {
		return new ErrorMessage(HttpStatus.BAD_REQUEST.toString(), ex.getMessage());
	}
	
}
