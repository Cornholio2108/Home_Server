package com.home_server.domain.ui.main;

import java.io.IOException;
import java.io.Serializable;

import javax.faces.context.FacesContext;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("view")
public class MainController implements Serializable {
	public void users() throws IOException {
		FacesContext fcontext = FacesContext.getCurrentInstance();
		fcontext.getExternalContext().redirect("/home/users.xhtml");
	}

	public void shoppingLists() throws IOException {
		FacesContext fcontext = FacesContext.getCurrentInstance();
		fcontext.getExternalContext().redirect("/shoppinglists.xhtml");
	}

	public void media() throws IOException {
		FacesContext fcontext = FacesContext.getCurrentInstance();
		fcontext.getExternalContext().redirect("/media.xhtml");
	}
}
