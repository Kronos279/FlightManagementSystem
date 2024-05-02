package com.FMS.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.FMS.entity.FlightSeat;

@Repository
public interface FlightSeatRepository extends JpaRepository<FlightSeat, Integer> {
}
