package com.niit.onlinebackend.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import com.niit.onlinebackend.model.MyCart;

@SuppressWarnings("deprecation")
public class CartDAOImpl {

	@Autowired SessionFactory sessionFactory;
	
	public CartDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
	}

	public boolean save(MyCart cart) {
		try {
			sessionFactory.getCurrentSession().save(cart);
		} catch (HibernateException e) {
		
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean update(MyCart cart) {
		try {
			sessionFactory.getCurrentSession().update(cart);
		} catch (HibernateException e) {
		
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public List<MyCart> list(String userID) {
		Query qiery =  sessionFactory.getCurrentSession().createQuery(" from Cart where userID = ?");
		qiery.setString(0, userID);
		
		return qiery.list();
		
	}

	public double getTotalAmount(String userID) {
		Query qiery =  sessionFactory.getCurrentSession().createQuery(" select sum(price) from Cart where userID = ?");
		
	 return	(Double) qiery.uniqueResult();
		
	
		
	}
	
}
