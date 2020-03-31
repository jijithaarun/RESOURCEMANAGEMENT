package com.resource.app.repository;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.resource.app.model.Evaluation;

public interface IEvaluationRepo extends JpaRepositoryImplementation<Evaluation, Integer> {

}
