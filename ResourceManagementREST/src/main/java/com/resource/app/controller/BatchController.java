package com.resource.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.resource.app.model.Batch;
import com.resource.app.service.iBatchService;

@CrossOrigin
@RestController
@RequestMapping("/")
public class BatchController {
	@Autowired

	// implement service 
	//create object
	iBatchService batchService;

	// list batchdetails
	@GetMapping("batch")
	public ResponseEntity<List<Batch>> listBatch() {	
		return new ResponseEntity<List<Batch>>(batchService.listBatch(), HttpStatus.OK);

	}

	// add to batch
	@PostMapping("batch") 
	public ResponseEntity<Batch> addBatch(@RequestBody Batch batch) {

		return new ResponseEntity<Batch>(batchService.addBatch(batch), HttpStatus.OK);

	}

	
}
