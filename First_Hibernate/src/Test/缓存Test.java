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

public class ����Test {
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
	public void test�༶�𻺴�() {
		Test_Student stu = session.load(Test_Student.class, 1);
		System.out.println(stu);
		trans.commit();
		session.close();
		
		session = sessionfactory.openSession();
		trans = session.beginTransaction();
		//�����˶������棬��������ٷ���һ��sql���
		Test_Student stu1 = session.load(Test_Student.class, 1);
		System.out.println(stu1);
	}
	@Test
	public void test���ϼ��𻺴�() {
		//������� û������ �������Ļ���Ļ���teacherֻ��ѯһ�Σ�����Students���ϻ��ǲ�ѯ��2��
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
	public void test���̻���() {
		//HQL��Ҫ��������2������
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
