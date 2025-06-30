package com.hibernetExample;
import com.hibernetExample.utils.HibernetUtils;
import entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public abstract class HibernetApplication {

	public static void main(String[] args) {
		SpringApplication.run(HibernetApplication.class, args);

		Student student = new Student();
		student.setName("Ashu");
		student.setActive(true);
		student.setCollege("GLA University");
		student.setMobile("9808508760");
		student.setAbout("software engineer");
		SessionFactory sessionFactory = HibernetUtils.getSessionFactory();

		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try{
		transaction = session.beginTransaction();
		session.persist(student);
			System.out.println("student saved..");
		} catch (Exception e) {

			if(transaction!=null){
				transaction.rollback();
			}
			e.printStackTrace();
		}


	}



}
