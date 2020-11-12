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
import com.home_server.application.settings.SettingsService;
import com.home_server.media.NASFile;
import com.home_server.media.NetworkFileHandler;
import com.home_server.pi.WebRadioPlayer;

@Component
@Scope("view")
public class TestController implements Serializable {
	private String testString = "";

	@PostConstruct
	public void init() {
	}

	@Resource
	private SettingsService settingsService;

	public void test() {
		System.out.println("Start Test Click: " + testString);
		WebRadioPlayer webRadioPlayer = new WebRadioPlayer();
		webRadioPlayer.startTest(testString);
		System.out.println("End Test Click: " + testString);
	}

	public void test2() throws IOException {
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

	public String getTestString() {
		return testString;
	}

	public void setTestString(String testString) {
		this.testString = testString;
	}

}
