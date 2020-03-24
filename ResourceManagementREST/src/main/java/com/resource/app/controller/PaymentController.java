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
import com.resource.app.model.Payment;
import com.resource.app.service.iPaymentService;

@CrossOrigin
@RestController
@RequestMapping("/")
public class PaymentController {

	@Autowired
	private iPaymentService paymentService;

	// adding the payment details
	@PostMapping("payment")
	public ResponseEntity<Payment> addPayment(@RequestBody Payment payment) {
		return new ResponseEntity<Payment>(paymentService.addPayment(payment), HttpStatus.OK);

	}

	// get all the payments
	@GetMapping("payment")
	public ResponseEntity<List<Payment>> listPayments() {
		return new ResponseEntity<List<Payment>>(paymentService.listPayment(), HttpStatus.OK);

	}

}
