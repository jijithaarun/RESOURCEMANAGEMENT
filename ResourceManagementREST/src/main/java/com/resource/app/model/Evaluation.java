package com.resource.app.model;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class Evaluation {
	
	@ManyToOne
	@JoinColumn(name="registrationId")
	private Registration registraton;
	private Integer aptitudeScore;
	private Integer interviewScore;
	private Double percentage;
	private Boolean statusQualified;
	
	public Registration getRegistraton() {
		return registraton;
	}
	public void setRegistraton(Registration registraton) {
		this.registraton = registraton;
	}
	public Integer getAptitudeScore() {
		return aptitudeScore;
	}
	public void setAptitudeScore(Integer aptitudeScore) {
		this.aptitudeScore = aptitudeScore;
	}
	public Integer getInterviewScore() {
		return interviewScore;
	}
	public void setInterviewScore(Integer interviewScore) {
		this.interviewScore = interviewScore;
	}
	public Double getPercentage() {
		return percentage;
	}
	public void setPercentage(Double percentage) {
		this.percentage = percentage;
	}
	public Boolean getStatusQualified() {
		return statusQualified;
	}
	public void setStatusQualified(Boolean statusQualified) {
		this.statusQualified = statusQualified;
	}

}
