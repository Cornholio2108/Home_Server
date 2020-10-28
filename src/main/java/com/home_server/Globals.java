package com.home_server;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.home_server.domain.settings.AppSettings;

public final class Globals {
	public static final String OPEN_WEATHER_URL = "http://api.openweathermap.org/data/2.5/forecast";
	public static AppSettings appSettings;
}
