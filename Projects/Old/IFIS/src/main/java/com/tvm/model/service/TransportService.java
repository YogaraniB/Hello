package com.tvm.model.service;

import java.util.List;

import com.tvm.model.persistence.Transport;


public interface TransportService {

	public Transport add(Transport e);
	public Transport delete(Transport e);
	public List<Transport> view();
	public Transport update(Transport e); 
	public List<Transport> getById(Transport e);
	public Transport getById(int id);

	
}
