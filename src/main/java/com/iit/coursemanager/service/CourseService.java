package com.iit.coursemanager.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iit.coursemanager.dao.CourseRepository;
import com.iit.coursemanager.entity.Course;

@Service
public class CourseService {
	@Autowired
	private CourseRepository courseRepository;
	
	public Course addCourse(Course course) {
		return courseRepository.save(course);
	}

	public List<Course> getAllCourses() {
		return courseRepository.findAll();
	}

	public Optional<Course> getCourse(String course_code) {
		return courseRepository.findById(course_code);
	}
	
	public void deleteCourse(String course_code) {
		courseRepository.deleteById(course_code);;
	}

}
