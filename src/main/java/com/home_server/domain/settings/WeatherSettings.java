package com.home_server.domain.settings;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class WeatherSettings {
	@Column(name = "weather_city")
	private String city;
	@Column(name = "weather_country")
	private String country;

	public WeatherSettings() {
		super();
	}

	public WeatherSettings(String city, String country) {
		super();
		this.city = city;
		this.country = country;
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
