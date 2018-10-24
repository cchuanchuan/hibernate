package Test;



import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.hibernate.service.ServiceRegistry;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import DAO.HibernateUtils;
import test_n_1.Test_Student;
import test_n_1.Test_Teacher;

public class 缓存Test {
	ServiceRegistry service = null;
	SessionFactory sessionfactory = null;
	Session session = null;
	Transaction trans = null;

	@Before
	public void init() {
		service = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		sessionfactory = new MetadataSources(service).buildMetadata().buildSessionFactory();
		session = sessionfactory.openSession();
		trans = session.beginTransaction();
	}

	@After
	public void destory() {
		trans.commit();
		session.close();
		sessionfactory.close();
	}
	
	
	@Test
	public void test类级别缓存() {
		Test_Student stu = session.load(Test_Student.class, 1);
		System.out.println(stu);
		trans.commit();
		session.close();
		
		session = sessionfactory.openSession();
		trans = session.beginTransaction();
		//启用了二级缓存，这里可以少发起一条sql语句
		Test_Student stu1 = session.load(Test_Student.class, 1);
		System.out.println(stu1);
	}
	@Test
	public void test集合级别缓存() {
		//这里如果 没有设置 集合类别的缓存的话，teacher只查询一次，但是Students集合还是查询了2次
		Test_Teacher teacher = session.get(Test_Teacher.class, 1);
		System.out.println(teacher.getStudents());
		
		trans.commit();
		session.close();
		
		session = sessionfactory.openSession();
		trans = session.beginTransaction();
		
		Test_Teacher teacher1 = session.get(Test_Teacher.class, 1);
		System.out.println(teacher1.getStudents());
	}
	
	@Test
	public void test磁盘缓存() {
		//HQL需要单独开启2级缓存
		String hql = "from Test_Student s where s.id < ?";
		Query<Test_Student> query = session.createQuery(hql);
		//query.setCacheable(true);
		query.setParameter(0, 14);
		List<Test_Student> list = query.list();
		System.out.println(list);
		
		
		List<Test_Student> list1 = query.list();
		System.out.println(list1);
	}
	@Test
	public void test() {
		HibernateUtils.getInstance();
	}
	
	

}
