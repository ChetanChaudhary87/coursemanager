package com.iit.coursemanager.exceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.iit.coursemanager.exception.CourseNotFoundException;
import com.iit.coursemanager.exception.DuplicateCourseDeliveryException;
import com.iit.coursemanager.exception.DuplicateCourseException;

@ControllerAdvice
public class CustomExceptionHandler {
	
	@ExceptionHandler(CourseNotFoundException.class)
	public final ResponseEntity<String> courseNotFoundHandler(Exception ex){
		return new ResponseEntity<String>(ex.getMessage(),HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(DuplicateCourseException.class)
	public final ResponseEntity<String> duplicateCourseExceptionHandler(Exception ex){
		return new ResponseEntity<String>(ex.getMessage(),HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(DuplicateCourseDeliveryException.class)
	public final ResponseEntity<String> duplicateCourseDeliveryExceptionHandler(Exception ex){
		return new ResponseEntity<String>(ex.getMessage(),HttpStatus.BAD_REQUEST);
	}

}
