package com.resource.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.resource.app.model.Course;
import com.resource.app.repository.iCourseRepo;

@Service
public class CourseService implements iCourseService{

	@Autowired
	private iCourseRepo courseRepo;
	
	@Transactional
	@Override
	public Course addCourse(Course course) {
		
		return courseRepo.save(course);
	}

	@Override
	public List<Course> listAllCourse() {
	
		return courseRepo.findAll();
	}

}
