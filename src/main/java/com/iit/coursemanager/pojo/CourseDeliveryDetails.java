package com.iit.coursemanager.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CourseDeliveryDetails {
	private String courseCode;
	private String courseTitle;
	private String coursedescription;
	private int semesterOfDelivery;
	private int yearOfDelivery;
}
