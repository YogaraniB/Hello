package com.asminds.Book;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MainCore {

	void insert() {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sf=cfg.buildSessionFactory();
		Session s=sf.openSession();
		Transaction t=s.beginTransaction();
		Book b1=new Book();
		b1.setBookname("Boot");
		b1.setBookprice("1000");
		s.save(b1);
		t.commit();
		System.out.println("Object Saved Successfully");
		s.close();
		sf.close();
	}
	void Delete()
	{
		Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml"); 

        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();

        Object o=session.load(Book.class,new Integer(151));
        Book p=(Book)o;

        Transaction tx = session.beginTransaction();
        session.delete(p);
        System.out.println("Object Deleted successfully.....!!");
        tx.commit();
        session.close();
        factory.close();
	}
	void ViewById()
	{
		Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml"); 

        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();

        Object o=session.load(Book.class,new Integer(150));
        Book p=(Book)o;

        Transaction tx = session.beginTransaction();
       System.out.println(p.getBookid() +" " +p.getBookname() +" "+p.getBookprice());
        System.out.println("Object Printed successfully.....!!");
        tx.commit();
        session.close();
        factory.close();
	}
	void ViewAll()
	{
		Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml"); 

        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();

    Query qry=session.createQuery("from Book b");
    List<Book> l=qry.list();
    Iterator<Book> itr=l.iterator();
    while(itr.hasNext()) {
    	Book p=(Book)itr.next();
    	System.out.println(p.getBookid()+" " +p.getBookname() +" "+p.getBookprice());
    }
        

        Transaction tx = session.beginTransaction();
       
        System.out.println("Object Printed successfully.....!!");
        tx.commit();
        session.close();
        factory.close();
	}
	void Update()
	{
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml"); 

		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		Object o=session.load(Book.class,new Integer(154));
		Book s=(Book)o;

		Transaction tx = session.beginTransaction();	

		s.setBookname("Boot1");
		s.setBookprice("700");
		
		tx.commit();

		System.out.println("Object Updated successfully.....!!");
		session.close();
		factory.close();
	}
	public static void main(String[] args) {
		MainCore mc=new MainCore();
		/*mc.insert();
		mc.Delete();
		mc.ViewById();*/
		mc.ViewAll();
		mc.Update();
	
	
	
	
}
}