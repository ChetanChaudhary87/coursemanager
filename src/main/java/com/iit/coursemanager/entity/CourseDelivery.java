package com.iit.coursemanager.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CourseDelivery {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String courseID;
	private int semesterOfDelivery;
	private int yearOfDelivery;

}
