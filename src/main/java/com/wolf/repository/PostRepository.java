package com.wolf.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.wolf.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

}
