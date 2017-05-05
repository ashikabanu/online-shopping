package com.niit.onlinebackend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "Product")
@Component

public class Product {
	@Id
	private String id;
	@Column(name = "name")
	private String name;
	private String description;
	private String Category_ID;
	private String Supplier_ID;
	private String Price;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCategory_ID() {
		return Category_ID;
	}

	public void setCategory_ID(String category_ID) {
		Category_ID = category_ID;
	}

	public String getSupplier_ID() {
		return Supplier_ID;
	}

	public void setSupplier_ID(String supplier_ID) {
		Supplier_ID = supplier_ID;
	}

	public String getPrice() {
		return Price;
	}

	public void setPrice(String price) {
		Price = price;
	}

}
