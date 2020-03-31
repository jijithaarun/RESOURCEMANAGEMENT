package com.resource.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.resource.app.model.MultipleQualification;
import com.resource.app.service.iMultipleQualificatonService;

@CrossOrigin
@RestController
@RequestMapping("/")
public class MultipleQualificationController {
	
//object of service
	@Autowired
	private iMultipleQualificatonService qualificationService;

	// adding the qualification details
	@PostMapping("multiple")
	public ResponseEntity<MultipleQualification> addMultiQualification(MultipleQualification qualification) {
		return new ResponseEntity<MultipleQualification>(qualificationService.addQualification(qualification),
				HttpStatus.OK);

	}

	// get all the qualification details
	@GetMapping("multiple")
	public ResponseEntity<List<MultipleQualification>> listMultiQualification() {
		return new ResponseEntity<List<MultipleQualification>>(qualificationService.listAllQualification(),
				HttpStatus.OK);

	}

}
