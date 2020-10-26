package com.home_server;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:settings.properties")
@ConfigurationProperties(prefix = "settings")
public class SettingsConfig {
//	@Value("${weather_city}")
	private String weatherCity;
//	@Value("${weather_country}")
	private String weatherCountry;
	public String getWeatherCity() {
		return weatherCity;
	}
	public void setWeatherCity(String weatherCity) {
		this.weatherCity = weatherCity;
	}
	public String getWeatherCountry() {
		return weatherCountry;
	}
	public void setWeatherCountry(String weatherCountry) {
		this.weatherCountry = weatherCountry;
	}
	
	
}
