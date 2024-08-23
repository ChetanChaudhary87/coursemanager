package com.iit.coursemanager.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.iit.coursemanager.entity.CourseDelivery;
import com.iit.coursemanager.pojo.CourseDeliveryDetails;

public interface CourseDeliveryRepository extends JpaRepository<CourseDelivery,String> {
	
	@Query("SELECT new com.iit.coursemanager.pojo.CourseDeliveryDetails(t2.course_code, t2.title,t2.description,t1.semesterOfDelivery, t1.yearOfDelivery ) " +
	           "FROM CourseDelivery t1 JOIN Course t2 ON t1.courseID = t2.course_code WHERE t1.yearOfDelivery = ?1 AND t1.semesterOfDelivery = ?2")
	List<CourseDeliveryDetails> getList( int yearOfDelivery, int semesterOfDelivery);
	
	
	@Query("SELECT new com.iit.coursemanager.pojo.CourseDeliveryDetails(t2.course_code, t2.title,t2.description,t1.semesterOfDelivery, t1.yearOfDelivery ) " +
	           "FROM CourseDelivery t1 JOIN Course t2 ON t1.courseID = t2.course_code WHERE t1.yearOfDelivery = ?1 AND t1.semesterOfDelivery = ?2 AND t1.courseID = ?3")
	Optional<CourseDeliveryDetails>  getCourseDeliveryDetails( int yearOfDelivery, int semesterOfDelivery,String courseId);

	@Query("SELECT c from CourseDelivery c  where c.courseID = ?1")
	Optional<CourseDelivery> findByCourseId(String courseID);
	
	@Modifying
    @Transactional
	@Query("DELETE FROM CourseDelivery t WHERE t.yearOfDelivery = ?1 AND t.semesterOfDelivery = ?2 AND t.courseID = ?3")
	void deleteCourseDelivery(int yearOfDelivery, int semesterOfDelivery,String courseId);
}
