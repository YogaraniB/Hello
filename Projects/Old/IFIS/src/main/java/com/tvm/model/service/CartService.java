package com.tvm.model.service;

import java.util.List;

import com.tvm.model.persistence.Cart;


public interface CartService {

	public Cart add(Cart e);
	public Cart delete(Cart e);
	public List<Cart> view();
	public Cart update(Cart e); 
	public List<Cart> getById(Cart e);

	
}
