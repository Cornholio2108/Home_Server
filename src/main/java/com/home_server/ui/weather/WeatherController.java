package com.home_server.ui.weather;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;

import org.primefaces.PrimeFaces;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.home_server.Globals;
import com.home_server.domain.weather.WeatherData;
import com.home_server.domain.weather.WeatherHandler;
import com.home_server.media.NASFile;
import com.home_server.media.NetworkFileHandler;

@Component
@Scope("view")
public class WeatherController implements Serializable {
	private String weatherOutput = "", image = "";
	private String city = "Aschaffenburg", country = "Germany";

	@PostConstruct
	public void init() throws IOException {
		city = Globals.appSettings.getWeatherSettings().getCity();
		country = Globals.appSettings.getWeatherSettings().getCountry();
		getWeather();
	}

	public void getWeather() throws IOException {
		WeatherData weatherData = new WeatherHandler().getWeatherDataForCity(
				Globals.appSettings.getWeatherSettings().getCity(),
				Globals.appSettings.getWeatherSettings().getCountry());

		if (weatherData.list.size() > 0) {
			weatherOutput = weatherData.list.get(0).main.temp + "°C " + weatherData.list.get(0).weather.get(0).description;
			image=weatherData.list.get(0).weather.get(0).icon+".png";
			// "https://openweathermap.org/img/w/" + image+".png"
		}
		
		PrimeFaces.current().ajax().update("@widgetVar(imagePanel)");
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

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getWeatherOutput() {
		return weatherOutput;
	}

	public void setWeatherOutput(String weatherOutput) {
		this.weatherOutput = weatherOutput;
	}
}
