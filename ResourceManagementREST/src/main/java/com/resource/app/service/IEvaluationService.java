package com.resource.app.service;

import java.util.List;

import com.resource.app.model.Evaluation;

public interface IEvaluationService {

	public Evaluation addEvaluation(Evaluation evaluation);

	public List<Evaluation> listAllEvaluvation();

}
