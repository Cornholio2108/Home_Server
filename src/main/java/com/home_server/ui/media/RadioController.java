package com.home_server.ui.media;

import java.io.Serializable;

import javax.annotation.PostConstruct;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.home_server.pi.WebRadioPlayer;

@Component
@Scope("view")
public class RadioController implements Serializable {
	private WebRadioPlayer webRadioPlayer;
	private String radioURL = "";

	@PostConstruct
	public void init() {
		webRadioPlayer = new WebRadioPlayer();
	}

	public void play() {
		webRadioPlayer.setUrl(radioURL);
		webRadioPlayer.start();
	}

	public WebRadioPlayer getWebRadioPlayer() {
		return webRadioPlayer;
	}

	public void setWebRadioPlayer(WebRadioPlayer webRadioPlayer) {
		this.webRadioPlayer = webRadioPlayer;
	}

	public String getRadioURL() {
		return radioURL;
	}

	public void setRadioURL(String radioURL) {
		this.radioURL = radioURL;
	}
}
