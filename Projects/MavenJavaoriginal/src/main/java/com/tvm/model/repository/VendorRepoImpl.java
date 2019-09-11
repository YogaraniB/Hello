package com.tvm.model.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class VendorRepoImpl  implements VendorRepository{

	private SessionFactory sf;
	
	private Session getSession() {
		return sf.getCurrentSession();
	}
	
	@Autowired
	public VendorRepoImpl(SessionFactory sf) {
		super();
		this.sf = sf;
	}

	public Vendor add(Vendor e) {
		getSession().save(e);
		return e;
	}

	public Vendor delete(Vendor e) {
		/*Vendor e1=this.getById(e);*/
		if(e!=null)
			getSession().delete(e);
		return e;
	}

	@SuppressWarnings({ "deprecation", "unchecked" })
	public List<Vendor> view() {
		return getSession().createQuery("from Vendor").list();
	}

	public Vendor update(Vendor e) {
		 getSession().saveOrUpdate(e);
		 return e;
	}

	public List<Vendor> getById(Vendor e) {
	return	getSession().createQuery("from Vendor e where e.id=" +e.getvendorid()).list();
		
	}

	

}
