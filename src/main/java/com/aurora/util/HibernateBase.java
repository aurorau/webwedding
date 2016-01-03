package com.aurora.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateBase {
    private static SessionFactory factory;
    static {
    	
		 // Create configuration instance
		 Configuration configuration = new Configuration();
		 configuration.configure("hibernate.cfg.xml");
		 ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().
		 applySettings(configuration.getProperties()).build(); 

		 // Create session factory instance
		 factory = configuration.buildSessionFactory(serviceRegistry);
    }

    public Session getSession() {
        return factory.openSession();
    }

    // Call this during shutdown
    public static void factoryClose() {
        factory.close();
    }
}
