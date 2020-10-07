package com.home_server.user;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.context.RequestContext;

@Named
@ViewScoped
public class UserController implements Serializable {
	@Inject
	private UserDTOService userDTOService;

	private static final long serialVersionUID = 1L;

	private List<UserDTO> users;
	private String loginUsername = "HansWurst";
	private String loginPassword = "123Test";
	private UserDTO loggedInUser = new UserDTO();

	@PostConstruct
	public void init() {
		users = userDTOService.findAllUsers();
	}

	public List<UserDTO> getUsers() {
		return users;
	}

	public String getLoginUsername() {
		return loginUsername;
	}

	public void setLoginUsername(String loginUsername) {
		this.loginUsername = loginUsername;
	}

	public String getLoginPassword() {
		return loginPassword;
	}

	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}

	public void login() throws IOException {
		loggedInUser = users.stream().filter(u -> u.getUserName().equals(loginUsername)).findFirst().orElse(null);
		if (loggedInUser != null) {
			if (loggedInUser.getPassword().equals(loginPassword)) {
				showSuccessDialog();
			} else {
				showSignInDialog();
			}
		} else {
			loggedInUser = new UserDTO();
			showSignInDialog();
		}
	}

	public void signIn() {
		loggedInUser = userDTOService.createUser(loggedInUser);
	}

	public void showSuccessDialog() throws IOException {
		RequestContext context = RequestContext.getCurrentInstance();
		context.execute("PF('greetingDialog').show();");
		FacesContext fcontext = FacesContext.getCurrentInstance();
		fcontext.getExternalContext().redirect("/users.xhtml");
		fcontext.getExternalContext().getFlash().setKeepMessages(true);
	}

	public void showSignInDialog() throws IOException {
		RequestContext context = RequestContext.getCurrentInstance();
		context.execute("PF('signInDialog').show();");
//		FacesContext fcontext = FacesContext.getCurrentInstance();
//		fcontext.getExternalContext().redirect("/users.xhtml");
//		fcontext.getExternalContext().getFlash().setKeepMessages(true);
	}

	public UserDTO getLoggedInUser() {
		return loggedInUser;
	}

	public void setLoggedInUser(UserDTO loggedInUser) {
		this.loggedInUser = loggedInUser;
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
