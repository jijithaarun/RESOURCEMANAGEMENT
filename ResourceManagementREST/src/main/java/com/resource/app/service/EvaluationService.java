package com.resource.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.resource.app.model.Evaluation;
import com.resource.app.repository.IEvaluationRepo;

@Service
public class EvaluationService implements IEvaluationService {
	
	@Autowired
	private IEvaluationRepo evaluationRepo;

	@Transactional
	@Override
	public Evaluation addEvaluation(Evaluation evaluation) {
		// TODO Auto-generated method stub
		return evaluationRepo.save(evaluation);
	}

	@Override
	public List<Evaluation> listAllEvaluvation() {
		// TODO Auto-generated method stub
		return evaluationRepo.findAll();
	}


}
