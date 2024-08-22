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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iit.coursemanager.entity.CourseDelivery;
import com.iit.coursemanager.exception.CourseNotFoundException;
import com.iit.coursemanager.exception.DuplicateCourseDeliveryException;
import com.iit.coursemanager.pojo.CourseDeliveryDetails;
import com.iit.coursemanager.service.CourseDeliveryService;

@RestController
@RequestMapping("/api/instances")
public class CourseDeliveryController {
	@Autowired
	private CourseDeliveryService courseDeliveryService;
	
	@PostMapping()
	public ResponseEntity<CourseDelivery> createCourseDelivery(@RequestBody CourseDelivery courseDelivery){
		Optional<CourseDelivery> delivery= courseDeliveryService.getCourseDelivery(courseDelivery.getCourseID());
		if(delivery.isEmpty()) {
			courseDeliveryService.addCourseDelivery(courseDelivery);
			return new ResponseEntity<CourseDelivery>(courseDelivery,HttpStatus.CREATED);
		}
		else throw new DuplicateCourseDeliveryException("This CourseDelivery id  already exists.");
	}
	
	@GetMapping("/{yearOfDelivery}/{semesterOfDelivery}")
	public ResponseEntity<List<CourseDeliveryDetails>> getAllCourseDeliveryDetails(@PathVariable int yearOfDelivery,@PathVariable int semesterOfDelivery){
		List<CourseDeliveryDetails> list= courseDeliveryService.getAllCourseDeliveryDetails( yearOfDelivery, semesterOfDelivery);
		return new ResponseEntity<List<CourseDeliveryDetails>>(list,HttpStatus.OK);
	}
	
	@GetMapping("/{yearOfDelivery}/{semesterOfDelivery}/{courseId}")
	public ResponseEntity<CourseDeliveryDetails> getCourseDeliveryDetails(@PathVariable int yearOfDelivery,@PathVariable int semesterOfDelivery,@PathVariable String courseId){
		Optional<CourseDeliveryDetails> courseDeliveryDetails= courseDeliveryService.getCourseDeliveryDetails( yearOfDelivery, semesterOfDelivery,courseId);
		if(courseDeliveryDetails.isEmpty())
			throw new CourseNotFoundException("Course Not Found"); 
			else return new ResponseEntity<CourseDeliveryDetails>(courseDeliveryDetails.get(),HttpStatus.OK);
	}
	
	@DeleteMapping("/{yearOfDelivery}/{semesterOfDelivery}/{courseId}")
	public ResponseEntity<Void> deleteCourseDelivery(@PathVariable int yearOfDelivery,@PathVariable int semesterOfDelivery,@PathVariable String courseId){
		courseDeliveryService.deleteCourseDelivery(yearOfDelivery,semesterOfDelivery,courseId);
		return  ResponseEntity.noContent().build();
	}

}
