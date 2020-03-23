package com.resource.app.service;

import java.util.List;

import com.resource.app.model.Course;

public interface iCourseService {
	
	public Course addCourse(Course course);
	
	public List<Course> listAllCourse();
	

}
