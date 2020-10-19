package com.home_server.ui.main;

import java.io.IOException;
import java.io.Serializable;

import javax.faces.context.FacesContext;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("view")
public class MainController implements Serializable {
	public void test() throws IOException {
		FacesContext fcontext = FacesContext.getCurrentInstance();
		fcontext.getExternalContext().redirect("/home/users.xhtml");
	}
}
