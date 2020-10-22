package com.home_server.domain.weather;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherData {
	public List<WeatherItem> list = null;
	public String cod;
	public int message;
	public int cnt;
	public City city;
	
	public static class City {
		public long id;
		public String name;
		public Coord coord;
		public String country;
		public int population;
		public int timezone;
		public Date sunrise;
		public Date sunset;
	}
	
	public static class Coord {
		public double lat;
		public double lon;
	}
	
	public static class WeatherItem {
		public Main main;
		public List<Weather> weather = null;
		public String dt;
		public String dt_txt;
	}

	public static class Main {
		public double temp;
		public String humidity;
		public String pressure;
		public double temp_min;
		public double temp_max;
	}

	public static class Weather {
		public String id;
		public String main;
		public String description;
		public String icon;
	}
	
	 @Override
	  public String toString() {
	    return cod+" "+message+" "+cnt+" "+city.name+" "+city.country;
	  }
}
