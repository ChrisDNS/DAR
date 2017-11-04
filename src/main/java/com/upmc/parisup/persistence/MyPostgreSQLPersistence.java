package com.upmc.parisup.persistence;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class MyPostgreSQLPersistence {
	private SessionFactory sessionFactory;
	private ServiceRegistry serviceRegistry;

	private MyPostgreSQLPersistence() {
		try {
			Configuration configuration = new Configuration();
			configuration.configure();
			serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
			sessionFactory = configuration.buildSessionFactory(serviceRegistry);
			
		} catch (Throwable ex) {
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	private static class MyPostgreSQLPersistenceHolder {
		private static final MyPostgreSQLPersistence INSTANCE = new MyPostgreSQLPersistence();
	}
	
	public static MyPostgreSQLPersistence getInstance() {
		return MyPostgreSQLPersistenceHolder.INSTANCE;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public ServiceRegistry getServiceRegistry() {
		return serviceRegistry;
	}

	public void closeSession() {
		sessionFactory.close();
	}
}