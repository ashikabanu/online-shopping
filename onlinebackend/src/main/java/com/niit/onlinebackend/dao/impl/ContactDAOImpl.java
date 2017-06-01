package com.niit.onlinebackend.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.onlinebackend.dao.CartDAO;
import com.niit.onlinebackend.dao.ContactDAO;
import com.niit.onlinebackend.model.Contact;
import com.niit.onlinebackend.model.MyCart;

//Note : we will get errors  - will solve tomorrow

@Repository("contactDAO")
@Transactional
public  class ContactDAOImpl implements CartDAO {
	
	//Transaction tx;
	@Autowired
	private SessionFactory sessionFactory;
	
	
	//write user defined constructor with one parameter i.e., sessionFactory
	
	public ContactDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
	}


	public boolean save(ContactDAO contact) {
		try
		{
		sessionFactory.getCurrentSession().save(contact);
		//tx = sessionFactory.getCurrentSession().getTransaction();
		}catch (Exception e) {
			//if any exception comes during execute of try block, catch will excute
			e.printStackTrace();
			return false;
		}
		return true;
	}


	public boolean delete(int id) {
		try
		{
		sessionFactory.getCurrentSession().delete(getContactById(id));
		//tx = sessionFactory.getCurrentSession().getTransaction();
		}catch (Exception e) {
			//if any exception comes during execute of try block, catch will excute
			e.printStackTrace();
			return false;
		}
		return true;
	}


	@SuppressWarnings("unchecked")
	public List<Contact> list() {
		return  sessionFactory.getCurrentSession().createQuery("from Contact").list();
	}


	public Contact getContactById(int id) {
		
		//get method get the date from user table based on primary key i.e., id
		// and set it to User class
		//like select * from user where id = ?
	  return 	(Contact)  sessionFactory.getCurrentSession().get(Contact.class, id);
		
	}


	@Override
	public boolean update(MyCart my_Cart) {
		return false;
	}


	@Override
	public MyCart getCartById(int id) {
		return null;
	}
	

}
