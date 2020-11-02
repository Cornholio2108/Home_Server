package com.home_server.ui.shoppinglist;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.home_server.boundary.shoppinglist.ShoppingListDTOService;
import com.home_server.boundary.shoppinglist.ShoppingListItemDTO;

@Component
@Scope("view")
public class ShoppingListController implements Serializable {
	@Resource
	private ShoppingListDTOService shoppingListDTOService;

	private static final long serialVersionUID = 1L;
	private List<ShoppingListItemDTO> selectedShoppingList = new ArrayList<ShoppingListItemDTO>();

	@PostConstruct
	public void init() {
		selectedShoppingList = shoppingListDTOService.getAllShoppingListItems();
//		ShoppingListItemDTO newShoppingListItem = new ShoppingListItemDTO();
//		newShoppingListItem.setItemID(999L);
//		newShoppingListItem.setTitle("Neu");
//		selectedShoppingList.add(new ShoppingListItemDTO());
	}

	public List<ShoppingListItemDTO> getSelectedShoppingList() {
		return selectedShoppingList;
	}

	public void setSelectedShoppingList(List<ShoppingListItemDTO> selectedShoppingList) {
		this.selectedShoppingList = selectedShoppingList;
	}
}
