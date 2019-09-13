package com.tvm.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tvm.model.persistence.Vendor;
import com.tvm.model.persistence.VendorProduct;
import com.tvm.model.repository.VendorProductRepoImpl;
import com.tvm.model.repository.VendorProductRepository;

@Service
@Transactional
public class VendorProductServiceImpl implements VendorProductService {

	
	VendorProductRepository repo;
	@Autowired
	public VendorProductServiceImpl(VendorProductRepository repo) {
		this.repo = repo;
	}

	public VendorProduct add(VendorProduct e) {
		return repo.add(e);

	}

	public VendorProduct delete(VendorProduct e) {
		return repo.delete(e);
	}

	public List<VendorProduct> view() {
		return repo.view();
	}

	public VendorProduct update(VendorProduct e) {
		return repo.update(e);
	}

	public List<VendorProduct> getById(VendorProduct e) {
		return repo.getById(e);
	}

	public VendorProduct getObjectById(VendorProduct e) {
		// TODO Auto-generated method stub
		return repo.getObjectById(e);
	}

	



}
