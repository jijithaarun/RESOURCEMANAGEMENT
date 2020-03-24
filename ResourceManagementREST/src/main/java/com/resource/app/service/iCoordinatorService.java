package com.resource.app.service;

import java.util.List;

import com.resource.app.model.Coordinator;

public interface iCoordinatorService {

	// adding Coordinator
	public Coordinator addCoordinator(Coordinator coordinator);

	// list Coordinator
	public List<Coordinator> listCoordinator();


}
