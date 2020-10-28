package com.home_server.domain.settings;

import javax.inject.Singleton;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.home_server.domain.BaseEntity;

@Singleton
@Entity
@Table(name = "settings")
public class AppSettings extends BaseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "settings_id")
	private Long settingsID;
	@Embedded
	private WeatherSettings weatherSettings;

	public AppSettings() {
		super();
		weatherSettings=new WeatherSettings();
	}

	@Override
	public Long getId() {
		return settingsID;
	}

	public Long getSettingsID() {
		return settingsID;
	}

	public void setSettingsID(Long settingsID) {
		this.settingsID = settingsID;
	}

	public WeatherSettings getWeatherSettings() {
		return weatherSettings;
	}

	public void setWeatherSettings(WeatherSettings weatherSettings) {
		this.weatherSettings = weatherSettings;
	}

	@Override
	  public String toString() {
	    return "ID: "+settingsID+System.lineSeparator()+
	    		"weather city: "+weatherSettings.getCity()+System.lineSeparator()+
	    		"weather country: "+weatherSettings.getCountry()+System.lineSeparator()
	    		;
	  }
}
