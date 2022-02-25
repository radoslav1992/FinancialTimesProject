package com.ft.aiminterview.task01.dao;


import com.ft.aiminterview.task01.domain.Licence;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LicenseRepository extends MongoRepository<Licence, ObjectId> {

    //TODO add finder that would return all licenses with specific product codes e.g, P1, P2

}
