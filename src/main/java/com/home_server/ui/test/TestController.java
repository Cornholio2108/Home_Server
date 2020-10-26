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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.home_server.SettingsConfig;
import com.home_server.boundary.shoppinglist.ShoppingListItemDTO;
import com.home_server.domain.weather.WeatherHandler;
import com.home_server.media.NASFile;
import com.home_server.media.NetworkFileHandler;

@Component
@Scope("view")
public class TestController implements Serializable {
	NetworkFileHandler networkFileHandler = new NetworkFileHandler();
	List<NASFile> fileList = new ArrayList<NASFile>();
	NASFile selectedFile = new NASFile();
	private String testString = "";
	private String city = "Aschaffenburg", country = "Germany";

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

	public void test() throws IOException {
//		FacesContext fcontext = FacesContext.getCurrentInstance();
//		fcontext.getExternalContext().redirect("/home/users.xhtml");
//		fileList = networkFileHandler.loadFiles("");

//		testString = new WeatherHandler().getWeatherDataForCity(city, country).toString();

		System.out.println(app.getWeatherCity());

		app.setWeatherCity("Frankfurt");

		testString = app.getWeatherCity();
		System.out.println(app.getWeatherCity());
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

	public String getTestString() {
		return testString;
	}

	public void setTestString(String testString) {
		this.testString = testString;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

}