package com.home_server.repositories.shoppinglist;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.home_server.domain.shoppinglist.ShoppingListItem;

@Repository
public interface ShoppingListRepository extends CrudRepository<ShoppingListItem, Long> {

}
