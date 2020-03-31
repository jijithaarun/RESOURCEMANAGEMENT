package com.resource.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.resource.app.model.MultipleQualification;
import com.resource.app.repository.iMultipleQualificationRepo;

@Service
public class MultipleQualificationService implements iMultipleQualificatonService  {

	@Autowired
	private iMultipleQualificationRepo qualificationRepo;
	
	//add
	@Transactional
	@Override
	public MultipleQualification addQualification(MultipleQualification qualification) {
		return qualificationRepo.save(qualification);
	}

	//list
	@Override
	public List<MultipleQualification> listAllQualification() {
		
		return qualificationRepo.findAll();
	}

}
