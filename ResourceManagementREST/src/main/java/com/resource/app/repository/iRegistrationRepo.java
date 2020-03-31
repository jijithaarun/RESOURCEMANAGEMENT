package com.resource.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import com.resource.app.model.Registration;

public interface iRegistrationRepo extends JpaRepositoryImplementation<Registration, Integer> {
	//search registration by course name
	@Modifying
	@Query("from registration where course.courseName=?1")
	List<Registration> findByRegistration(String courseName);
	
	
	

}
