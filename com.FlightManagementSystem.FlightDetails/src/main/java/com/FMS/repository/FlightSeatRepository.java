package com.FMS.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.FMS.entity.FlightSeat;

@Repository
public interface FlightSeatRepository extends JpaRepository<FlightSeat, Integer> {
	@Query("SELECT fs FROM FlightSeat fs WHERE fs.flight_id = :flightId")
    List<FlightSeat> findByFlightId(int flightId);
}
