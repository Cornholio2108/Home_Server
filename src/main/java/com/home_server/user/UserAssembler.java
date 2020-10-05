package com.home_server.user;

import org.springframework.stereotype.Component;

@Component
public class UserAssembler {
	public UserDTO createDTO(User entity) {
		UserDTO dto = new UserDTO();
		dto.setId(entity.getId());
		dto.setUserName(entity.getUserName());
		dto.seteMail(entity.geteMail());
		dto.setFirstName(entity.getFirstName());
		dto.setLastName(entity.getLastName());
		return dto;
	}
}
