package com.resource.app.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "Batches")
public class Batch {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer batchId;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate commencementDate;

	@ManyToOne
	@JoinColumn(name = "courseId")
	private Course course;

	@ManyToOne
	@JoinColumn(name = "coordinatorId")
	private Coordinator coordinator;

	@ManyToOne
	@JoinColumn(name = "resourceTypeId")
	private ResourceDetails resourceDetails;

	public Integer getBatchId() {
		return batchId;
	}

	public void setBatchId(Integer batchId) {
		this.batchId = batchId;
	}

	public LocalDate getCommencementDate() {
		return commencementDate;
	}

	public void setCommencementDate(LocalDate commencementDate) {
		this.commencementDate = commencementDate;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
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
}
