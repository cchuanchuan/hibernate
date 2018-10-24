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
	/*1������һ��SessionFactory������*/
	/*2��ͨ�������࿪��Session����*/
	/*3����ʼ����*/
	/*4��ִ�����ݿ�Ĳ���*/
	/*5���ύ����*/
	/*6���ر�Session*/
	/*7���رչ�����*/
	@Test
	public void test() {
		//����һ��SessionFactory�Ĺ����࣬���������ݿ����ӵĻỰ
		SessionFactory sessionfactory = null;
		//SessionFactory ��Ҫһ�������� Configuration
		//Configuration conf = new Configuration().configure();		
		//���е����û��߷���Ҫ��Ч��Ҫ��Ч����ע�ᵽһ��ע������
		//ServiceRegistry service = conf.getStandardServiceRegistryBuilder().build();	
		//service ��ȡ�ĵڶ��ַ�ʽ����������ļ������Ƹ��˵Ļ����������ַ�ʽ
		ServiceRegistry service1 = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		//ͨ�� Ԫ���ݣ����ɹ�����
		sessionfactory = new MetadataSources(service1).buildMetadata().buildSessionFactory();		
		//�����Ự
		Session session = sessionfactory.openSession();		
		//����������
		Transaction trans = session.beginTransaction();
		//ִ�����ݿ�Ĳ���(�������Ĳ���)
		Student student = new Student("��4", "��", 15);
		session.save(student);		
		//�ύ����
		trans.commit();
		//�ر���Դ
		session.close();
		sessionfactory.close();
	}

}
