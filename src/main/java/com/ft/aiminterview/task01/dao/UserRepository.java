package com.ft.aiminterview.task01.dao;


import com.ft.aiminterview.task01.domain.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface UserRepository extends MongoRepository<User, String> {

    // TODO what shell be done to correct the method signature for this finder?
    User findByEmail(String email);

}
