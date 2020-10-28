package com.home_server.ui.settings;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.home_server.Globals;
import com.home_server.application.settings.SettingsService;
import com.home_server.domain.settings.AppSettings;
import com.home_server.media.NASFile;
import com.home_server.media.NetworkFileHandler;

@Component
@Scope("view")
public class SettingsController implements Serializable {
	private AppSettings appSettings;
	@Resource
	private SettingsService settingsService;

	@PostConstruct
	public void init() {
		appSettings = Globals.appSettings;
	}

	public void save() {
		System.out.println("before Save: " + Globals.appSettings.toString());

		Globals.appSettings=appSettings;
		Globals.appSettings = settingsService.saveSettings(Globals.appSettings);

		System.out.println("after Save: " + Globals.appSettings.toString());
	}
	
	public AppSettings getAppSettings() {
		return appSettings;
	}

	public void setAppSettings(AppSettings appSettings) {
		this.appSettings = appSettings;
	}

}
