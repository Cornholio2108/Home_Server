package com.home_server.user;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

import org.springframework.stereotype.Component;

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
