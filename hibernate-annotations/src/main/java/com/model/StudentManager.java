package com.model;

import org.hibernate.Session;
import java.util.List;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import jakarta.persistence.TypedQuery;

public class StudentManager 
{
	public String insertData(Student S)
	{
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		String res = "";
		try
		{
			session.getTransaction().begin();
			session.persist(S);
			session.getTransaction().commit();
			res = "Data inserted sucessfully...";
		}
		catch(Exception e)
		{
			session.getTransaction().rollback();
			res = e.getMessage();
		}
		session.close();
		factory.close();
		return res;
	}
	
	public String deleteData(int id)
	{
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		String res = "";
		try
		{
			session.getTransaction().begin();
			Student S=session.find(Student.class, id);
			session.remove(S);
			session.getTransaction().commit();
			res = "Data deleted sucessfully...";
		}
		catch(Exception e)
		{
			session.getTransaction().rollback();
			res = e.getMessage();
		}
		session.close();
		factory.close();
		return res;
	}
	public String updateData(int id,String name)
	{
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		String res = "";
		try
		{
			session.getTransaction().begin();
			Student S=session.find(Student.class, id);
			S.setName(name);
			session.getTransaction().commit();
			res = "Data Updated sucessfully...";
		}
		catch(Exception e)
		{
			session.getTransaction().rollback();
			res = e.getMessage();
		}
		session.close();
		factory.close();
		return res;
	}
	
	public List<Student> readData(int id)
	{
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		List<Student> list = null;
		try
		{
			session.getTransaction().begin();
//			query to use particular data
//			TypedQuery<Student> qry = session.createQuery("SELECT s FROM Student s where s.id=:sid" , Student.class);
//			qry.setParameter("sid", id);
			
//			data retrieve that which we want
			TypedQuery<Student> qry = session.createQuery("SELECT s FROM Student s" , Student.class);
			qry.setFirstResult(0);
			qry.setMaxResults(2);
			list = qry.getResultList();
			session.getTransaction().commit();
		}
		catch(Exception e)
		{
			session.getTransaction().rollback();
		}
		return list;
	}
	public String updatedata(Student s) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		String ack = "";
		try {
			session.getTransaction().begin();
			TypedQuery<Student> qry = session.createQuery("UPDATE Student s set s.name=:n where s.id=:sid");
			qry.setParameter("n", s.getName());
			qry.setParameter("sid", s.getId());
			qry.executeUpdate();
			session.getTransaction().commit();
			ack = "Data updated successfuly...!";
		}catch(Exception e) {
			session.getTransaction().rollback();
			ack = e.getMessage();
		}
		session.close();
		factory.close();
		return ack;
	}
	public String deletedata(int id)
	{
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		String res = "";
		try
		{
			session.getTransaction().begin();
			TypedQuery<Student> qry = session.createQuery("DELETE from Student s where s.id=:sid");
			qry.setParameter("sid", id);
			qry.executeUpdate();
			session.getTransaction().commit();
			res = "Data deleted successfuly...!";
		}catch(Exception e) {
			session.getTransaction().rollback();
			res = e.getMessage();
		}
		session.close();
		factory.close();
		return res;
	}
	public List<Student> read() {
	    SessionFactory factory = new Configuration().configure().buildSessionFactory();
	    Session session = factory.openSession();
	    List<Student> list = null;
	    try {
	      session.getTransaction().begin();
	      TypedQuery<Student> qry = session.createQuery("SELECT s FROM Student s" , Student.class);
	      list = qry.getResultList();
	      
	    } catch (Exception e) {
	      session.getTransaction().rollback();
	      e.getMessage();
	    }
	    
	    return list;
	    
	  }
}
