package com.resource.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.resource.app.model.Payment;
import com.resource.app.repository.iPaymentRepo;

@Service
public class PaymentService implements iPaymentService {
	
	@Autowired
	private iPaymentRepo paymentRepo;
	// add payment
	@Transactional
	@Override
	public Payment addPayment(Payment payment) {

		return paymentRepo.save(payment);
	}

  //list payments
	@Override
	public List<Payment> listPayment() {
		return paymentRepo.findAll();
	}

}
