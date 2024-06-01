package com.FMS.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.FMS.entity.BookingInfo;

@Repository
public interface BookingInfoRepository extends MongoRepository<BookingInfo, String>{

	@Query("{'seat_id': ?0}")
    BookingInfo updateBookingBySeatId(int i, BookingInfo updatedBookingInfo);

    @Query("{'seatNumber': ?0}")
    BookingInfo updateBookingBySeatNumber(String seatNumber, BookingInfo updatedBookingInfo);
	
	public List<BookingInfo> findByPnrNumber(String pnrNumber);
	
	@Query(value = "{ 'flight_id': ?0, 'booking_id': { $ne: null } }", count = true)
	 int countBookingsByFlightId(int flightId);
}
