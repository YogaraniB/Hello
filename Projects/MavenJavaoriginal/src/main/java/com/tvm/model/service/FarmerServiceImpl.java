package com.tvm.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tvm.model.repository.Farmer;
import com.tvm.model.repository.FarmerRepoImpl;
import com.tvm.model.repository.FarmerRepository;

@Service
@Transactional
public class FarmerServiceImpl implements FarmerService {

	
	FarmerRepository repo;
	@Autowired
	public FarmerServiceImpl(FarmerRepository repo) {
		this.repo = repo;
	}

	public Farmer add(Farmer e) {
		return repo.add(e);

	}

	public Farmer delete(Farmer e) {
		return repo.delete(e);
	}

	public List<Farmer> view() {
		return repo.view();
	}

	public Farmer update(Farmer e) {
		return repo.update(e);
	}

	public List<Farmer> getById(Farmer e) {
		return repo.getById(e);
	}

	public List<Farmer> getbyIdAndPassword(Farmer e) {
		
		return repo.getbyIdAndPassword(e);
	}

}
