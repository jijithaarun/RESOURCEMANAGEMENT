package com.resource.app.repository;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.resource.app.model.Payment;

public interface iPaymentRepo extends JpaRepositoryImplementation<Payment, Integer>{

}
