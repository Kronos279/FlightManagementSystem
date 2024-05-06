package com.FMS.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.FMS.entity.FlightSeat;

import feign.Param;
import jakarta.transaction.Transactional;


@Repository
public interface FlightSeatRepository extends JpaRepository<FlightSeat, Integer> {

	
	 	@Transactional
	    @Modifying
	    @Query("UPDATE FlightSeat fs SET fs.Booking_id = :bookingId WHERE fs.seat_id = :seatId")
	    void updateBookingIdById(@Param("bookingId") String bookingId, @Param("seatId") int seatId);
	 	
	 	@Query("SELECT fs FROM FlightSeat fs WHERE fs.flight_id = :flightId")
	    List<FlightSeat> findByFlightId(int flightId);
	 	
}