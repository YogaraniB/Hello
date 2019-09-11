package com.tvm.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tvm.model.persistence.Vendor;
import com.tvm.model.persistence.VendorProduct;
import com.tvm.model.repository.VendorRepoImpl;
import com.tvm.model.repository.VendorRepository;

@Service
@Transactional
public class VendorServiceImpl implements VendorService {

	
	VendorRepository repo;
	@Autowired
	public VendorServiceImpl(VendorRepository repo) {
		this.repo = repo;
	}

	public Vendor add(Vendor e) {
		return repo.add(e);

	}

	public Vendor delete(Vendor e) {
		return repo.delete(e);
	}

	public List<Vendor> view() {
		return repo.view();
	}

	public Vendor update(Vendor e) {
		return repo.update(e);
	}

	public List<Vendor> getById(Vendor e) {
		return repo.getById(e);
	}

public List<Vendor> getbyIdAndPassword(Vendor e) {
		
		return repo.getbyIdAndPassword(e);
	}



}
