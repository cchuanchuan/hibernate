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
	//thread线程方式管理的session对象，当食物提交的时候，会自动关闭session，不同手动
	public Session getSession() {
		//获取和当前线程绑定的session对象
		return getSessionFactory().getCurrentSession();
	}
}
