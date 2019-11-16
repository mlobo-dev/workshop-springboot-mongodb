package com.wolf.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.wolf.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

	List<Post> findByTitleContaining(String text);
	
	@Query("{ <title>: { $regex: ?0, $options: 'i' } }")
	List<Post> serchTitle(String text);
	
	List<Post> findByTitleContainingIgnoreCase(String text);
}
