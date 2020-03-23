package com.resource.app.repository;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.resource.app.model.Batch;

public interface iBatchRepo extends JpaRepositoryImplementation<Batch, Integer> {

}
