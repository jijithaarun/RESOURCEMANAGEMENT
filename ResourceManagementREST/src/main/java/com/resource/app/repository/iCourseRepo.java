package com.resource.app.repository;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.resource.app.model.Course;

public interface iCourseRepo extends JpaRepositoryImplementation<Course, Integer> {

}
