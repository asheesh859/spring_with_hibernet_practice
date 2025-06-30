package com.hibernetExample.utils;

import entity.Student;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Properties;


    public class HibernetUtils {

        private static SessionFactory sessionFactory;
        static {
            try {
    if(sessionFactory==null){

        Configuration configuration = new Configuration();

        // Load from application.properties
        Properties properties = new Properties();
        properties.load(HibernetUtils.class.getClassLoader().getResourceAsStream("application.properties"));
        configuration.setProperties(properties);

        // Add your entity classes here
        configuration.addAnnotatedClass(Student.class); // replace with your actual entity class

        // Now build the SessionFactory
        sessionFactory = configuration.buildSessionFactory();

    }


            }catch (Exception e){
                   throw new RuntimeException("Error in creating session factory" + e.getMessage());
            }
        }

        public static SessionFactory getSessionFactory(){
            return sessionFactory;
        }
    }
