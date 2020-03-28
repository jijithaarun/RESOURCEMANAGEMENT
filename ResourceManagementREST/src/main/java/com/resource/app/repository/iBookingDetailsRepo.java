package com.resource.app.repository;


import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.resource.app.model.BookingDetails;

public interface iBookingDetailsRepo extends JpaRepositoryImplementation<BookingDetails, Long> {
	
	@Query("from BookingDetails where pending='Y' order by bookingId desc")
	List<BookingDetails> listAllBooking();

	
	@Modifying
	@Query("update BookingDetails set bookingStatus=?1 where bookingId=?2")
	void updateBookedStatus(Character bookingStatus,Long bookingId);
	
	@Query("from BookingDetails where resourceDetails.resourceId=?1 and startDate between ?2 and ?3")
	List<BookingDetails> viewReport(Long resourceId,LocalDate startDate,LocalDate endDate);
	
	@Query("from BookingDetails where resourceDetails.resourceId=?1 and startDate between ?2 and ?3 and  bookingStatus='Y'")
	List<BookingDetails> viewAcceptedReport(Long resourceId,LocalDate startDate,LocalDate endDate);
	
	@Query("from BookingDetails where resourceDetails.resourceId=?1 and startDate between ?2 and ?3 and bookingStatus='N'")
	List<BookingDetails> viewRejectedReport(Long resourceId,LocalDate startDate,LocalDate endDate);
}
