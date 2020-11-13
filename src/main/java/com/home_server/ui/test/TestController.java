package com.home_server.ui.test;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.home_server.Globals;
import com.home_server.application.settings.SettingsService;
import com.home_server.pi.TerminalCommand;

@Component
@Scope("view")
public class TestController implements Serializable {
	private String testString1, testString2, testString3, testString4, testString5;

	@PostConstruct
	public void init() {
	}

	@Resource
	private SettingsService settingsService;

	public void test() {
		System.out.println("Start Test Click: " + testString1 + "; " + testString2 + "; " + testString3 + "; "
				+ testString4 + "; " + testString5);
		List<String> cmdList = new ArrayList<String>();
		if (testString1 != null)
			cmdList.add(testString1);
		if (testString2 != null)
			cmdList.add(testString2);
		if (testString3 != null)
			cmdList.add(testString3);
		if (testString4 != null)
			cmdList.add(testString4);
		if (testString5 != null)
			cmdList.add(testString5);
		new TerminalCommand().runCmdOnThread(cmdList.toArray(new String[0]));
		// bash -c 'mplayer -noconsolecontrols -really-quiet -playlist
		// http://streams.ffh.de/radioffh/mp3/hqlivestream.m3u </dev/null >/dev/null 2>&1 & disown'
		System.out.println("End Test Click ");
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

	public String getTestString1() {
		return testString1;
	}

	public void setTestString1(String testString1) {
		this.testString1 = testString1;
	}

	public String getTestString2() {
		return testString2;
	}

	public void setTestString2(String testString2) {
		this.testString2 = testString2;
	}

	public String getTestString3() {
		return testString3;
	}

	public void setTestString3(String testString3) {
		this.testString3 = testString3;
	}

	public String getTestString4() {
		return testString4;
	}

	public void setTestString4(String testString4) {
		this.testString4 = testString4;
	}

	public String getTestString5() {
		return testString5;
	}

	public void setTestString5(String testString5) {
		this.testString5 = testString5;
	}

}
