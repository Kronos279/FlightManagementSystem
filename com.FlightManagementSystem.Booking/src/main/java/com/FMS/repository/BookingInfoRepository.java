package com.FMS.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.FMS.entity.BookingInfo;

@Repository
public interface BookingInfoRepository extends MongoRepository<BookingInfo, String>{

	
	public List<BookingInfo> findByPnrNumber(String pnrNumber);
}
