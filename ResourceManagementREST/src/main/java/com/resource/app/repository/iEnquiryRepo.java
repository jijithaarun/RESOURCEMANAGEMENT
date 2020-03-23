package com.resource.app.repository;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.resource.app.model.Enquiry;

public interface iEnquiryRepo extends JpaRepositoryImplementation<Enquiry, Integer> {

	@Query("from Enquiry where enquiryDate=?1")
	Enquiry findEnquiryByDate(LocalDate enquiryDate);
	
	@Modifying
	@Query("update Enquiry set status=?1 where enquiryId=?2")
	 void updateEnquirySatus(String status, Integer enquiryId);
}
