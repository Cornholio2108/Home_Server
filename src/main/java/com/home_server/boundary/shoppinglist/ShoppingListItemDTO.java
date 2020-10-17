package com.home_server.boundary.shoppinglist;

import java.math.BigDecimal;
import java.util.Date;

public class ShoppingListItemDTO {
	private Long itemID;
	private Long shoppinglistID;
	private String title;
	private String description;
	private String scanNumber;
	private String shop;
	private int quantity;
	private Date creationDate;
	private Date modificationDate;
	private BigDecimal price;
	private boolean completed;

	public Long getItemID() {
		return itemID;
	}

	public void setItemID(Long itemID) {
		this.itemID = itemID;
	}

	public Long getShoppinglistID() {
		return shoppinglistID;
	}

	public void setShoppinglistID(Long shoppinglistID) {
		this.shoppinglistID = shoppinglistID;
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

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Date getModificationDate() {
		return modificationDate;
	}

	public void setModificationDate(Date modificationDate) {
		this.modificationDate = modificationDate;
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
}
