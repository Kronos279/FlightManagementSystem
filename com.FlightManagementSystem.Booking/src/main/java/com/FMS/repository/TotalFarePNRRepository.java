package com.FMS.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.FMS.entity.TotalFarePNR;

@Repository
public interface TotalFarePNRRepository extends MongoRepository<TotalFarePNR, String> {

}
