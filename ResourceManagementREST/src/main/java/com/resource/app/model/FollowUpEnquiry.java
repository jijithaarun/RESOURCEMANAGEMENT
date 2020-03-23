package com.resource.app.model;

import java.time.LocalDate;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class FollowUpEnquiry {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer followUpEnquiryId;
	
	@ManyToOne
	@JoinColumn(name="enquiryId")
	private Enquiry enquiry;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate followUpDate;
	
	@ManyToOne
	@JoinColumn(name="coordinatorId")
	private Coordinator coordinator;
	
	private String comments;

	public Integer getFollowUpEnquiryId() {
		return followUpEnquiryId;
	}

	public void setFollowUpEnquiryId(Integer followUpEnquiryId) {
		this.followUpEnquiryId = followUpEnquiryId;
	}

	public Enquiry getEnquiry() {
		return enquiry;
	}

	public void setEnquiry(Enquiry enquiry) {
		this.enquiry = enquiry;
	}

	public LocalDate getFollowUpDate() {
		return followUpDate;
	}

	public void setFollowUpDate(LocalDate followUpDate) {
		this.followUpDate = followUpDate;
	}

	public Coordinator getCoordinator() {
		return coordinator;
	}

	public void setCoordinator(Coordinator coordinator) {
		this.coordinator = coordinator;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}
	
	
}
