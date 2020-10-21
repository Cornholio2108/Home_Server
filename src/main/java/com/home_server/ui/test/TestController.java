package com.home_server.ui.test;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;

import org.primefaces.event.SelectEvent;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.home_server.boundary.shoppinglist.ShoppingListItemDTO;
import com.home_server.media.NASFile;
import com.home_server.media.NetworkFileHandler;

@Component
@Scope("view")
public class TestController implements Serializable {
	NetworkFileHandler networkFileHandler = new NetworkFileHandler();
	List<NASFile> fileList = new ArrayList<NASFile>();
	NASFile selectedFile = new NASFile();

	@PostConstruct
	public void init() {
		networkFileHandler = new NetworkFileHandler();
		fileList = (List<NASFile>) networkFileHandler.loadFiles("");
	}

	public void test() throws IOException {
//		FacesContext fcontext = FacesContext.getCurrentInstance();
//		fcontext.getExternalContext().redirect("/home/users.xhtml");
		fileList = networkFileHandler.loadFiles("");
	}

	public void onRowSelect(SelectEvent<NASFile> event) {
		fileList = networkFileHandler.loadFiles(selectedFile.getFileName()+"\\");
	}

	public List<NASFile> getFileList() {
		return fileList;
	}

	public void setFileList(List<NASFile> fileList) {
		this.fileList = fileList;
	}

	public NASFile getSelectedFile() {
		return selectedFile;
	}

	public void setSelectedFile(NASFile selectedFile) {
		this.selectedFile = selectedFile;
	}
}
