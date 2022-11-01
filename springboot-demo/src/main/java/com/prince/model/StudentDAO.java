package com.prince.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.prince.entity.Student;

public class StudentDAO 
{
	Connection con = null;
	PreparedStatement ps = null;
	String url = "jdbc:mysql://localhost:3306/klu";
	String dbuser = "root";
	String dbpwd = "1109";
	public String insertData(Student S)
	{
		try 
		{
			con = DriverManager.getConnection(url, dbuser, dbpwd);
			ps = con.prepareStatement("insert into student values(?,?)");
			ps.setInt(1, S.getId());
			ps.setString(2, S.getName());
			ps.execute();
			return "Data inserted successfully....!";
		}catch (Exception e)
		{
			return e.getMessage();
		}
	}
	
	public Student getById(int id)
	{
		try 
		{
			con = DriverManager.getConnection(url, dbuser, dbpwd);
			ps = con.prepareStatement("select * from student where id=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			Student S = new Student();
			if(rs.next())
			{
				S.setId(rs.getInt(1));
				S.setName(rs.getString(2));
			}
			return S;
		}catch(Exception e) 
		{
			return null;
		}
	}
	
	
	public List<String> readData()
	{
		try 
		{
			con = DriverManager.getConnection(url, dbuser, dbpwd);
			ps = con.prepareStatement("select * from student");
			ResultSet rs = ps.executeQuery();
			List<String> list = new ArrayList<String>();
			while(rs.next())
			{
				Student S = new Student();
				S.setId(rs.getInt(1));
				S.setName(rs.getString(2));
				list.add(toJSONString(S));
			}
			return list;
		}catch(Exception e) 
		{
			return null;
		}
	}
	
	public String updateData(Student S)
	{
		try 
		{
			con = DriverManager.getConnection(url, dbuser, dbpwd);
			ps = con.prepareStatement("update student set name=? where id=?");
		      ps.setString(1, S.getName());
		      ps.setInt(2, S.getId());
		      ps.execute();
		      return "Data updated successfully...";
		    }catch (Exception e) 
		    {
		      return e.getMessage();
		    }
	}
	
	
	public String deleteData(int id)
	  {
	    try
	    {
	      con = DriverManager.getConnection(url, dbuser, dbpwd);
	      ps = con.prepareStatement("delete from student where id=?");
	      ps.setInt(1, id);
	      ps.execute();
	      return "Data deleted successfully...";
	    }catch (Exception e) 
	    {
	      return e.getMessage();
	    }
	  }
	public String toJSONString(Student S)
	{
		GsonBuilder gb=new GsonBuilder();
		Gson gson = gb.create();
		return gson.toJson(S);
	}
}
