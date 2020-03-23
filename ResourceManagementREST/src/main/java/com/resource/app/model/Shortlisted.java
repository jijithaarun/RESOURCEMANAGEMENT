package com.resource.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Shortlisted {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer shortlistedId;
	
	@ManyToOne
	@JoinColumn(name = "registrationId")
	private Registration registration;

	@ManyToOne
	@JoinColumn(name = "courseId")
	private Course course;

	@ManyToOne
	@JoinColumn(name = "batchId")
	private Batch batch;

	public Registration getRegistration() {
		return registration;
	}

	public void setRegistration(Registration registration) {
		this.registration = registration;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Batch getBatch() {
		return batch;
	}

	public void setBatch(Batch batch) {
		this.batch = batch;
	}

}
