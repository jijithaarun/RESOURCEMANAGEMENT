package com.resource.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.resource.app.model.BookingDetails;
import com.resource.app.service.iBookingDetailsService;

@CrossOrigin
@RestController
@RequestMapping("/")
public class BookingDetailsController {

	@Autowired
	private iBookingDetailsService bookingService;

	// add booking
	@PostMapping("booking")
	public ResponseEntity<BookingDetails> addBooking(@RequestBody BookingDetails booking) {
		return new ResponseEntity<BookingDetails>(bookingService.addBooking(booking), HttpStatus.OK);
	}

	// get all the booking details
	@GetMapping("booking")
	public ResponseEntity<List<BookingDetails>> listAllBooking() {
		return new ResponseEntity<List<BookingDetails>>(bookingService.listAllBooking(), HttpStatus.OK);
	}

	// find booking details by id
	@GetMapping("booking/{bookingId}")
	public ResponseEntity<BookingDetails> findAllBookingById(@PathVariable("bookingId") Long bookingId) {
		System.out.print("search the booking details by id");
		ResponseEntity<BookingDetails> response = null;
		BookingDetails booking = bookingService.findBookingById(bookingId);
		if (booking == null) {
			response = new ResponseEntity<BookingDetails>(HttpStatus.NOT_FOUND);
		} else {
			response = new ResponseEntity<BookingDetails>(booking, HttpStatus.OK);
		}
		return response;
	}

	// update booking status
	@PutMapping("booking-status/{bookingId}&{bookingStatus}")
	public void updateBookinfgStatus(@PathVariable("bookingId") Long bookingId,
			@PathVariable("bookingStatus") Character bookingStatus) {
		bookingService.updateBookingStatus(bookingStatus, bookingId);
	}

	// update booking
	@PutMapping("booking")
	public ResponseEntity<BookingDetails> updateBooking(@RequestBody BookingDetails booking) {
		return new ResponseEntity<BookingDetails>(bookingService.updateBooking(booking), HttpStatus.OK);
	}
}
