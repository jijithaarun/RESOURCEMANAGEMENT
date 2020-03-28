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

import com.resource.app.model.Evaluation;
import com.resource.app.service.IEvaluationService;

@CrossOrigin
@RestController
@RequestMapping("/")
public class EvaluvationController {
	@Autowired
	private IEvaluationService evaluvationService; 
	
	//add evaluation
	@PostMapping("evaluation")
	private ResponseEntity<Evaluation>addEvaluation(@RequestBody Evaluation evaluation){
		return new ResponseEntity<Evaluation>(evaluvationService.addEvaluation(evaluation),HttpStatus.OK);
	}
	
	//get all evaluation
	@GetMapping("evaluation")
	private ResponseEntity<List<Evaluation>> listAllEvaluation(){
		return new ResponseEntity<List<Evaluation>>(evaluvationService.listAllEvaluvation(),HttpStatus.OK);
	}
	
	

	
	
}
