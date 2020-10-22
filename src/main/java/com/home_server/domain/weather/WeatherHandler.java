package com.home_server.domain.weather;

import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.home_server.Constants;
import com.home_server.Globals;

public class WeatherHandler {
	public WeatherData getWeatherDataForCity(String city, String country) {
		RestTemplate restTemplate = new RestTemplate();

		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(Globals.OPEN_WEATHER_URL)
				.queryParam("q", city + "," + country).queryParam("units", "metric").queryParam("lang", "de")
				.queryParam("APPID", Constants.OPEN_WEATHER_API_KEY);

		return restTemplate.getForObject(builder.toUriString(), WeatherData.class);
	}
}
