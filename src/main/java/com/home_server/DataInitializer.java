package com.home_server;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.home_server.application.settings.SettingsService;
import com.home_server.domain.settings.AppSettings;
import com.home_server.domain.settings.WeatherSettings;

@Component(value = "MyDataInitializer")
public class DataInitializer implements ApplicationListener<ContextRefreshedEvent> {

	private static final Logger logger = LoggerFactory.getLogger(DataInitializer.class);

	@Resource
	private SettingsService settingsService;

	@Value("${Application.name}")
	private String applicationName;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {

		logger.info("Checking application initial data...");

		Globals.appSettings = settingsService.getSettings();
		if (Globals.appSettings == null) {
			Globals.appSettings = new AppSettings();
			Globals.appSettings.setWeatherSettings(new WeatherSettings("Aschaffenburg","Germany"));
			Globals.appSettings = settingsService.saveSettings(Globals.appSettings);
		}
	}
}
