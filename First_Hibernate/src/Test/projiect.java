package Test;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import extend__.Animal;
import extend__.Cat;
import extend__.Dog;
import test_1_1.IdCard;
import test_1_1.Person;
import test_n_1.Test_Student;
import test_n_1.Test_Teacher;
import test_n_n.Course;
import test_n_n.Teacher;

public class projiect {
	ServiceRegistry service = null;
	SessionFactory sessionfactory = null;
	Session session = null;
	Transaction trans = null;

	@Before
	public void myinit() {
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
	public void test() {
//		Test_Teacher teacher = new Test_Teacher();
//		teacher.setName("³Â¿ÆÑà");
//		
//		Test_Student stu1 = new Test_Student();
//		stu1.setName("ÁõÐñÑô");
//		stu1.setTeacher(teacher);
//		
//		Test_Student stu2 = new Test_Student();
//		stu2.setName("·ë¼Ò¸ß");
//		stu2.setTeacher(teacher);
//		Set<Test_Student> set = new HashSet<>();
//		set.add(stu1);
//		set.add(stu2);
//		teacher.setStudents(set);
//		
//		session.save(teacher);
//		session.save(stu1);
//		session.save(stu2);		
		
//		Test_Student stu3 = session.load(Test_Student.class, 1);
//		System.out.println(stu3.getTeacher().getName());
		//System.out.println(teacher.getStudents());
		
//		Test_Teacher teacher = session.get(Test_Teacher.class, 2);
//		System.out.println(teacher.getStudents());
	}
	@Test
	public void test1() {
		Teacher teacher1 = new Teacher();
		teacher1.setName("³Â¿ÆÑà");
		Teacher teacher2 = new Teacher();
		teacher2.setName("³Âº½");
		
		Course course1 = new  Course();
		course1.setName("java");
		Course course2 = new  Course();
		course2.setName("javaee");
		
		Set<Course> courses = new HashSet<>();
		courses.add(course1);
		courses.add(course2);
		
		Set<Teacher> teachers = new HashSet<>();
		teachers.add(teacher1);
		teachers.add(teacher2);
		
		teacher1.setCources(courses);
		teacher2.setCources(courses);
		
		course1.setTeachers(teachers);
		course2.setTeachers(teachers);
		
		session.save(teacher1);
		session.save(teacher2);
		session.save(course1);
		session.save(course2);
		
	}
	@Test
	public void testExtends() {
		Animal animal = new Animal();
		animal.setName("Ð¡»¨»¨");
		
		Dog dog = new Dog();
		dog.setName("»¢×Ó");
		dog.setSayDog("Íô");
		
		Cat cat = new Cat();
		cat.setName("°¢·É");
		cat.setSayCat("ß÷");
		
		session.save(animal);
		session.save(dog);
		session.save(cat);
	}

}
