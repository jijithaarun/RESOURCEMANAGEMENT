package com.resource.app.service;

import java.util.List;

import com.resource.app.model.MultipleQualification;

public interface iMultipleQualificatonService {

	// add qualification details
	public MultipleQualification addQualification(MultipleQualification qualification);

	// list qualification details
	public List<MultipleQualification> listAllQualification();

}
