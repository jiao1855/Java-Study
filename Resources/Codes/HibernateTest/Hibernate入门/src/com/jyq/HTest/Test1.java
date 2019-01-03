package com.jyq.HTest;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

import com.jyq.domain.User;
import com.jyq.utils.HibernateUtils;

public class Test1 {

	@Test
	public void HibernateTest() {
		// 1.����Hibernate�ĺ��������ļ���configure()����Ĭ�ϼ�����Ϊhibernate.cfg.xml�������ļ�
		Configuration configuration = new Configuration().configure();
		// 2.����һ��SessionFactory����������JDBC�����ӳ�
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		// 3.ͨ��SessionFactory��ȡ��Session����������JDBC��Connection
		Session session = sessionFactory.openSession();
		// 4.�ֶ���������
		Transaction transaction = session.beginTransaction();
		// 5.��д����
		User user = new User("abc",19);
		session.save(user);
		// 6.�����ύ
		transaction.commit();
		// 7.��Դ�ͷ�
		session.close();
		sessionFactory.close();
	}
	
	@Test
	public void HibernateTest2() {
		
		Session session = HibernateUtils.openSession();
		Transaction transaction = session.beginTransaction();
		
		User user = new User("abc",19);
		session.save(user);
		
		transaction.commit();
		session.close();
	}
	
	@Test
	public void HibernateTestQuery() {
		
		Session session = HibernateUtils.openSession();
		Transaction transaction = session.beginTransaction();
		/**
		 * get����
		 * 1,���õ����������أ�ִ�е�get����ʱ������������Sql���ȥ��ѯ��
		 * 2,��ѯ�󷵻���ʵ������
		 * 3,��ѯһ���Ҳ����Ķ���ʱ������null��
		 */
		User user = session.get(User.class, 1);
		System.out.println(user);
		
		/**
		 * load����
		 * 1,���õ����ӳټ��أ�lazy�����أ���ִ�е�load����ʱ�����ᷢ��Sql��䣬������ʹ��ʱ�ŷ���Sql��
		 * 2,��ѯ�󷵻ص��Ǵ������javassist-3.18.1-GA.jar
		 * 3,��ѯһ���Ҳ����Ķ���ʱ������ ObjectNotFoundException
		 */
		User user2 = session.load(User.class, 19);
		System.out.println(user2);
		
		transaction.commit();
		session.close();
	}
	
	@Test
	public void HibernateTestUpdate() {
		Session session = HibernateUtils.openSession();
		Transaction transaction = session.beginTransaction();
		
		User user = session.get(User.class, 1);
		user.setName("jyq");
		session.update(user);
		
		transaction.commit();
		session.close();
	}
	
	@Test
	public void HibernateTestDelete() {
		Session session = HibernateUtils.openSession();
		Transaction transaction = session.beginTransaction();
		
		//�Ȳ�ѯ��ɾ��
		User user = session.get(User.class, 1);
		session.delete(user);
		
		transaction.commit();
		session.close();
	}
	
	@Test
	public void HibernateTestSaveUpdate() {
		Session session = HibernateUtils.openSession();
		Transaction transaction = session.beginTransaction();
		
		//��������
		User user = session.get(User.class, 2);
		user.setName("jyq");
		session.saveOrUpdate(user);
		
		transaction.commit();
		session.close();
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void HibernateTestQueryAll() {
		Session session = HibernateUtils.openSession();
		Transaction transaction = session.beginTransaction();
		
		//����HQL��Hibernate Query Languate���������Ĳ�ѯ����
		Query query = session.createQuery("from User");
		List<User> list = query.list();
		for (User user : list) {
			System.out.println(user);
		}
		
		//����Sql���
		SQLQuery sqlQuery = session.createSQLQuery("select * from user");
		List<Object[]> users = sqlQuery.list();
		for (Object[] user : users) {
			System.out.println(Arrays.toString(user));
		}
		
		transaction.commit();
		session.close();
	}
	
	@Test
	public void HibernateTestTransacton() {
		Session session = HibernateUtils.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		
		User user = session.get(User.class, 5);
		user.setName("����");
		
		transaction.commit();
		
		//���session�����ùرգ����߳�ִ�н����󣬻��Զ��ر�
		//session.close();
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void HibernateTestQuery2() {
		Session session = HibernateUtils.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		
		Query query = session.createQuery("from User where name like ?");
		//������������
		query.setParameter(0, "abc%");
		//���÷�ҳ
		query.setFirstResult(0);	//��0��ʼ
		query.setMaxResults(2);		//ÿҳ2������
		
		List<User> list = query.list();
		for (User user : list) {
			System.out.println(user);
		}
		
		transaction.commit();
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void HibernateTestQuery3() {
		Session session = HibernateUtils.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		
		Criteria criteria = session.createCriteria(User.class);
		//������������
		criteria.add(Restrictions.like("name", "abc%"));
		//���÷�ҳ
		criteria.setFirstResult(0);		//��0��ʼ
		criteria.setMaxResults(2);		//ÿҳ2������
		
		List<User> list = criteria.list();
		for (User user : list) {
			System.out.println(user);
		}
		
		transaction.commit();
	}

}
