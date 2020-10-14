package com.home_server.application.user;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.home_server.domain.user.User;
import com.home_server.repositories.user.UserRepository;

@Service
@Transactional
public class UserService {
//	@Resource
//	private UserRepository userRepository;
//
//	@Transactional(readOnly = true)
//	public List<User> findAllUsers() {
//		return (List<User>) userRepository.findAll();
//	}
//
//	@Transactional(readOnly = false)
//	public User createUser(User entity) {
//		entity = userRepository.save(entity);
//		return entity;
//	}
}
