package com.suntossh.data;

import java.io.File;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.suntossh.data.entities.User;

public class HibernateUtil {

	private static SessionFactory sessionFactory = buildSessionFactory();

	private static SessionFactory buildSessionFactory() {
		try {
			Configuration configuration = new Configuration();
			configuration.configure("hibernate.cfg.xml");
			return configuration
					.buildSessionFactory(new StandardServiceRegistryBuilder()
							.applySettings(configuration.getProperties())
							.build());
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(
					"Something went wrong while building Session Factory");
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

}