package com.asminds.Employee;

import java.util.Iterator;
import java.util.List;



import org.dom4j.dom.DOMNodeHelper.EmptyNodeList;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.asminds.Book.Book;

public class MainEmp {
	
	void insert()
	{
		Configuration cfg=new Configuration().configure("hibernate.cfg.xml");
		SessionFactory Fact=cfg.buildSessionFactory();
		Session Sess=Fact.openSession();
		Transaction Trac=Sess.beginTransaction();
		
		Emloyee emp=new Emloyee();
		emp.setEmpid(102);
		emp.setEmpname("Pavi");
		emp.setEmpaddress("Chennai");
		
		Sess.save(emp);
		Trac.commit();
		System.out.println("Object Saved Successfully");
		Fact.close();
		Sess.close();
		Fact.close();
		
	}
	void delete()
	{
		Configuration cfg=new Configuration().configure("hibernate.cfg.xml");
		SessionFactory Sess=cfg.buildSessionFactory();
		Session fast=Sess.openSession();
		
		Object o=fast.load(Emloyee.class,new Integer(6));
		Emloyee emp=(Emloyee)o;
		
		Transaction Trans=fast.beginTransaction();
		fast.delete(emp);
		System.out.println("Object Deleted Successfully");
		Trans.commit();
		fast.close();
		Sess.close();
		
	}
	void ViewAll()
	{
		Configuration cg=new Configuration().configure("hibernate.cfg.xml");
		SessionFactory sf=cg.buildSessionFactory();
		Session s=sf.openSession();
		Query qry=s.createQuery("from Emloyee emp");
		List<Emloyee> l=qry.list();
		Iterator<Emloyee> itr=l.iterator();
		while(itr.hasNext()) {
			Emloyee e=(Emloyee)itr.next();
			System.err.println(e.getEmpid()+" "+e.getEmpname()+" "+e.getEmpaddress());
		}
	}
	void Update() {
		Configuration cg=new Configuration().configure("hibernate.cfg.xml");
		SessionFactory sf=cg.buildSessionFactory();
		Session s=sf.openSession();
        Transaction tx = s.beginTransaction();	
		
		Object o=s.load(Emloyee.class,new Integer(5));
		Emloyee er=(Emloyee)o;
		er.setEmpname("siva");
		er.setEmpaddress("trichy");
		
		tx.commit();
		
	}
public static void main(String[] args) {
	MainEmp me=new MainEmp();
	/*me.insert();*/
//me.delete();
	//me.ViewAll();
	me.Update();
	
}
	

}
