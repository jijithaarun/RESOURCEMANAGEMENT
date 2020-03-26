package com.resource.app.repository;


import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.resource.app.model.BookingDetails;
import com.resource.app.model.ResourceDetails;

public interface iBookingDetailsRepo extends JpaRepositoryImplementation<BookingDetails, Long> {
	
	@Query("from BookingDetails where pending='Y' order by bookingId desc")
	List<BookingDetails> listAllBooking();

	
	@Modifying
	@Query("update BookingDetails set bookingStatus=?1 where bookingId=?2")
	void updateBookedStatus(Character bookingStatus,Long bookingId);
	
	@Query("from BookingDetails where resourceDetails.resourceId=?1 and startDate BETWEEN ?2 and ?3")
	List<BookingDetails> viewReport(Long resourceId,LocalDate startDate,LocalDate curDate);
	
	@Query("from BookingDetails where resourceId=?1 and startDate BETWEEN ?2 and ?3 and  bookingStatus='Y'")
	void viewAcceptedReport(Integer resourceId);
	
	@Query("from BookingDetails where resourceId=?1 and startDate BETWEEN ?2 and ?3 and bookingStatus='N'")
	void viewRejectedReport(Integer resourceId);
}
