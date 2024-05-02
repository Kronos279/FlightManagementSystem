package com.FMS.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.FMS.entity.FlightSeat;

public interface FlightSeatRepository extends JpaRepository<FlightSeat, Integer> {

}
