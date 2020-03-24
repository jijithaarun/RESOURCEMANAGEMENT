package com.resource.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.resource.app.model.Course;
import com.resource.app.service.iCourseService;

@CrossOrigin
@RestController
@RequestMapping("/")
public class CourseController {

	@Autowired
	private iCourseService courseService;

	// adding the course details
	@PostMapping("course")
	public ResponseEntity<Course> addCourse(@RequestBody Course course) {
		System.out.println("course details");
		System.out.println(course);
		return new ResponseEntity<Course>(courseService.addCourse(course), HttpStatus.OK);

	}

	// get all the course
	@GetMapping("course")
	public ResponseEntity<List<Course>> listAllCourses() {
		return new ResponseEntity<List<Course>>(courseService.listAllCourse(), HttpStatus.OK);

	}

}
