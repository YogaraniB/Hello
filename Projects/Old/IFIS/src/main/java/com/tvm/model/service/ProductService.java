package com.tvm.model.service;

import java.util.List;

import com.tvm.model.persistence.Product;


public interface ProductService {

	public Product add(Product e);
	public Product delete(Product e);
	public List<Product> view();
	public Product update(Product e); 
	public List<Product> getById(Product e);

	
}
