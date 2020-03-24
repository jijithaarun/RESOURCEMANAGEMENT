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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.resource.app.model.Enquiry;
import com.resource.app.service.iEnquiryService;

@CrossOrigin
@RestController
@RequestMapping("/")
public class EnquiryController {

	@Autowired
	private iEnquiryService enquiryService;

	// add enquiry
	@PostMapping("enquiry")
	public ResponseEntity<Enquiry> addEnquiryDetails(@RequestBody Enquiry enquiry) {
		return new ResponseEntity<Enquiry>(enquiryService.addEnquiry(enquiry), HttpStatus.OK);
	}

	// upadte enquiry status
	@PutMapping("enquiry/{enquiryId}&{status}")
	public void updateEnquiry(@PathVariable("enquiryId") Integer enquiryId, @PathVariable("status") String status) {
		enquiryService.updateEnquirySatus(status, enquiryId);
	}

	// get the values from enquiry table based on enquirydate
	@GetMapping("enquiry/{enquiryDate}")
	public ResponseEntity<Enquiry> findEnquiryByDate(@PathVariable("enquiryDate") LocalDate enquiryDate) {
		ResponseEntity<Enquiry> response = null;
		Enquiry enquiry = enquiryService.findEnquiryByDate(enquiryDate);
		if (enquiry == null) {
			response = new ResponseEntity<Enquiry>(HttpStatus.NOT_FOUND);
		} else {
			response = new ResponseEntity<Enquiry>(enquiry, HttpStatus.OK);
		}
		return response;

	}

	//get all enquiry details
	@GetMapping("enquiry")
	public ResponseEntity<List<Enquiry>> listAllEnquiry(Enquiry enquiry) {
		return new ResponseEntity<List<Enquiry>>(enquiryService.listAllEnquiry(), HttpStatus.OK);
	}

}
