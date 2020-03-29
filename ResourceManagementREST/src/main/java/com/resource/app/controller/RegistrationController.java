package com.resource.app.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.resource.app.model.Registration;
import com.resource.app.service.iRegistrationService;

@CrossOrigin
@RestController
@RequestMapping("/")

public class RegistrationController {

	@Autowired

	// implement service
	iRegistrationService registrationService;

	// list registration
	@GetMapping("registration")
	public ResponseEntity<List<Registration>> listRegistration() {

		return new ResponseEntity<List<Registration>>(registrationService.listRegistration(), HttpStatus.OK);

	}

//add to registration
	@PostMapping("registration") // get the registration
	public ResponseEntity<Registration> addRegistration(@RequestBody Registration registration) {

		return new ResponseEntity<Registration>(registrationService.addRegistration(registration), HttpStatus.OK);

	}

	// find registration by name
	@GetMapping("registration/{courseName}")
	public List<Registration> findRegisterByName(@PathVariable("courseName") String courseName) {
		System.out.println("searching ");
		List<Registration> viewRegisterDetails = registrationService.findRegistrationByName(courseName);
		return viewRegisterDetails;
	}
	

}
