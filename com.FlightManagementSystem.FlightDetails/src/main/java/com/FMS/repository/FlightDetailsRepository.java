package com.FMS.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.FMS.entity.FlightDetails;

@Repository
public interface FlightDetailsRepository extends JpaRepository<FlightDetails, Integer>{

}
