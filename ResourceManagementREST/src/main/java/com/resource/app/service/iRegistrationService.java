package com.resource.app.service;

import java.util.List;

import com.resource.app.model.Registration;
import com.resource.app.model.ResourceDetails;

public interface iRegistrationService {

	// adding registration
	public Registration addRegistration(Registration registration);

	// list registration
	public List<Registration> listRegistration();
	
	//find by course name	
	public List<Registration> findRegistrationByName(String courseName);
}
