package com.home_server.boundary.media;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.home_server.application.media.RadioStationService;
import com.home_server.domain.media.RadioStation;

@Component
public class RadioStationDTOService {
	@Resource
	private RadioStationService radioStationService;
	@Resource
	private RadioStationAssembler radioStationAssembler;

	public List<RadioStationDTO> getAllRadioStations() {
		List<RadioStation> entityList = radioStationService.getAllRadioStations();
		List<RadioStationDTO> dtoList = radioStationAssembler.createDTOList(entityList);
		return dtoList;
	}

	public RadioStationDTO getRadioStationByID(Long itemID) {
		RadioStation entity = radioStationService.getRadioStationByID(itemID);
		RadioStationDTO dto = radioStationAssembler.createDTO(entity);
		return dto;
	}

	public RadioStationDTO createRadioStation(RadioStationDTO dto) {
		RadioStation entity = radioStationAssembler.createEntity(dto);
		entity = radioStationService.createRadioStation(entity);
		dto = radioStationAssembler.createDTO(entity);
		return dto;
	}
}
