package com.iit.coursemanager.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iit.coursemanager.entity.Course;

public interface CourseRepository extends JpaRepository<Course, String> {

}
