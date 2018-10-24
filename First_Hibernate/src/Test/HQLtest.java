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

import test_n_1.Test_Student;
import test_n_1.Test_Teacher;

public class HQLtest {
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
	public void testHQL() {
		
		String hql = "from Test_Student s where s.id > ? and s.name like ?";
		System.out.println(Arrays.toString(session
				.createQuery(hql)
				.setParameter(0, 2)
				.setParameter(1, "%张%")
				.list()
				.toArray()
				));
		
		String hql1 = "from Test_Student s where s.id > :id and s.name like :name";
		System.out.println(Arrays.toString(session
				.createQuery(hql1)
				.setParameter("id", 2)
				.setParameter("name", "%张%")
				.list()
				.toArray()
				));
		//如果  参数是 一个对象的情况
		
		String hql2 = "from Test_Student as s where s.teacher=:teacher";
		Test_Teacher teacher = new Test_Teacher();
		teacher.setId(1);
		System.out.println(Arrays.toString(session
				.createQuery(hql2)
				.setParameter("teacher", teacher)//**********				
				.list()
				.toArray()
				));
	}
	@Test	
	public void test分页() {	
		//第3+1条记录开始，取出5条数据
		System.out.println(Arrays.toString(session
				.createQuery("from Test_Student")
				.setFirstResult(3)
				.setMaxResults(5)
				.list()
				.toArray()
				));
		//从第二页中取出2条数据
		int pageNo = 3;
		int pageSize = 5;		
		System.out.println(Arrays.toString(session
				.createQuery("from Test_Student")
				.setFirstResult((pageNo-1) * pageSize)
				.setMaxResults(2)
				.list()
				.toArray()
				));
	}
	@Test
	
	public void test命名查询() {
		System.out.println(Arrays.toString(session
				.getNamedQuery("test1")
				.list()
				.toArray()				
				));
	}
	@Test
	@SuppressWarnings("unchecked")
	public void test投影查询() {
		//如果查询的只有一个属性，泛型应该用Object对象
		String hql2 = "select e.name from Test_Student e";
		Query<Object> query1 = session.createQuery(hql2);
		List<Object> list1 = query1.list();
		list1.forEach(action -> {
			System.out.println(action);
		});
		//如果查询的只有多个属性，泛型应该用Object数组
		String hql1 = "select e.name,e.teacher.id from Test_Student e";
		Query<Object[]> query = session.createQuery(hql1);
		List<Object[]> list = query.list();
		list.forEach(action -> {
			System.out.println(Arrays.toString(action));
		});
	}
	@Test
	@SuppressWarnings("unchecked")
	public void test对象查询() {
		String hql = "select new Test_Student(s.name) from Test_Student s";
		Query<Test_Student> query = session.createQuery(hql);
		List<Test_Student> list = query.list();
		list.forEach(action -> {
			System.out.println(action);
		});
	}
	@Test
	@SuppressWarnings("unchecked")
	public void test聚集函数() {
		String hql = "select sum(s.id),avg(s.id),max(s.id),min(s.id) from Test_Student s "
				+ "group by s.teacher.id having s.teacher.id = :teacher_id";
		session	.createQuery(hql)
				.setParameter("teacher_id", 1)
				.list()
				.forEach(action->{
					System.out.println(Arrays.toString((Object[])action));
				});;
//		Query<Object[]> query = session.createQuery(hql);
//		query.setParameter("teacher_id", 1);
//		List<Object[]> list = query.list();		
	}
	@Test
	@SuppressWarnings("unchecked")
	public void test连接() {
		String hql = "from Test_Student s inner join s.teacher t ";
		session.createQuery(hql)
				.list()
				.forEach(action -> {
					System.out.println(Arrays.toString((Object[])action));
				});
		//
		String hql1 = "from Test_Student s inner join fetch s.teacher t ";
		session.createQuery(hql1)
				.list()
				.forEach(action -> {
					System.out.println(action);
				});
	}
	@Test
	@SuppressWarnings("unchecked")
	public void test批量增删改() {
//		//批量插入
//		String hql = "insert into Copy_Student (name,teacher)"
//				+" select name,teacher from Test_Student";
//		int count = session.createQuery(hql).executeUpdate();
//		System.out.println(count);
		//不支持 
//		String hql = "insert into Copy_Student (name,teacher)"
//				+" values('陈',asda)";
//		int count = session.createQuery(hql).executeUpdate();
//		System.out.println(count);
		//批量删除
//		String hql1 = "delete from Copy_Student s where s.id > ?";
//		int rs = session.createQuery(hql1).setParameter(0, 20).executeUpdate();
//		System.out.println(rs);
		
		//批量修改
		String hql2 = "update Copy_Student set teacher_id = 1";
		int rs = session.createQuery(hql2).executeUpdate();
		System.out.println(rs);
		
	}
	@Test
	@SuppressWarnings("unchecked")
	public void testSQL() {
		String sql = "select * from copy_student where id > ?";
		NativeQuery<Object[]> query = session.createNativeQuery(sql);
		query.setParameter(1, 10);
		List<Object[]> list = query.list();
		list.forEach(action -> {
			System.out.println(Arrays.toString(action));
		});
	}
	
	

}
