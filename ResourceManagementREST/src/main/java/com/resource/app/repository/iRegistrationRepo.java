package com.resource.app.repository;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.resource.app.model.Registration;

public interface iRegistrationRepo extends JpaRepositoryImplementation<Registration, Integer> {

}
