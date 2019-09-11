package com.tvm.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tvm.model.persistence.Customer;
import com.tvm.model.repository.CustomerRepoImpl;
import com.tvm.model.repository.CustomerRepository;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

	
	CustomerRepository repo;
	@Autowired
	public CustomerServiceImpl(CustomerRepository repo) {
		this.repo = repo;
	}

	public Customer add(Customer e) {
		return repo.add(e);

	}

	public Customer delete(Customer e) {
		return repo.delete(e);
	}

	public List<Customer> view() {
		return repo.view();
	}

	public Customer update(Customer e) {
		return repo.update(e);
	}

	public List<Customer> getById(Customer e) {
		return repo.getById(e);
	}
public List<Customer> getbyIdAndPassword(Customer e) {
		
		return repo.getbyIdAndPassword(e);
	}
	

}
