package com.jyq.demos;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.jyq.domain.Customer;
import com.jyq.domain.LinkMan;
import com.jyq.utils.HibernateUtils;

public class Demo1 {
	
	@Test
	public void Demo2() {
		Session session = HibernateUtils.getCurrentSession();		
		Transaction transaction = session.beginTransaction();
		
		Customer cust1 = new Customer("jyq");
		Customer cust2 = new Customer("Ê¤Àû");
		
		LinkMan lkm1 = new LinkMan("aa",cust1);
		LinkMan lkm2 = new LinkMan("bb", cust1);
		LinkMan lkm3 = new LinkMan("cc", cust2);
		cust1.getLinkMans().add(lkm1);
		cust1.getLinkMans().add(lkm2);
		cust2.getLinkMans().add(lkm3);
		
		//session.save(cust1);
		//session.save(cust2);
		session.save(lkm1);
		session.save(lkm2);
		session.save(lkm3);
		
		transaction.commit();
	}
	
	@Test
	public void Demo3() {
		Session session = HibernateUtils.getCurrentSession();		
		Transaction transaction = session.beginTransaction();
		
		Customer customer = session.get(Customer.class, 1);
		session.delete(customer);
		
		transaction.commit();
	}
	
	@Test
	public void Demo4() {
		Session session = HibernateUtils.getCurrentSession();		
		Transaction transaction = session.beginTransaction();
		
		Customer customer = session.get(Customer.class, 2);
		LinkMan linkMan = session.get(LinkMan.class, 2);		
		customer.getLinkMans().add(linkMan);
		linkMan.setCustomer(customer);	
		
		transaction.commit();
	}
}
