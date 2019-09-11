package com.tvm.model.service;

import java.util.List;

import com.tvm.model.persistence.Vendor;
import com.tvm.model.persistence.VendorProduct;


public interface VendorService {

	public Vendor add(Vendor e);
	public Vendor delete(Vendor e);
	public List<Vendor> view();
	public Vendor update(Vendor e); 
	public List<Vendor> getById(Vendor e);
	public List<Vendor> getbyIdAndPassword(Vendor e);
	
}
