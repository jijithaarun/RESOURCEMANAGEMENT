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

import com.resource.app.model.Qualification;
import com.resource.app.service.iQualificationService;

@CrossOrigin
@RestController
@RequestMapping("/")
public class QualificationController {

	@Autowired
	private iQualificationService qualificationService;

	// adding qualification
	@PostMapping("qualification")
	public ResponseEntity<Qualification> addQualification(@RequestBody Qualification qualification) {
		return new ResponseEntity<Qualification>(qualificationService.addQualification(qualification), HttpStatus.OK);

	}

	// get all qualification
	@GetMapping("qualification")
	public ResponseEntity<List<Qualification>> listAllQualification() {
		return new ResponseEntity<List<Qualification>>(qualificationService.listQualification(), HttpStatus.OK);

	}

}
