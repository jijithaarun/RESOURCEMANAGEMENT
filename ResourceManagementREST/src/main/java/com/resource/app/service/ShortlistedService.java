package com.resource.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.resource.app.model.Shortlisted;
import com.resource.app.repository.iShortlistedRepo;

@Service
public class ShortlistedService implements iShortlistedService {

	@Autowired
	private iShortlistedRepo shortlistedRepo;

	@Override
	public Shortlisted addShortlisted(Shortlisted shortlisted) {
		// TODO Auto-generated method stub
		return shortlistedRepo.save(shortlisted);
	}
	
	@Override
	public List<Shortlisted> listShortlisted() {
		// TODO Auto-generated method stub
		return shortlistedRepo.findAll();
	}

}
