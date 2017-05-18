package com.niit.onlinebackend.testcase;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.onlinebackend.dao.SupplierDAO;
import com.niit.onlinebackend.model.Supplier;

public class SupplierTestCase 
{
	@Autowired
	static AnnotationConfigApplicationContext context;

	@Autowired
	static SupplierDAO supplierDAO;

	@Autowired
	static Supplier supplier;

	@BeforeClass
	public static void initialize() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		supplierDAO = (SupplierDAO) context.getBean("supplierDAO");
		supplier = (Supplier) context.getBean("supplier");
	}
    /*
	 @Test
	 public void createSupplierTestCase()
	 {
     supplier.setId("1");
	  supplier.setName("king"); 
	  supplier.setAddress("Gun");
	  boolean flag=supplierDAO.save(supplier);
	  assertEquals("createSupplierTestCase",true,flag); }
	  
	  */
	
	@Test
	public void DeleteSupplierTestCase()
	{

		boolean flag = supplierDAO.delete("012");
		assertEquals("createSupplierTestCase",true, flag);

	}
	

	/*
	 * @Test public void updateSupplierTestCase() { supplier.setId("kiran");
	 * supplier.setName("RAJ"); supplier.setPassword("NIIT");
	 * supplier.setRole("ROLE_USER"); supplier.setContact("8899776633"); boolean
	 * flag = supplierDAO.update(supplier); assertEquals(
	 * "update Supplier TestCase",true,flag); }
	 * 
	 * @Test public void validateUSerTestCase() {
	 * 
	 * boolean flag = supplierDAO.validate("kiran", "NIIT");
	 * 
	 * 
	 * assertEquals(true, flag);
	 * 
	 * }
	 * 
	 * @Test public void getAllSupplierTestCase() { int actualSize=
	 * supplierDAO.list().size();
	 * 
	 * //will compare actual and expected //if actual and expected is same - TC
	 * will pass //if it is different - TC fail assertEquals(2, actualSize); }
	 */
}