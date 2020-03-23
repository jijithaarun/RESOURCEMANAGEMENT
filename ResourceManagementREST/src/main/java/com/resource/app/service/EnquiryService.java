package com.resource.app.service;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.resource.app.model.Enquiry;
import com.resource.app.repository.iEnquiryRepo;

@Service
public class EnquiryService implements iEnquiryService {

	@Autowired
	private iEnquiryRepo enquiryRepo;

	@Transactional
	@Override
	public Enquiry addEnquiry(Enquiry enquiry) {

		return enquiryRepo.save(enquiry);
	}

	@Override
	public List<Enquiry> listAllEnquiry() {

		return enquiryRepo.findAll();
	}

	@Override
	public Enquiry findEnquiryByDate(LocalDate enquiryDate) {

		return enquiryRepo.findEnquiryByDate(enquiryDate);
	}

	@Transactional
	@Override
	public void updateEnquirySatus(String status, Integer enquiryId) {
		enquiryRepo.updateEnquirySatus(status, enquiryId);

	}

}
