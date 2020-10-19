package com.home_server.boundary.shoppinglist;

import org.springframework.stereotype.Component;

import com.home_server.boundary.BaseAssembler;
import com.home_server.domain.shoppinglist.ShoppingListItem;

@Component
public class ShoppingListItemAssembler extends BaseAssembler<ShoppingListItem, ShoppingListItemDTO> {

	@Override
	public ShoppingListItemDTO createDTO(ShoppingListItem entity) {
		ShoppingListItemDTO dto = new ShoppingListItemDTO();
		dto.setItemID(entity.getItemID());
		dto.setTitle(entity.getTitle());
		dto.setDescription(entity.getDescription());
		dto.setQuantity(entity.getQuantity());
		dto.setPrice(entity.getPrice());
		dto.setScanNumber(entity.getScanNumber());
		dto.setShop(entity.getShop());
		dto.setCreationDate(entity.getCreationDate());
		dto.setModificationDate(entity.getModificationDate());
		dto.setCompleted(entity.isCompleted());
		return dto;
	}

	@Override
	public ShoppingListItem createEntity(ShoppingListItemDTO dto) {
		ShoppingListItem entity = new ShoppingListItem();
		entity.setItemID(dto.getItemID());
		entity.setTitle(dto.getTitle());
		entity.setDescription(dto.getDescription());
		entity.setQuantity(dto.getQuantity());
		entity.setPrice(dto.getPrice());
		entity.setScanNumber(dto.getScanNumber());
		entity.setShop(dto.getShop());
		entity.setCreationDate(dto.getCreationDate());
		entity.setModificationDate(dto.getModificationDate());
		entity.setCompleted(dto.isCompleted());
		return entity;
	}
}
