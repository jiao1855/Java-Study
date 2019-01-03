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
		// 1.加载Hibernate的核心配置文件，configure()方法默认加载名为hibernate.cfg.xml的配置文件
		Configuration configuration = new Configuration().configure();
		// 2.创建一个SessionFactory对象：类似于JDBC中连接池
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		// 3.通过SessionFactory获取到Session对象：类似于JDBC中Connection
		Session session = sessionFactory.openSession();
		// 4.手动开启事务：
		Transaction transaction = session.beginTransaction();
		// 5.编写代码
		User user = new User("abc",19);
		session.save(user);
		// 6.事务提交
		transaction.commit();
		// 7.资源释放
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
		 * get方法
		 * 1,采用的是立即加载，执行到get方法时，会立即发送Sql语句去查询。
		 * 2,查询后返回真实对象本身。
		 * 3,查询一个找不到的对象时，返回null。
		 */
		User user = session.get(User.class, 1);
		System.out.println(user);
		
		/**
		 * load方法
		 * 1,采用的是延迟加载（lazy懒加载），执行到load方法时，不会发送Sql语句，当真正使用时才发送Sql。
		 * 2,查询后返回的是代理对象，javassist-3.18.1-GA.jar
		 * 3,查询一个找不到的对象时，返回 ObjectNotFoundException
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
		
		//先查询再删除
		User user = session.get(User.class, 1);
		session.delete(user);
		
		transaction.commit();
		session.close();
	}
	
	@Test
	public void HibernateTestSaveUpdate() {
		Session session = HibernateUtils.openSession();
		Transaction transaction = session.beginTransaction();
		
		//保存或更新
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
		
		//接收HQL：Hibernate Query Languate，面向对象的查询语言
		Query query = session.createQuery("from User");
		List<User> list = query.list();
		for (User user : list) {
			System.out.println(user);
		}
		
		//接收Sql语句
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
		user.setName("黄忠");
		
		transaction.commit();
		
		//这个session对象不用关闭，当线程执行结束后，会自动关闭
		//session.close();
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void HibernateTestQuery2() {
		Session session = HibernateUtils.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		
		Query query = session.createQuery("from User where name like ?");
		//设置条件参数
		query.setParameter(0, "abc%");
		//设置分页
		query.setFirstResult(0);	//从0开始
		query.setMaxResults(2);		//每页2条数据
		
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
		//设置条件参数
		criteria.add(Restrictions.like("name", "abc%"));
		//设置分页
		criteria.setFirstResult(0);		//从0开始
		criteria.setMaxResults(2);		//每页2条数据
		
		List<User> list = criteria.list();
		for (User user : list) {
			System.out.println(user);
		}
		
		transaction.commit();
	}

}
