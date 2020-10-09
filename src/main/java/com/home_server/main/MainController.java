package com.home_server.main;

import javax.faces.bean.ViewScoped;
import javax.inject.Named;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class MainController {
	
	public String index(Model model) {            
	    return "redirect: login.xhtml";
	} 
}
