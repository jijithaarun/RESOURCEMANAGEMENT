package com.resource.app.service;

import java.util.List;

import com.resource.app.model.BookingDetails;


public interface iBookingDetailsService {
	public BookingDetails addBooking(BookingDetails bookingDetails);

	public List<BookingDetails> listAllBooking();

	public BookingDetails findBookingById(Long bookingId);
	
	public void updateBookingStatus(Character BookedStatus, Long bookingId);
	

}
