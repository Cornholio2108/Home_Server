package com.home_server.ui.media;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.primefaces.event.SelectEvent;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.home_server.boundary.media.RadioStationDTO;
import com.home_server.boundary.media.RadioStationDTOService;
import com.home_server.boundary.shoppinglist.ShoppingListItemDTO;
import com.home_server.pi.WebRadioPlayer;

@Component
@Scope("view")
public class RadioController implements Serializable {
	@Resource
	private RadioStationDTOService radioStationDTOService;

	private WebRadioPlayer webRadioPlayer;
	private List<RadioStationDTO> radioStationList = new ArrayList<>();
	private RadioStationDTO selectedRadioStation;
	private int volume;
	private boolean repeat = false;

	@PostConstruct
	public void init() {
		webRadioPlayer = new WebRadioPlayer();
		radioStationList = radioStationDTOService.getAllRadioStations();
		if (radioStationList != null && radioStationList.size() > 0) {
			selectedRadioStation = radioStationList.get(0);
		}
	}

	public void onRadioStationChange() {
		System.out.println("Radio selected: " + selectedRadioStation.getName());
	}

	public void play() {
		if (selectedRadioStation != null) {
			if (selectedRadioStation.getUrl().contains("home/pi")) {
				webRadioPlayer.startFile(selectedRadioStation.getUrl(), repeat);
			} else {
				webRadioPlayer.startStream(selectedRadioStation.getUrl());
			}
		}
	}

	public void stop() {
		webRadioPlayer.stop();
	}

	public void setVolume() {
		webRadioPlayer.setVolume(volume);
	}

	public void toggleMute() {
		webRadioPlayer.toggleMute();
	}

	public void addRadioStation() {
		selectedRadioStation = new RadioStationDTO();
	}

	public void editRadioStation() {
		System.out.println("Radio edit: " + selectedRadioStation.getName());
	}

	public void saveRadioStation() {
		radioStationDTOService.createRadioStation(selectedRadioStation);
		radioStationList = radioStationDTOService.getAllRadioStations();
	}
	
	public void onRowSelect(SelectEvent<RadioStationDTO> event) {
		selectedRadioStation = event.getObject();
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

	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}

	public boolean isRepeat() {
		return repeat;
	}

	public void setRepeat(boolean repeat) {
		this.repeat = repeat;
	}

}
