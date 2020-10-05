package com.home_server.user;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

@Named
@ViewScoped
public class UserController implements Serializable {
	@Inject
	private UserDTOService userDTOService;
	
	private static final long serialVersionUID = 1L;

	private List<UserDTO> users;

	@PostConstruct
	public void init() {
		users = userDTOService.findAllUsers();
	}

	public List<UserDTO> getUsers() {
		return users;
	}

//	@Autowired
//	private UserRepository userRepository;
//
//	private List<User> users;
//
//	@PostConstruct
//	public void init() {
//		users = (List<User>) userRepository.findAll();
//	}
//
//	public List<User> getUsers() {
//		return users;
//	}
}
