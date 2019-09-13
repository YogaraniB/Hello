package com.tvm.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tvm.model.persistence.Transport;
import com.tvm.model.repository.TransportRepoImpl;
import com.tvm.model.repository.TransportRepository;

@Service
@Transactional
public class TransportServiceImpl implements TransportService {

	
	TransportRepository repo;
	@Autowired
	public TransportServiceImpl(TransportRepository repo) {
		this.repo = repo;
	}

	public Transport add(Transport e) {
		return repo.add(e);

	}

	public Transport delete(Transport e) {
		return repo.delete(e);
	}

	public List<Transport> view() {
		return repo.view();
	}

	public Transport update(Transport e) {
		return repo.update(e);
	}

	public List<Transport> getById(Transport e) {
		return repo.getById(e);
	}

	public Transport getById(int id) {
		
		return repo.getById(id);
	}

	

}
