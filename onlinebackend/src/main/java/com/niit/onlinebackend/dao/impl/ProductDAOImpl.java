package com.niit.onlinebackend.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.onlinebackend.dao.ProductDAO;
import com.niit.onlinebackend.model.*;

@Repository("productDAO")
@Transactional

public  class ProductDAOImpl implements ProductDAO {

	@Autowired
	private SessionFactory sessionFactory;
	public ProductDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	@SuppressWarnings("unchecked")
	public List<Product> list() 
	{
		return sessionFactory.getCurrentSession().createQuery("from category").list();
	}
	public boolean save(Product product) 
	{
		try
		{
			sessionFactory.getCurrentSession().save(product);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
		return true;
	
	}
	public boolean update(Product product) 
	{
		try
		{
			sessionFactory.getCurrentSession().update(product);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
		return true;
	}
	public boolean delete(String id) 
	{
		try
		{
			sessionFactory.getCurrentSession().delete(getProductByID(id));
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
		return true;
	}
	public Product getProductByID(String id) 
	{
		return (Product) sessionFactory.getCurrentSession().get(Product.class, id);
	}
	
	@Override
	public List<Category> getAllProductsByCategoryID(String id) {
		return (List<Category>) sessionFactory.getCurrentSession().createQuery("from product where id=?").setString(0,id).uniqueResult();

	}
	@Override
	public Product getProductByName(String name) { 
		
		return  (Product) sessionFactory.getCurrentSession().createQuery("from product where name=?").setString(0,name).uniqueResult();

	}
	@Override
	public Product get(String id) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
