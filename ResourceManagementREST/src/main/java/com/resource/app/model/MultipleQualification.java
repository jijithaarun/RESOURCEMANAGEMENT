package com.resource.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class MultipleQualification {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer mQualificationId;
	
	@ManyToOne
	@JoinColumn(name = "qualificationId")
	private Qualification qualification;
	
	@ManyToOne
	@JoinColumn(name="registrationId")
	private Registration registration;
	
	private Integer mark;
	private Integer yearOfPassing;
	
	public Integer getmQualificationId() {
		return mQualificationId;
	}
	public void setmQualificationId(Integer mQualificationId) {
		this.mQualificationId = mQualificationId;
	}
	public Qualification getQualification() {
		return qualification;
	}
	public void setQualification(Qualification qualification) {
		this.qualification = qualification;
	}
	public Registration getRegistration() {
		return registration;
	}
	public void setRegistration(Registration registration) {
		this.registration = registration;
	}
	public Integer getMark() {
		return mark;
	}
	public void setMark(Integer mark) {
		this.mark = mark;
	}
	public Integer getYearOfPassing() {
		return yearOfPassing;
	}
	public void setYearOfPassing(Integer yearOfPassing) {
		this.yearOfPassing = yearOfPassing;
	}
	

}
