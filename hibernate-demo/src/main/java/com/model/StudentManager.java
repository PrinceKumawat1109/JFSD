package com.model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class StudentManager 
{
	public String insertData(Student S) throws Exception
	{
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = factory.openSession();
		session.getTransaction().begin();
		session.persist(S);
		session.getTransaction().commit();
		session.close();
		factory.close();
		return "Data Inserted Successfully...";
	}
	public String deleteData(int id) throws Exception
	{
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = factory.openSession();
		session.getTransaction().begin();
		Student S = session.find(Student.class, id);
		session.remove(S);
		session.getTransaction().commit();
		session.close();
		factory.close();
		return "Data Deleted Successfully...!";
	}
	public String updateData(int sid, String sname) throws Exception
	{
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = factory.openSession();
		session.getTransaction().begin();
		Student S = session.find(Student.class, sid);
		S.setName(sname);
		session.getTransaction().commit();
		session.close();
		factory.close();
		return "Data Updated Successfully...!";
	}
	public List<Student> readData() throws Exception{
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = factory.openSession();
		session.getTransaction().begin();
		@SuppressWarnings({ "deprecation", "unchecked" })
		List<Student> list = session.createQuery("FROM Student ").getResultList();
		session.getTransaction().commit();
		session.close();
		factory.close();
		return list;
	}
}
