package com.home_server.application.shoppinglist;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.home_server.domain.shoppinglist.ShoppingListItem;
import com.home_server.repositories.shoppinglist.ShoppingListRepository;

@Service
@Transactional
public class ShoppingListService {
	@Resource
	private ShoppingListRepository shoppingListRepository;

	@Transactional(readOnly = true)
	public List<ShoppingListItem> getAllShoppingListItems() {
		return (List<ShoppingListItem>) shoppingListRepository.findAll();
	}

	@Transactional(readOnly = false)
	public ShoppingListItem createShoppingListItem(ShoppingListItem entity) {
		entity = shoppingListRepository.save(entity);
		return entity;
	}
}
