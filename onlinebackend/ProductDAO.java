package com.niit.onlinebackend.dao;

import java.util.List;

import com.niit.onlinebackend.model.*;

public interface ProductDAO 
{
	// get all categories -list
	public List<Product> list();

	// create category
	public boolean save(Product product);

	// update category
	public boolean update(Product product);

	// delete category
	public boolean delete(String id);

	// get category by id
	public Product getProductByID(String id);

	// get category by name
	public Product getProductByName(String name);

}
