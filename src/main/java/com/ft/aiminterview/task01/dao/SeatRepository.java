package com.ft.aiminterview.task01.dao;


import com.ft.aiminterview.task01.domain.Seat;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeatRepository extends MongoRepository<Seat, ObjectId> {

}
