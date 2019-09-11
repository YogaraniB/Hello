package com.tvm.model.service;

import java.util.List;

import com.tvm.model.persistence.VendorProduct;


public interface VendorProductService {

	public VendorProduct add(VendorProduct e);
	public VendorProduct delete(VendorProduct e);
	public List<VendorProduct> view();
	public VendorProduct update(VendorProduct e); 
	public List<VendorProduct> getById(VendorProduct e);
	public VendorProduct getObjectById(VendorProduct e);
	
}
