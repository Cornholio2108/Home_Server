package com.home_server.boundary.media;

import org.springframework.stereotype.Component;

import com.home_server.boundary.BaseAssembler;
import com.home_server.domain.media.RadioStation;

@Component
public class RadioStationAssembler extends BaseAssembler<RadioStation, RadioStationDTO> {

	@Override
	public RadioStationDTO createDTO(RadioStation entity) {
		RadioStationDTO dto = new RadioStationDTO();
		dto.setId(entity.getId());
		dto.setName(entity.getName());
		dto.setUrl(entity.getUrl());
		return dto;
	}

	@Override
	public RadioStation createEntity(RadioStationDTO dto) {
		RadioStation entity = new RadioStation();
		entity.setId(dto.getId());
		entity.setName(dto.getName());
		entity.setUrl(dto.getUrl());
		return entity;
	}
}
