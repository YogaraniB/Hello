package com.tvm.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tvm.model.persistence.Product;
import com.tvm.model.repository.ProductRepoImpl;
import com.tvm.model.repository.ProductRepository;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

	
	ProductRepository repo;
	@Autowired
	public ProductServiceImpl(ProductRepository repo) {
		this.repo = repo;
	}

	public Product add(Product e) {
		return repo.add(e);

	}

	public Product delete(Product e) {
		return repo.delete(e);
	}

	public List<Product> view() {
		return repo.view();
	}

	public Product update(Product e) {
		return repo.update(e);
	}

	public List<Product> getById(Product e) {
		return repo.getById(e);
	}

	

}
