package com.niit.onlinebackend.testcase;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.onlinebackend.dao.CategoryDAO;
import com.niit.onlinebackend.model.Category;

public class CategoryTestCase 
{

    @Autowired static AnnotationConfigApplicationContext context;
	
	@Autowired  static CategoryDAO  categoryDAO;
	
	@Autowired  static Category category;
	
	@BeforeClass
	public static void initialize()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		categoryDAO = (CategoryDAO)context.getBean("categoryDAO");
		category = (Category)context.getBean("category");
	}
    /*
	@Test
	public void createCategoryTestCase() 
	{
		category.setId("22");
		category.setName("category2");
		category.setDescription("This is Category 2 item");
		boolean flag = categoryDAO.save(category);
		assertEquals("createCategoryTestCase",true,flag);
	}
	*/
	/*
	@Test
	public void DeleteCategoryTestCase() 
	{
		
		boolean flag = categoryDAO.delete("2");
		assertEquals("createCategoryTestCase",true,flag);
	}
	*/
	/*
	@Test
	public void updateCategoryTestCase()
	{
		category.setId("kiran");
		category.setName("RAJ");
		category.setPassword("NIIT");
		category.setRole("ROLE_USER");
		category.setContact("8899776633");
		boolean flag = categoryDAO.update(category);
		assertEquals("update Category TestCase",true,flag);
	}
	
	@Test
	public void validateUSerTestCase()
	{
		boolean flag =  categoryDAO.validate("kiran", "NIIT");
		
		assertEquals(true, flag);
	}
	*/
	
	@Test
	public void getAllCategoryTestCase()
	{
		Category flag = categoryDAO.getCategoryByID("23");
		assertEquals("getAllCategoryTestCase",true,flag);
		
	
		
		//will compare actual and expected
		//if actual and expected is same - TC will pass
		//if it is different - TC fail
		
	}
    
}
