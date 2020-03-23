package com.resource.app.repository;


import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.resource.app.model.BookingDetails;

public interface iBookingDetailsRepo extends JpaRepositoryImplementation<BookingDetails, Long> {
	
	@Query("from BookingDetails where bookingStatus='Y' order by bookingId desc")
	List<BookingDetails> listAllBooking();

	
	@Modifying
	@Query("update BookingDetails set bookingStatus=?1 where bookingId=?2")
	void updateBookedStatus(Character bookingStatus,Long bookingId);
}
