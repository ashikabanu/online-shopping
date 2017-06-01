package com.niit.onlinebackend.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.onlinebackend.dao.OrderTableDAO;
import com.niit.onlinebackend.model.OrderTable;

@Repository("orderTableDAO")
@Transactional
public abstract class OrderTableDAOImpl implements OrderTableDAO{
	
	@Autowired
	private SessionFactory sessionFactory;

	public OrderTableDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


	public boolean save(OrderTable orderTable) {
		try {
			sessionFactory.getCurrentSession().save(orderTable);
		} catch (Exception e) {
			// if any exception comes during execute of try block, catch will
			// Execute
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	public List<OrderTable> list(String userId) {
		
		return  sessionFactory.getCurrentSession().createQuery("from OrderTable where user_id=?").setString(0, userId).list();

	}


	public boolean save(OrderTableDAO orderTable) {
		return false;
	}




}
