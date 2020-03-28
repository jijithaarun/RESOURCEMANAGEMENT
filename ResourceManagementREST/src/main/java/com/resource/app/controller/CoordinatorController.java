package com.resource.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.resource.app.model.Coordinator;
import com.resource.app.service.iCoordinatorService;

@CrossOrigin
@RestController
@RequestMapping("/")
public class CoordinatorController {

	@Autowired

	// implement service
	iCoordinatorService coordinatorService;

	// list coordinator
	@GetMapping("coordinator")
	public ResponseEntity<List<Coordinator>> listCoordinator() {

		return new ResponseEntity<List<Coordinator>>(coordinatorService.listCoordinator(), HttpStatus.OK);

	}

	// add Coordinator
	@PostMapping("coordinator") // insert the details
	public ResponseEntity<Coordinator> addCoordinator(@RequestBody Coordinator coordinator) {

		return new ResponseEntity<Coordinator>(coordinatorService.addCoordinator(coordinator), HttpStatus.OK);

	}


}
