package com.niit.onlinebackend.testcase;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.onlinebackend.dao.OrderTableDAO;
import com.niit.onlinebackend.model.OrderTable;

public class OrderTableTestCase {

	@Autowired
	static AnnotationConfigApplicationContext context;

	@Autowired
	static OrderTable orderTable;

	@Autowired
	static OrderTableDAO orderTableDAO;

	@BeforeClass
	public static void initialize() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();

		// get the categoryDAO from context
		orderTableDAO = (OrderTableDAO) context.getBean("orderTableDAO");

		// get the category from context

		orderTable = (OrderTable) context.getBean("orderTable");

	}

	@Test
	public void createOrderTableTestCase() {
		// orderTable.setId(1);
		orderTable.setUser_id("Kiran");
		// orderTable.setStatus("N");
		boolean flag = orderTableDAO.save(orderTable);
		assertEquals("createOrderTableTestCase", true, flag);
	}

	@Test
	public void listTestCase() {
		int orderedSize = orderTableDAO.list("Kiran").size();
		assertEquals(1, orderedSize);
	}

}
