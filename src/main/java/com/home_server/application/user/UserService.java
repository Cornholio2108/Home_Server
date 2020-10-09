package com.home_server.application.user;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.home_server.domain.user.User;
import com.home_server.repositories.user.UserRepository;

@ApplicationScoped
@Component
public class UserService {
	@Autowired
	private UserRepository userRepository;

	public List<User> findAllUsers() {
		return (List<User>) userRepository.findAll();
	}

	public User createUser(User entity) {
		entity = userRepository.save(entity);
		return entity;
	}
}
