package Test;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;
import org.hibernate.service.ServiceRegistry;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import common_entities.MyUser;
import common_entities.User;
import extend__.Animal;
import extend__.Cat;
import extend__.Dog;
import students.enities.Student;
import test_n_1.Test_Teacher;

public class UserTest {
	ServiceRegistry service = null;
	SessionFactory sessionfactory = null;
	Session session = null;
	Transaction trans = null;

	@Before
	public void init() {
		System.out.print("1213");
		service = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		sessionfactory = new MetadataSources(service).buildMetadata().buildSessionFactory();
		session = sessionfactory.openSession();
		trans = session.beginTransaction();
	}
//		SessionFactory sessionfactory = null;
//		Configuration configuration = new Configuration.
//	}

	@After
	public void destory() {
		trans.commit();
		session.close();
		sessionfactory.close();
	}

	@Test
	public void test() {
		try {
			Student stu = session.get(Student.class, 1);
			Student stu1 = session.get(Student.class, 1);
			System.out.println(stu == stu1);
			//stu.setAge(12);
			System.out.println(stu);
			//session.refresh(stu);
			System.out.println(stu);
		}catch (Exception e) {
			e.printStackTrace();
		}
		

	}

	@Test
	public void test1() {
		Student stu = session.get(Student.class, 5);
		
		
		
		System.out.println(stu);
		
		
		// stu.setUsername("锟斤拷锟斤拷锟秸达拷");
		// session.flush();
		
		System.out.println(session.contains(stu));
	}
	
	//get 锟斤拷锟斤拷 锟斤拷 锟斤拷锟斤拷锟斤拷锟截讹拷锟襟，凤拷锟斤拷sql锟斤拷锟� ,锟斤拷锟斤拷值锟斤拷锟斤拷student 锟侥讹拷锟斤拷
	//load 锟斤拷锟斤拷锟斤拷 只锟斤拷锟矫碉拷时锟斤拷呕锟斤拷锟�,锟斤拷锟斤拷值锟斤拷Student锟斤拷锟斤拷锟斤拷锟斤拷锟�
	@Test
	public void testGet() {
//		Student stu = session.get(Student.class, 8);
//		System.out.println(stu);
//		session.delete(stu);
//		stu.setId(9);
//		
//		
//		session.update(stu);
//		System.out.println(stu);
		//System.out.println(stu);
//		Student stu = new Student("小锟斤拷", "女", 18);
//		stu.setId(5);
//		session.update(stu);
//			
		//锟斤拷锟矫存储锟斤拷锟斤拷
		session.doWork(connection -> {
			System.out.println(connection);
		});
			
		Animal animal = new Animal();
		animal.setName("小锟斤拷锟斤拷");
		
		Dog dog = new Dog();
		dog.setName("锟斤拷锟斤拷");
		dog.setSayDog("锟斤拷");
		
		Cat cat = new Cat();
		cat.setName("锟斤拷锟斤拷");
		cat.setSayCat("锟斤拷");
		
		session.save(animal);
		session.save(dog);
		session.save(cat);
	}
	@Test
	public void testLoad() {
		
		Student stu1 = session.get(Student.class, 5);
		
		System.out.println(stu1.getClass().getName());
		//System.out.println(stu.getClass().getName());
		//System.out.println(stu);
	}
	@Test
	public void testE() throws ParseException {
		MyUser a = new MyUser("das", "adsa");
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date date = df.parse("2000-10-10");
		a.setBirthday(date);
		session.save(a);
		
//		MyUser b = session.get(MyUser.class, 1);
//		System.out.println(b.getAge());
	}
	@Test
	public void testw() {
//		Test_Teacher teacher = session.get(Test_Teacher.class, 1);
//		Hibernate.initialize(teacher.getStudents());
//		String hql = "select t from Test_Teacher t";
//		Query<Test_Teacher>  query = session.createQuery(hql);
//		List<Test_Teacher> teachers = query.list();
//		teachers.forEach( t -> {
//			System.out.println( t.getStudents().size() );
//		});
		
		
		Test_Teacher teacher = session.load(Test_Teacher.class, 1);
		System.out.println(teacher.getStudents().size());
	}
	@Test
	public void TestHQL() {
		
	}

}
