package com.resource.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.resource.app.model.Qualification;
import com.resource.app.repository.iQualificationRepo;

@Service
public class QualificaionService implements iQualificationService {

	@Autowired
	private iQualificationRepo qualificationRepo;

	@Transactional
	@Override
	public Qualification addQualification(Qualification qualification) {

		return qualificationRepo.save(qualification);
	}

	@Override
	public List<Qualification> listQualification() {

		return qualificationRepo.findAll();
	}

}
