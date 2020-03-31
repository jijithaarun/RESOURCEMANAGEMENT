package com.resource.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.resource.app.model.Registration;
import com.resource.app.repository.iRegistrationRepo;

@Service
public class RegistrationService implements iRegistrationService {
	// create object of registration repo
	@Autowired
	private iRegistrationRepo registrationRepo;

	// adding to registration
	@Transactional
	@Override
	public Registration addRegistration(Registration registration) {

		return registrationRepo.save(registration);
	}

	// list registration table
	@Override
	public List<Registration> listRegistration() {

		return registrationRepo.findAll();
		
	}
 //find by course name
	@Override
	public List<Registration> findRegistrationByName(String courseName) {
		
		return registrationRepo.findByRegistration(courseName);
	}

}
