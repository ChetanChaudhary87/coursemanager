package com.iit.coursemanager.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.iit.coursemanager.entity.Course;
import com.iit.coursemanager.exception.CourseNotFoundException;
import com.iit.coursemanager.exception.DuplicateCourseException;
import com.iit.coursemanager.service.CourseService;

@RestController
public class CourseController {
	@Autowired
	private CourseService courseService;
	
	@PostMapping("/api/courses")
	public ResponseEntity<Course> createCourse(@RequestBody Course course) {
		Optional<Course> course1 =  courseService.getCourse(course.getCourse_code());
		if(course1.isEmpty()) {
			courseService.addCourse(course);
			return new ResponseEntity<Course>(course,HttpStatus.CREATED);
		}
		else throw new DuplicateCourseException("This course code already exists.");
		 
	}
	
	@GetMapping("/api/courses")
	public ResponseEntity<List<Course>>  getAllCourses(){
		return new ResponseEntity<List<Course>>(courseService.getAllCourses(),HttpStatus.OK);
	}
	
	@GetMapping("/api/courses/{course_code}")
	public ResponseEntity<Course> getSingleCourse(@PathVariable String course_code) {
		Optional<Course> course =  courseService.getCourse(course_code);
		if(course.isEmpty()) {
			throw new CourseNotFoundException("Please enter a valid Course code");
		}
			
		else
		return new ResponseEntity<Course>(course.get(),HttpStatus.OK);
	}
	
	@DeleteMapping("/api/courses/{course_code}")
	public ResponseEntity<Course> deleteCourse(@PathVariable String course_code){
		Optional<Course> course =  courseService.getCourse(course_code);
		if(course.isEmpty()) {
			throw new CourseNotFoundException("Please enter a valid Course code");
		}
			
		else {
			courseService.deleteCourse(course_code);
			return new ResponseEntity<Course>(course.get(),HttpStatus.OK);
		}
		
	}
	
	

}
