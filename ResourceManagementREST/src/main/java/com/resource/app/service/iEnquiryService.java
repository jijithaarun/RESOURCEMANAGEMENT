package com.resource.app.service;

import java.time.LocalDate;
import java.util.List;

import com.resource.app.model.Enquiry;

public interface iEnquiryService {
	
	public Enquiry addEnquiry(Enquiry enquiry);
	
	public List<Enquiry> listAllEnquiry();
	
	public Enquiry findEnquiryByDate(LocalDate enquiryDate);
	
	public void updateEnquirySatus(String status,Integer enquiryId);	

}
