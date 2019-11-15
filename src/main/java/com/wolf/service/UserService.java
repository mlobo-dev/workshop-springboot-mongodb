package com.wolf.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wolf.domain.User;
import com.wolf.dto.UserDTO;
import com.wolf.repository.UserRepository;
import com.wolf.service.exeception.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	public User fromDTO(UserDTO userDTO) {
		return new User(userDTO.getId(), userDTO.getName(), userDTO.getEmail());
	}

	public List<User> findAll() {
		return repository.findAll();
	}

	public User findById(String id) {
		Optional<User> user = repository.findById(id);
		return user.orElseThrow(() -> new ObjectNotFoundException("Object not found"));
	}

	public User insert(User user) {
		return repository.insert(user);
	}

	public void delete(String id) {
		findById(id);
		repository.deleteById(id);
	}

	public User update(User user) {
		Optional<User> newUser = repository.findById(user.getId());
		updateData(newUser, user);
		return repository.save(newUser.get());

	}

	private void updateData(Optional<User> newUser, User user) {
		newUser.get().setName(user.getName());
		newUser.get().setEmail(user.getEmail());

	}
}
