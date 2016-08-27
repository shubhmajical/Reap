package com.ttnd.reap.data.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {

	private static SessionFactory sessionFactory=null;
	private static Configuration configuration=null;
	private HibernateUtils(){}
	
	@SuppressWarnings("deprecation")
	public static SessionFactory getInstance(){
		if(sessionFactory==null){
		 configuration = new Configuration().configure();
		 sessionFactory=configuration.buildSessionFactory();
			return sessionFactory;
		}
		return sessionFactory;
	}
}
