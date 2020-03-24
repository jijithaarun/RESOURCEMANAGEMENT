package com.resource.app.repository;



import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.resource.app.model.Coordinator;

public interface iCoordinatorRepo extends JpaRepositoryImplementation<Coordinator, Integer> {

}
