/*
package com.hospital.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.hospital.model.Doctor;
import com.hospital.model.Patient;

import java.util.Properties;

public class HibernateUtil {

    private static SessionFactory sessionFactory;

    static {
        try {
            // Setting Hibernate properties programmatically
            Properties properties = new Properties();
            properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
            properties.put("hibernate.hbm2ddl.auto", "update");
            
            properties.put("hibernate.show_sql", "true");
            properties.put("hibernate.format_sql", "true");
            properties.put("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");
            properties.put("hibernate.connection.url", "jdbc:mysql://localhost:3306/hospital1");
            properties.put("hibernate.connection.username", "root");
            properties.put("hibernate.connection.password", "Harsha@1810");
          

            // Configure Hibernate
            Configuration configuration = new Configuration();
            configuration.setProperties(properties);

            // Add annotated entity classes
            configuration.addAnnotatedClass(Doctor.class);
            configuration.addAnnotatedClass(Patient.class);

            // Build ServiceRegistry and SessionFactory
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties())
                    .build();

            sessionFactory = configuration.buildSessionFactory(serviceRegistry);

        } catch (Exception e) {
            e.printStackTrace();
            throw new ExceptionInInitializerError("SessionFactory initialization failed!");
        }
    }

    // Method to get Session object
    public static Session getSession() {
        return sessionFactory.openSession();
    }

    // Method to shut down SessionFactory
    public static void shutdown() {
        if (sessionFactory != null) {
            sessionFactory.close();
        }
    }
}
*/

package com.hospital.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.hospital.model.Doctor;
import com.hospital.model.Patient;

import java.util.Properties;

public class HibernateUtil {

    private static SessionFactory sessionFactory;

    static {
        try {
            // Setting Hibernate properties programmatically
            Properties properties = new Properties();
            properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
            properties.put("hibernate.hbm2ddl.auto", "update");
            properties.put("hibernate.show_sql", "false"); // Disable SQL logging
            properties.put("hibernate.format_sql", "false"); // Disable formatted SQL logging
            properties.put("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");
            properties.put("hibernate.connection.url", "jdbc:mysql://localhost:3306/hospital1");
            properties.put("hibernate.connection.username", "root"); // Provide username
            properties.put("hibernate.connection.password", "Harsha@1810"); // Provide password

            // Configure Hibernate
            Configuration configuration = new Configuration();
            configuration.setProperties(properties);

            // Add annotated entity classes
            configuration.addAnnotatedClass(Doctor.class);
            configuration.addAnnotatedClass(Patient.class);

            // Build ServiceRegistry and SessionFactory
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties())
                    .build();

            sessionFactory = configuration.buildSessionFactory(serviceRegistry);

        } catch (Exception e) {
            e.printStackTrace();
            throw new ExceptionInInitializerError("SessionFactory initialization failed!");
        }
    }

    // Method to get Session object
    public static Session getSession() {
        return sessionFactory.openSession();
    }

    // Method to shut down SessionFactory
    public static void shutdown() {
        if (sessionFactory != null) {
            sessionFactory.close();
        }
    }

	public static Object getSessionFactory() {
		// TODO Auto-generated method stub
		return null;
	}
}

