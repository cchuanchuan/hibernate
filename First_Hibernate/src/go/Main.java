package go;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

import extend__.Animal;
import extend__.Cat;
import extend__.Dog;

public class Main {
	public Main() {
		
	}
	public static void main(String[] args) {
		ServiceRegistry service = null;
		SessionFactory sessionfactory = null;
		Session session = null;
		Transaction trans = null;
		service = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		sessionfactory = new MetadataSources(service).buildMetadata().buildSessionFactory();
		session = sessionfactory.openSession();
		trans = session.beginTransaction();
		
		Animal animal = new Animal();
		animal.setName("小花花");		
		Cat cat = new Cat();
		cat.setName("阿飞");
		cat.setSayCat("喵");		
		Dog dog = new Dog();
		dog.setName("虎子");
		dog.setSayDog("汪");	
		session.save(animal);
		session.save(dog);
		session.save(cat);	
		
		
		trans.commit();
		session.close();
		sessionfactory.close();
	}
}
