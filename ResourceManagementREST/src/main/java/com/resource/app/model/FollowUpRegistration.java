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
public class FollowUpRegistration {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer flRegistartioId;
	
	@ManyToOne
	@JoinColumn(name="registrationId")
	private Registration registration;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate followDate;
	
	@ManyToOne
	@JoinColumn(name="coordinatorId")
	private Coordinator coordinator;
	
	@ManyToOne
	@JoinColumn(name="resourceId")
	private ResourceDetails resourceDetails;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate examDate;

	public Integer getFlRegistartioId() {
		return flRegistartioId;
	}

	public void setFlRegistartioId(Integer flRegistartioId) {
		this.flRegistartioId = flRegistartioId;
	}

	public Registration getRegistration() {
		return registration;
	}

	public void setRegistration(Registration registration) {
		this.registration = registration;
	}

	public LocalDate getFollowDate() {
		return followDate;
	}

	public void setFollowDate(LocalDate followDate) {
		this.followDate = followDate;
	}

	public Coordinator getCoordinator() {
		return coordinator;
	}

	public void setCoordinator(Coordinator coordinator) {
		this.coordinator = coordinator;
	}

	public ResourceDetails getResourceDetails() {
		return resourceDetails;
	}

	public void setResourceDetails(ResourceDetails resourceDetails) {
		this.resourceDetails = resourceDetails;
	}

	public LocalDate getExamDate() {
		return examDate;
	}

	public void setExamDate(LocalDate examDate) {
		this.examDate = examDate;
	}
		
}
