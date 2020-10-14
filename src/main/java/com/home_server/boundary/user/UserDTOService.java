package com.home_server.boundary.user;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.home_server.application.user.UserService;
import com.home_server.domain.user.User;

@Component
public class UserDTOService {
	@Resource
	private UserService userService;
	@Resource
	private UserAssembler userAssembler;

	public List<UserDTO> findAllUsers() {
//		List<User> userList = userService.findAllUsers();
//		List<UserDTO> userDTOList = new ArrayList<UserDTO>();
//		for (User user : userList) {
//			userDTOList.add(userAssembler.createDTO(user));
//		}
//		return userDTOList;
		return null;
	}

	public UserDTO createUser(UserDTO dto) {
//		User user = userAssembler.createEntity(dto);
//		user = userService.createUser(user);
//		dto = userAssembler.createDTO(user);
//		return dto;
		return null;
	}
}
