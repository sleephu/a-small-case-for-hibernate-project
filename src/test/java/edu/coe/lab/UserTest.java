package edu.coe.lab;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import edu.coe.lab.domain.Blog;
import edu.coe.lab.domain.User;

public class UserTest {

	public static void main(String args[]) {
		Configuration config = new Configuration().configure("hibernate.cfg.xml");
		SessionFactory sf = config.buildSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
//		User user = new User();
//		user.setUsername("Hechen2");
//		user.setPassword("Gao2");
//		
//		UserDetail detail = new UserDetail();
//		detail.setDetail("Some detail2");
//		
//		user.setUserDetail(detail);
//		detail.setUser(user);
//		
//		session.save(user);
//		
//		session.getTransaction().commit();
		
		User user = (User)session.get(User.class, 1);
		session.delete(user);
		session.getTransaction().commit();
		session.close();
		sf.close();
	}
	
}
