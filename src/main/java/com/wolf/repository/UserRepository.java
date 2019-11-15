package com.wolf.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.wolf.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

}
