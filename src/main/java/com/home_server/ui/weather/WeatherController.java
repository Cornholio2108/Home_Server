package com.home_server.ui.weather;

import java.io.IOException;
import java.io.Serializable;

import javax.annotation.PostConstruct;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.home_server.domain.weather.WeatherHandler;

@Component
@Scope("view")
public class WeatherController implements Serializable {
	private String testString = "";
	private String city = "Aschaffenburg", country = "Germany";

	@PostConstruct
	public void init() {
	}

	public void test() throws IOException {
		testString = new WeatherHandler().getWeatherDataForCity(city, country).toString();
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
