package DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
	private static HibernateUtils hibernateUtils = null;
	private HibernateUtils() {
		super();
	}
	public static HibernateUtils getInstance() {
		if(hibernateUtils == null) {
			hibernateUtils = new HibernateUtils();
		}
		return hibernateUtils;
	}
	public SessionFactory getSessionFactory() {
		return new  Configuration().configure().buildSessionFactory();
	}
	//thread�̷߳�ʽ�����session���󣬵�ʳ���ύ��ʱ�򣬻��Զ��ر�session����ͬ�ֶ�
	public Session getSession() {
		//��ȡ�͵�ǰ�̰߳󶨵�session����
		return getSessionFactory().getCurrentSession();
	}
}
