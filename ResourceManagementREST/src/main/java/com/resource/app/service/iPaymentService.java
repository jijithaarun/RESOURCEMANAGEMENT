package com.resource.app.service;

import java.util.List;

import com.resource.app.model.Payment;

public interface iPaymentService {
	// adding payment
	public Payment addPayment(Payment payment);

	// list payment
	public List<Payment> listPayment();

}
