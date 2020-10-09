package com.home_server.rest.main;

import javax.faces.bean.ViewScoped;
import javax.inject.Named;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class MainController {
	
	@GetMapping("/main")
	public String redirectToMainPage(Model model) {            
	    return "forward:/login.xhtml";
	} 
}
