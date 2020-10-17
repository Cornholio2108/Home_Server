package com.home_server.boundary;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class BaseAssembler<E, D> {
	public abstract D createDTO(E entity);

	public abstract E createEntity(D dto);

	public List<D> createDTOList(List<E> entityList) {
		if (entityList == null) {
			return Collections.emptyList();
		}
		List<D> dtoList = new ArrayList<D>();
		entityList.forEach(e -> {
			dtoList.add(createDTO(e));
		});
		return dtoList;
	}

	public List<E> createEntityList(List<D> dtoList) {
		if (dtoList == null) {
			return Collections.emptyList();
		}
		List<E> entityList = new ArrayList<E>();
		dtoList.forEach(d -> {
			entityList.add(createEntity(d));
		});
		return entityList;
	}
}
