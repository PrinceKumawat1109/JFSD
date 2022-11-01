package com.prince.model;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.prince.entity.Marks;
import com.prince.entity.Student;


public class StudentDAO 
{
	Connection con=null;
	PreparedStatement ps=null;
	String url = "jdbc:mysql://localhost:3306/klu";
	String dbuser = "root";
	String dbpwd = "1109";
	
	public List<Student> readStudent()
	{
		try
		{
			con = DriverManager.getConnection(url, dbuser, dbpwd);
			ps = con.prepareStatement("SELECT * FROM student");
			ResultSet rs = ps.executeQuery();
			List<Student> slist = new ArrayList<Student>();
			while(rs.next())
			{
				Student S=new Student();
				S.setStudent_id(rs.getInt(1));
				S.setStudent_name(rs.getString(2));
				slist.add(S);
			}
			return slist;
		}catch(Exception e)
		{
			return null;
		}
	}
	
	public List<Marks> readMarks()
	{
		try
		{
			con = DriverManager.getConnection(url, dbuser, dbpwd);
			ps = con.prepareStatement("SELECT * FROM MARKS");
			ResultSet rs = ps.executeQuery();
			List<Marks> mlist = new ArrayList<Marks>();
			while(rs.next())
			{
				Marks M=new Marks();
				M.setStudent_id(rs.getInt(1));
				M.setCgpa(rs.getDouble(2));
				mlist.add(M);
			}
			return mlist;
		}catch(Exception e)
		{
			return null;
		}
	}
}
