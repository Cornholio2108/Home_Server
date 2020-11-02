package com.home_server.rest.shoppinglist;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.home_server.boundary.shoppinglist.ShoppingListDTOService;
import com.home_server.boundary.shoppinglist.ShoppingListItemDTO;

@RestController
public class ShoppingListRestController {
	@Resource
	private ShoppingListDTOService shoppingListDTOService;

	@GetMapping("/rest/shoppinglist")
	public ShoppingListItemDTO getShoppingListItem(@RequestParam(value = "id", defaultValue = "1") Long itemID) {
		ShoppingListItemDTO shoppingListItemDTO = shoppingListDTOService.getShoppingListItemByID(itemID);
		return shoppingListItemDTO;
	}

	@GetMapping("/rest/shoppinglists")
	public List<ShoppingListItemDTO> getShoppingListItems() {
		List<ShoppingListItemDTO> shoppingListItems = shoppingListDTOService.getAllShoppingListItems();
		return shoppingListItems;
	}
}
