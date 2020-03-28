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
	
	public List<BookingDetails> viewReport(Long resourceId,LocalDate startDate,LocalDate endDate);
	
	public List<BookingDetails> viewAcceptedReport(Long resourceId,LocalDate startDate,LocalDate endDate);
	
	public List<BookingDetails> viewRejectedReport(Long resourceId,LocalDate startDate,LocalDate endDate);
	

}
