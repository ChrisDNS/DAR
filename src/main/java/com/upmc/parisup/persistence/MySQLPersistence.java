package com.upmc.parisup.persistence;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class MySQLPersistence {
	private SessionFactory sessionFactory;
	private ServiceRegistry serviceRegistry;

	private MySQLPersistence() {
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

	private static class MySQLPersistenceHolder {
		private static final MySQLPersistence INSTANCE = new MySQLPersistence();
	}
	
	public static MySQLPersistence getInstance() {
		return MySQLPersistenceHolder.INSTANCE;
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