package com.iit.coursemanager.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iit.coursemanager.dao.CourseDeliveryRepository;
import com.iit.coursemanager.entity.CourseDelivery;
import com.iit.coursemanager.pojo.CourseDeliveryDetails;

@Service
public class CourseDeliveryService {
	@Autowired
	private CourseDeliveryRepository courseDeliveryRepository;

	public Optional<CourseDelivery>  getCourseDelivery(String courseID) {
		return courseDeliveryRepository.findByCourseId(courseID);
	}
	
	public CourseDelivery addCourseDelivery(CourseDelivery courseDelivery) {
		return courseDeliveryRepository.save(courseDelivery);
	}

	public List<CourseDeliveryDetails> getAllCourseDeliveryDetails(int yearOfDelivery, int semesterOfDelivery) {
		
		return courseDeliveryRepository.getList(yearOfDelivery, semesterOfDelivery);
	}
	
    public Optional<CourseDeliveryDetails> getCourseDeliveryDetails(int yearOfDelivery, int semesterOfDelivery,String courseId) {
		
		return courseDeliveryRepository.getCourseDeliveryDetails(yearOfDelivery, semesterOfDelivery,courseId);
	}

	public void deleteCourseDelivery(int yearOfDelivery, int semesterOfDelivery, String courseId) {
		courseDeliveryRepository.deleteCourseDelivery(yearOfDelivery,semesterOfDelivery,courseId);
		
	}

	

}
