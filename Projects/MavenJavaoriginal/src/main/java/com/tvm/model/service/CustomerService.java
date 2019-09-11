package com.tvm.model.service;

import java.util.List;


import com.tvm.model.repository.Customer;
import com.tvm.model.repository.Customer;


public interface CustomerService {

	public Customer add(Customer e);
	public Customer delete(Customer e);
	public List<Customer> view();
	public Customer update(Customer e); 
	public List<Customer> getById(Customer e);
	public List<Customer> getbyIdAndPassword(Customer e);
	
}
