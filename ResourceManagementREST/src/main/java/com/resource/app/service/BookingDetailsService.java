package com.resource.app.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.resource.app.model.BookingDetails;
import com.resource.app.repository.iBookingDetailsRepo;

@Service
public class BookingDetailsService implements iBookingDetailsService {

	@Autowired
	private iBookingDetailsRepo bookingRepo;

	@Transactional
	@Override
	public BookingDetails addBooking(BookingDetails bookingDetails) {

		return bookingRepo.save(bookingDetails);
	}

	@Override
	public List<BookingDetails> listAllBooking() {

		return bookingRepo.listAllBooking();
	}

	@Override
	public BookingDetails findBookingById(Long bookingId) {
		Optional<BookingDetails> findBookingId = bookingRepo.findById(bookingId);
		BookingDetails bookingDetails = findBookingId.isPresent() ? findBookingId.get() : null;
		return bookingDetails;
	}

	@Transactional
	@Override
	public void updateBookingStatus(Character BookedStatus, Long bookingId) {
		bookingRepo.updateBookedStatus(BookedStatus, bookingId);
	}

	@Transactional
	@Override
	public BookingDetails updateBooking(BookingDetails bookingDetails) {
		return bookingRepo.save(bookingDetails);
	}



	@Override
	public void viewAcceptedReport(BookingDetails bookingDetails) {
		
	}

	@Override
	public void viewRejectedReport(BookingDetails bookingDetails) {
	
	}

	@Override
	public List<BookingDetails> viewReport(Long resourceId, LocalDate startDate, LocalDate curDate) {
		return bookingRepo.viewReport(resourceId, startDate, curDate);
	}


}
