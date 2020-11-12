package com.home_server.ui.media;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.home_server.boundary.media.RadioStationDTO;
import com.home_server.boundary.media.RadioStationDTOService;
import com.home_server.pi.WebRadioPlayer;

@Component
@Scope("view")
public class RadioController implements Serializable {
	@Resource
	private RadioStationDTOService radioStationDTOService;

	private WebRadioPlayer webRadioPlayer;
	private List<RadioStationDTO> radioStationList = new ArrayList<>();
	private RadioStationDTO selectedRadioStation;

	@PostConstruct
	public void init() {
		webRadioPlayer = new WebRadioPlayer();
		radioStationList = radioStationDTOService.getAllRadioStations();
		if (radioStationList != null && radioStationList.size() > 0) {
			selectedRadioStation = radioStationList.get(radioStationList.size() - 1);
		}
	}

	public void play() {
		webRadioPlayer.setUrl(selectedRadioStation.getUrl());
		webRadioPlayer.start();
	}

	public void addRadioStation() {
		selectedRadioStation = new RadioStationDTO();
	}
	
	public void editRadioStation() {
		
	}

	public void saveRadioStation() {
		radioStationDTOService.createRadioStation(selectedRadioStation);
		radioStationList = radioStationDTOService.getAllRadioStations();
	}

	public WebRadioPlayer getWebRadioPlayer() {
		return webRadioPlayer;
	}

	public void setWebRadioPlayer(WebRadioPlayer webRadioPlayer) {
		this.webRadioPlayer = webRadioPlayer;
	}

	public List<RadioStationDTO> getRadioStationList() {
		return radioStationList;
	}

	public void setRadioStationList(List<RadioStationDTO> radioStationList) {
		this.radioStationList = radioStationList;
	}

	public RadioStationDTO getSelectedRadioStation() {
		return selectedRadioStation;
	}

	public void setSelectedRadioStation(RadioStationDTO selectedRadioStation) {
		this.selectedRadioStation = selectedRadioStation;
	}
}
