package com.home_server.boundary.user;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

import org.springframework.stereotype.Component;

import com.home_server.application.user.UserService;
import com.home_server.domain.user.User;

@Component
public class UserDTOService {
	@Inject
	private UserService userService;
	@Inject
	private UserAssembler userAssembler;

	public List<UserDTO> findAllUsers() {
		List<User> userList = userService.findAllUsers();
		List<UserDTO> userDTOList = new ArrayList<UserDTO>();
		for (User user : userList) {
			userDTOList.add(userAssembler.createDTO(user));
		}
		return userDTOList;
	}

	public UserDTO createUser(UserDTO dto) {
		User user = userAssembler.createEntity(dto);
		user = userService.createUser(user);
		dto = userAssembler.createDTO(user);
		return dto;
	}
}
