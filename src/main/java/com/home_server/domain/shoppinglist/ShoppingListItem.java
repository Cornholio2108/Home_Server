package com.home_server.domain.shoppinglist;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.home_server.domain.BaseEntity;

@Entity
@Table(name = "shoppinglist_item")
public class ShoppingListItem extends BaseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "item_id")
	private Long itemID;
	@Column(name = "title")
	private String title;
	@Column(name = "description")
	private String description;
	@Column(name = "quantity")
	private int quantity;
	@Column(name = "price")
	private BigDecimal price;
	@Column(name = "completed")
	private boolean completed;
	@Column(name = "scan_number")
	private String scanNumber;
	@Column(name = "shop")
	private String shop;

	public Long getItemID() {
		return itemID;
	}

	public void setItemID(Long itemID) {
		this.itemID = itemID;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public boolean isCompleted() {
		return completed;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
	}

	public String getScanNumber() {
		return scanNumber;
	}

	public void setScanNumber(String scanNumber) {
		this.scanNumber = scanNumber;
	}

	public String getShop() {
		return shop;
	}

	public void setShop(String shop) {
		this.shop = shop;
	}

	@Override
	public Long getId() {
		return itemID;
	}

}
