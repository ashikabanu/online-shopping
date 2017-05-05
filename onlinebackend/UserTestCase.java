package com.niit.onlinebackend.testcase;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.onlinebackend.dao.UserDAO;
import com.niit.onlinebackend.model.*;

public class UserTestCase {

    @Autowired static AnnotationConfigApplicationContext context;
	
	@Autowired  static UserDAO  userDAO;
	
	@Autowired  static User user;
	
	@BeforeClass
	public static void initialize()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		userDAO = (UserDAO)context.getBean("userDAO");
		user = (User)context.getBean("user");
	}
	/*
	@Test
	public void createUserTestCase() 
	{
		user.setId("ashikha");
		user.setName("Bhanu");
		user.setPassword("ashikha");
		user.setRole("ROLE_ADMIN");
		user.setContact("889977234");
		boolean flag = userDAO.save(user);
		assertEquals("createUserTestCase",true,flag);
	}
	
	
	@Test
	public void updateUserTestCase()
	{
		user.setId("kiran");
		user.setName("RAJ");
		user.setPassword("NIIT");
		user.setRole("ROLE_USER");
		user.setContact("8899776633");
		boolean flag = userDAO.update(user);
		assertEquals("update User TestCase",true,flag);
	}
	
	@Test
	public void validateUSerTestCase()
	{
		
		boolean flag =  userDAO.validate("kiran", "NIIT");
		
		
		assertEquals(true, flag);
		
	}
	
	*/
	
	@Test
	public void getAllUserTestCase()
	{
		int actualSize=   userDAO.list().size();
		
		//will compare actual and expected
		//if actual and expected is same - TC will pass
		//if it is different - TC fail
		assertEquals(2, actualSize);
	}
	
	
}
