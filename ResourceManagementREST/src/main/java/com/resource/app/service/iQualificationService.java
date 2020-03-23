package com.resource.app.service;

import java.util.List;

import com.resource.app.model.Qualification;

public interface iQualificationService {

	public Qualification addQualification(Qualification qualification);
	
	public List<Qualification> listQualification();
}
