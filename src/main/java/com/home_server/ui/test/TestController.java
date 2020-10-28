package com.home_server.ui.test;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.primefaces.event.SelectEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.home_server.Globals;
import com.home_server.SettingsConfig;
import com.home_server.application.settings.SettingsService;
import com.home_server.domain.weather.WeatherData;
import com.home_server.domain.weather.WeatherHandler;
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

	private SettingsConfig app;

	@Autowired
	public void setApp(SettingsConfig app) {
		this.app = app;
	}

	@Resource
	private SettingsService settingsService;

	public void test() throws IOException {
//		FacesContext fcontext = FacesContext.getCurrentInstance();
//		fcontext.getExternalContext().redirect("/home/users.xhtml");
//		fileList = networkFileHandler.loadFiles("");

//		testString = new WeatherHandler().getWeatherDataForCity(city, country).toString();

//		app.setWeatherCity("Frankfurt");
//		testString = app.getWeatherCity();

		System.out.println("onClick: " + Globals.appSettings.getWeatherSettings().getCity() + " "
				+ Globals.appSettings.getWeatherSettings().getCountry());

		Globals.appSettings.getWeatherSettings().setCity("");
		Globals.appSettings.getWeatherSettings().setCountry("");
		Globals.appSettings = settingsService.saveSettings(Globals.appSettings);

		System.out.println("onComplete: " + Globals.appSettings.getWeatherSettings().getCity() + " "
				+ Globals.appSettings.getWeatherSettings().getCountry());
	}

	public void onRowSelect(SelectEvent<NASFile> event) {
		fileList = networkFileHandler.loadFiles(selectedFile.getFileName() + "\\");
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
