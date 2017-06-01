package com.niit.onlinebackend.dao;

import java.util.List;

import com.niit.onlinebackend.model.OrderTable;

public interface OrderTableDAO {
	
	public boolean save(OrderTable orderTable);
	public List<OrderTable> list(String userId);

}
