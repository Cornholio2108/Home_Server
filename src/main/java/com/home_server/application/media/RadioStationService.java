package com.home_server.application.media;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.home_server.domain.media.RadioStation;
import com.home_server.repositories.media.RadioStationRepository;

@Service
@Transactional
public class RadioStationService {
	@Resource
	private RadioStationRepository radioStationRepository;

	public List<RadioStation> getAllRadioStations() {
		return (List<RadioStation>) radioStationRepository.findAll();
	}

	@Transactional(readOnly = false)
	public RadioStation createRadioStation(RadioStation entity) {
		entity = radioStationRepository.save(entity);
		return entity;
	}

	public RadioStation getRadioStationByID(Long itemID) {
		return radioStationRepository.findById(itemID).orElse(null);
	}
}
