package com.FMS.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.FMS.entity.CheckIn;

public interface CheckInRepository extends JpaRepository<CheckIn, String>{

}
