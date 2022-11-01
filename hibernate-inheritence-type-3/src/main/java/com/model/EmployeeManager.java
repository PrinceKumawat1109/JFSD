package com.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class EmployeeManager {

	public  String insertEmployee(Employee e) {
		String ack = "";
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		try {
			session.getTransaction().begin();
			session.persist(e);
			session.getTransaction().commit();
			ack = "Data inserted for Employee...";

		} catch (Exception e2) {
			session.getTransaction().rollback();
			ack = e2.getMessage();
		}
		session.close();
		factory.close();
		return ack;
	}
	public  String insertRegularEmployee(RegularEmployee e) {
		String ack = "";
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		try {
			session.getTransaction().begin();
			session.persist(e);
			session.getTransaction().commit();
			ack = "Data inserted for Regular Employee...";

		} catch (Exception e2) {
			session.getTransaction().rollback();
			ack = e2.getMessage();
		}
		session.close();
		factory.close();
		return ack;
	}
	
	public  String insertContractEmployee(ContractEmployee e) {
		String ack = "";
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		try {
			session.getTransaction().begin();
			session.persist(e);
			session.getTransaction().commit();
			ack = "Data inserted for Contract Employee...";

		} catch (Exception e2) {
			session.getTransaction().rollback();
			ack = e2.getMessage();
		}
		session.close();
		factory.close();
		return ack;
	}

}
