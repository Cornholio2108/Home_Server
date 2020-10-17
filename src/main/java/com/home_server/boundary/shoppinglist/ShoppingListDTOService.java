package com.home_server.boundary.shoppinglist;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.home_server.application.shoppinglist.ShoppingListService;
import com.home_server.domain.shoppinglist.ShoppingListItem;

@Component
public class ShoppingListDTOService {
	@Resource
	private ShoppingListService shoppingListService;
	@Resource
	private ShoppingListItemAssembler shoppingListItemAssembler;

	public List<ShoppingListItemDTO> getAllShoppingListItems() {
		List<ShoppingListItem> entityList = shoppingListService.getAllShoppingListItems();
		List<ShoppingListItemDTO> dtoList = shoppingListItemAssembler.createDTOList(entityList);
		return dtoList;
	}

	public ShoppingListItemDTO createShoppingListItem(ShoppingListItemDTO dto) {
		ShoppingListItem entity = shoppingListItemAssembler.createEntity(dto);
		entity = shoppingListService.createShoppingListItem(entity);
		dto = shoppingListItemAssembler.createDTO(entity);
		return dto;
	}
}
