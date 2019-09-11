package com.tvm.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tvm.model.persistence.Order;
import com.tvm.model.repository.OrderRepoImpl;
import com.tvm.model.repository.OrderRepository;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

	
	OrderRepository repo;
	@Autowired
	public OrderServiceImpl(OrderRepository repo) {
		this.repo = repo;
	}

	public Order add(Order e) {
		return repo.add(e);

	}

	public Order delete(Order e) {
		return repo.delete(e);
	}

	public List<Order> view() {
		return repo.view();
	}

	public Order update(Order e) {
		return repo.update(e);
	}

	public List<Order> getById(Order e) {
		return repo.getById(e);
	}

	

}
