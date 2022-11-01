package com.klu;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class StudentManager implements StudentService 
{
	@Autowired
	StudentRepository stu;
	
	@Override
	public Student saveData(Student s) 
	{
		// TODO Auto-generated method stub
		return stu.save(s);
	}

	@Override
	public List<Student> readData() 
	{
		// TODO Auto-generated method stub
		return stu.findAll();
	}

	@Override
	public Student updateData(Student s, Long id) {
		// TODO Auto-generated method stub
		Student st=stu.findById(id).get();
		st.setName(s.getName());
		st.setAmt(s.getAmt());
		return stu.save(st);
	}

	@Override
	public void deleteData(Long id) 
	{
		// TODO Auto-generated method stub
		stu.deleteById(id);
	}
	
}