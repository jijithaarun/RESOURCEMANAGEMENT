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

import com.resource.app.model.Shortlisted;
import com.resource.app.service.iShortlistedService;

@CrossOrigin
@RestController
@RequestMapping("/")
public class ShortlistedController {

	@Autowired
	private iShortlistedService shortlistedService;

	// add shortlisted
	@PostMapping("shortlisted")
	public ResponseEntity<Shortlisted> addShortlisted(@RequestBody Shortlisted shortlisted) {
		return new ResponseEntity<Shortlisted>(shortlistedService.addShortlisted(shortlisted), HttpStatus.OK);
	}

	// list all shortlisted
	@GetMapping("shortlisted")
	public ResponseEntity<List<Shortlisted>> listAllShortListed() {
		return new ResponseEntity<List<Shortlisted>>(shortlistedService.listShortlisted(), HttpStatus.OK);
	}

}
