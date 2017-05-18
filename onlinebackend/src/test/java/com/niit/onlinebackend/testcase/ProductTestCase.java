package com.niit.onlinebackend.testcase;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.onlinebackend.dao.ProductDAO;
import com.niit.onlinebackend.model.Product;


public class ProductTestCase {

    @Autowired 
    static AnnotationConfigApplicationContext context;
	
	@Autowired  
	static ProductDAO productDAO;
	
	@Autowired  
	static Product product;
	
	@BeforeClass
	public static void initialize()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		productDAO = (ProductDAO)context.getBean("productDAO");
		product = (Product)context.getBean("product");
	}
	/*
	@Test
	public void createSupplierTestCase() 
	{
		product.setId("4");
		product.setName("The Book");
		product.setDescription("Best book in the world");
		product.setCategory_ID("2");
		product.setSupplier_ID("2");
		product.setPrice("900");
		boolean flag = productDAO.save(product);
		assertEquals("createProductTestCase",true,flag);
	}
	*/
	@Test
	public void deleteSupplierTestCase() 
	{
		
		boolean flag = productDAO.delete("1");
		assertEquals("createSupplierTestCase",true,flag);
	}
	/*
	@Test
	public void updateSupplierTestCase()
	{
		product.setId("kiran");
		product.setName("RAJ");
		product.setPassword("NIIT");
		product.setRole("ROLE_USER");
		product.setContact("8899776633");
		boolean flag = productDAO.update(product);
		assertEquals("update Supplier TestCase",true,flag);
	}
	
	@Test
	public void validateUSerTestCase()
	{
		
		boolean flag =  productDAO.validate("kiran", "NIIT");
		
		
		assertEquals(true, flag);
		
	}
	
	
	
	@Test
	public void getAllSupplierTestCase()
	{
		int actualSize=   productDAO.list().size();
		
		//will compare actual and expected
		//if actual and expected is same - TC will pass
		//if it is different - TC fail
		assertEquals(2, actualSize);
	}
	
	*/

}
	
