package com.wolf.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wolf.domain.Post;
import com.wolf.repository.PostRepository;
import com.wolf.service.exeception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository repository;

	public Post findById(String id) {
		Optional<Post> post = repository.findById(id);
		return post.orElseThrow(() -> new ObjectNotFoundException("Object not found"));
	}
	
	public List<Post> findByTitle(String text){
		return repository.findByTitleContaining(text);
	}
	
	public List<Post> findByTitleIgnoreCase(String text){
		return repository.findByTitleContainingIgnoreCase(text);
	}
}
