package com.home_server.ui.shoppinglist;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.primefaces.event.CellEditEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.home_server.boundary.shoppinglist.ShoppingListDTOService;
import com.home_server.boundary.shoppinglist.ShoppingListItemDTO;

@Component
@Scope("view")
public class ShoppingListItemController implements Serializable {
	@Resource
	private ShoppingListDTOService shoppingListDTOService;
	@Resource
	private ShoppingListController shoppingListController;

	private static final long serialVersionUID = 1L;

	private ShoppingListItemDTO selectedShoppingListItem;

	@PostConstruct
	public void init() {
	}

	public ShoppingListItemDTO getSelectedShoppingListItem() {
		return selectedShoppingListItem;
	}

	public void setSelectedShoppingListItem(ShoppingListItemDTO selectedShoppingListItem) {
		this.selectedShoppingListItem = selectedShoppingListItem;
	}

	public void onCellEdit(CellEditEvent event) {
		Object oldValue = event.getOldValue();
		Object newValue = event.getNewValue();
		int rowIndex = event.getRowIndex();
		selectedShoppingListItem = shoppingListController.getSelectedShoppingList().get(rowIndex);

		selectedShoppingListItem = shoppingListDTOService.createShoppingListItem(selectedShoppingListItem);

		if (newValue != null && !newValue.equals(oldValue)) {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Wert geändert",
					"Alt: " + oldValue + ", Neu:" + newValue);
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
	}

	public void onRowSelect(SelectEvent<ShoppingListItemDTO> event) {
		selectedShoppingListItem = event.getObject();
	}

	public void onRowUnselect(UnselectEvent<ShoppingListItemDTO> event) {
		selectedShoppingListItem = null;
	}
}
