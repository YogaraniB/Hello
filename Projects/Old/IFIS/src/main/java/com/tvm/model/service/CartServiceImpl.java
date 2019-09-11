package com.tvm.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tvm.model.persistence.Cart;
import com.tvm.model.repository.CartRepoImpl;
import com.tvm.model.repository.CartRepository;

@Service
@Transactional
public class CartServiceImpl implements CartService {

	
	CartRepository repo;
	@Autowired
	public CartServiceImpl(CartRepository repo) {
		this.repo = repo;
	}

	public Cart add(Cart e) {
		return repo.add(e);

	}

	public Cart delete(Cart e) {
		return repo.delete(e);
	}

	public List<Cart> view() {
		return repo.view();
	}

	public Cart update(Cart e) {
		return repo.update(e);
	}

	public List<Cart> getById(Cart e) {
		return repo.getById(e);
	}

	

}
