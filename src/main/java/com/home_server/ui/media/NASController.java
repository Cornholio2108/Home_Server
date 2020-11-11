package com.home_server.ui.media;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.primefaces.event.SelectEvent;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.home_server.Globals;
import com.home_server.application.settings.SettingsService;
import com.home_server.media.NASFile;
import com.home_server.media.NetworkFileHandler;
import com.home_server.pi.WebRadioPlayer;

@Component
@Scope("view")
public class NASController implements Serializable {
	NetworkFileHandler networkFileHandler = new NetworkFileHandler();
	List<NASFile> fileList = new ArrayList<NASFile>();
	NASFile selectedFile = new NASFile();
	
	@Resource
	private SettingsService settingsService;

	@PostConstruct
	public void init() {
		networkFileHandler = new NetworkFileHandler();
		fileList = (List<NASFile>) networkFileHandler.loadFiles("");
	}
	
	public void onRowSelect(SelectEvent<NASFile> event) {
		fileList = networkFileHandler.loadFiles(selectedFile.getFileName() + "\\");
	}

	public NetworkFileHandler getNetworkFileHandler() {
		return networkFileHandler;
	}

	public void setNetworkFileHandler(NetworkFileHandler networkFileHandler) {
		this.networkFileHandler = networkFileHandler;
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
