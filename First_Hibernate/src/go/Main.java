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
		animal.setName("С����");		
		Cat cat = new Cat();
		cat.setName("����");
		cat.setSayCat("��");		
		Dog dog = new Dog();
		dog.setName("����");
		dog.setSayDog("��");	
		session.save(animal);
		session.save(dog);
		session.save(cat);	
		
		
		trans.commit();
		session.close();
		sessionfactory.close();
	}
}
