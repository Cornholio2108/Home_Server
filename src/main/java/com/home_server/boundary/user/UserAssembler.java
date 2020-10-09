package com.home_server.boundary.user;

import org.springframework.stereotype.Component;

import com.home_server.domain.user.User;

@Component
public class UserAssembler {
	public UserDTO createDTO(User entity) {
		UserDTO dto = new UserDTO();
		dto.setId(entity.getId());
		dto.setUserName(entity.getUserName());
		dto.seteMail(entity.geteMail());
		dto.setFirstName(entity.getFirstName());
		dto.setLastName(entity.getLastName());
		dto.setPassword(entity.getPassword());
		return dto;
	}

	public User createEntity(UserDTO dto) {
		User entity = new User();
		entity.setId(dto.getId());
		entity.setUserName(dto.getUserName());
		entity.seteMail(dto.geteMail());
		entity.setFirstName(dto.getFirstName());
		entity.setLastName(dto.getLastName());
		entity.setPassword(dto.getPassword());
		return entity;
	}
}
