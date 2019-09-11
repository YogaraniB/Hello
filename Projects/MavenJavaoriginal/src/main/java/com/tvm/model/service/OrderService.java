package com.tvm.model.service;

import java.util.List;


import com.tvm.model.repository.Order;


public interface OrderService {

	public Order add(Order e);
	public Order delete(Order e);
	public List<Order> view();
	public Order update(Order e); 
	public List<Order> getById(Order e);

	
}
