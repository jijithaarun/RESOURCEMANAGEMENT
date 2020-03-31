package com.resource.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.resource.app.model.Coordinator;
import com.resource.app.repository.iCoordinatorRepo;

@Service
public class CoordinatorService implements iCoordinatorService {


	@Autowired
	private iCoordinatorRepo coordinatorRepo;	
	
	//add
	@Transactional
	@Override
	public Coordinator addCoordinator(Coordinator coordinator) {
		
		return coordinatorRepo.save(coordinator);
	}
	//list coordinator

	@Override
	public List<Coordinator> listCoordinator() {
		
		return coordinatorRepo.findAll();
	}

}
