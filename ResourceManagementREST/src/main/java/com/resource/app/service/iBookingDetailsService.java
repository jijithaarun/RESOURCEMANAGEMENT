package com.resource.app.service;

import java.time.LocalDate;
import java.util.List;

import com.resource.app.model.BookingDetails;


public interface iBookingDetailsService {
	public BookingDetails addBooking(BookingDetails bookingDetails);

	public List<BookingDetails> listAllBooking();

	public BookingDetails findBookingById(Long bookingId);
	
	public void updateBookingStatus(Character BookedStatus, Long bookingId);
	
	public BookingDetails updateBooking(BookingDetails bookingDetails);
	
	public List<BookingDetails> viewReport(Long resourceId,LocalDate startDate,LocalDate curDate);
	
	public void viewAcceptedReport(BookingDetails bookingDetails);
	
	public void viewRejectedReport(BookingDetails bookingDetails);
	

}
