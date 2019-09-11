package com.tvm.model.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TransportRepoImpl  implements TransportRepository{

	private SessionFactory sf;
	
	private Session getSession() {
		return sf.getCurrentSession();
	}
	
	@Autowired
	public TransportRepoImpl(SessionFactory sf) {
		super();
		this.sf = sf;
	}

	public Transport add(Transport e) {
		getSession().save(e);
		return e;
	}

	public Transport delete(Transport e) {
		/*Transport e1=this.getById(e);*/
		if(e!=null)
			getSession().delete(e);
		return e;
	}

	@SuppressWarnings({ "deprecation", "unchecked" })
	public List<Transport> view() {
		return getSession().createQuery("from Transport").list();
	}

	public Transport update(Transport e) {
		 getSession().saveOrUpdate(e);
		 return e;
	}

	public List<Transport> getById(Transport e) {
	return	getSession().createQuery("from Transport e where e.id=" +e.getId()).list();
		
	}

	

}
