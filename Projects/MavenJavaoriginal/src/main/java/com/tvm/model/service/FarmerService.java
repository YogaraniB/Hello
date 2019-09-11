package com.tvm.model.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.tvm.model.repository.Farmer;


public interface FarmerService {

	public Farmer add(Farmer e);
	public Farmer delete(Farmer e);
	public List<Farmer> view();
	public Farmer update(Farmer e); 
	public List<Farmer> getById(Farmer e);
	public List<Farmer> getbyIdAndPassword(Farmer e);
	
}
