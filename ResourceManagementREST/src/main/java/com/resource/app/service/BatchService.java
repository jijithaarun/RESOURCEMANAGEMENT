package com.resource.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.resource.app.model.Batch;
import com.resource.app.repository.iBatchRepo;

@Service
public class BatchService implements iBatchService {

	// create object of repo
	@Autowired
	private iBatchRepo batchRepo;

	// adding to batch
	@Transactional
	@Override
	public Batch addBatch(Batch batch) {

		return batchRepo.save(batch);
	}

//list batch
	@Override
	public List<Batch> listBatch() {

		return batchRepo.findAll();
	}

}
