package com.tvm.model.repository;

import java.util.List;

import org.springframework.stereotype.Component;


public interface VendorRepository {
	public Vendor add(Vendor e);
	public Vendor delete(Vendor e);
	public List<Vendor> view();
	public Vendor update(Vendor e); 
	public List<Vendor> getById(Vendor e);

}
