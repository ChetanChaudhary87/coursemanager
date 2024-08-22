package com.iit.coursemanager.exception;

public class CourseNotFoundException extends RuntimeException {
	public CourseNotFoundException(String message) {
		super(message);
	}

}
