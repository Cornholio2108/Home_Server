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
	private String weatherOutput = "", weatherOutput2h = "", weatherOutput4h = "", image = "", image2h = "",
			image4h = "";
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
			weatherOutput = weatherData.list.get(0).main.temp + "°C "
					+ weatherData.list.get(0).weather.get(0).description;
			image = weatherData.list.get(0).weather.get(0).icon + ".png";
			// "https://openweathermap.org/img/w/" + image+".png"
		}
		if (weatherData.list.size() > 2) {
			weatherOutput2h = weatherData.list.get(2).main.temp + "°C "
					+ weatherData.list.get(2).weather.get(0).description;
			image2h = weatherData.list.get(2).weather.get(0).icon + ".png";
		}
		if (weatherData.list.size() > 4) {
			weatherOutput4h = weatherData.list.get(2).main.temp + "°C "
					+ weatherData.list.get(4).weather.get(0).description;
			image4h = weatherData.list.get(4).weather.get(0).icon + ".png";
		}

		PrimeFaces.current().ajax().update("mainForm:weatherPanel");
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

	public String getWeatherOutput2h() {
		return weatherOutput2h;
	}

	public void setWeatherOutput2h(String weatherOutput2h) {
		this.weatherOutput2h = weatherOutput2h;
	}

	public String getWeatherOutput4h() {
		return weatherOutput4h;
	}

	public void setWeatherOutput4h(String weatherOutput4h) {
		this.weatherOutput4h = weatherOutput4h;
	}

	public String getImage2h() {
		return image2h;
	}

	public void setImage2h(String image2h) {
		this.image2h = image2h;
	}

	public String getImage4h() {
		return image4h;
	}

	public void setImage4h(String image4h) {
		this.image4h = image4h;
	}
}
