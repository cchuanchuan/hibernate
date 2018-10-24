package students.enities;

import static org.junit.Assert.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.junit.Test;

public class HibernateTest {
	/*1，创建一个SessionFactory工厂类*/
	/*2，通过工厂类开启Session对象*/
	/*3，开始事务*/
	/*4，执行数据库的操作*/
	/*5，提交事务*/
	/*6，关闭Session*/
	/*7，关闭工厂类*/
	@Test
	public void test() {
		//创建一个SessionFactory的工厂类，建立与数据库连接的会话
		SessionFactory sessionfactory = null;
		//SessionFactory 需要一个配置类 Configuration
		//Configuration conf = new Configuration().configure();		
		//所有的配置或者服务要生效，要生效必须注册到一个注册类中
		//ServiceRegistry service = conf.getStandardServiceRegistryBuilder().build();	
		//service 获取的第二种方式，如果配置文件的名称改了的话必须用这种方式
		ServiceRegistry service1 = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		//通过 元数据，生成工厂类
		sessionfactory = new MetadataSources(service1).buildMetadata().buildSessionFactory();		
		//开启会话
		Session session = sessionfactory.openSession();		
		//开启事务处理
		Transaction trans = session.beginTransaction();
		//执行数据库的操作(面向对象的操作)
		Student student = new Student("陈4", "男", 15);
		session.save(student);		
		//提交事务
		trans.commit();
		//关闭资源
		session.close();
		sessionfactory.close();
	}

}
