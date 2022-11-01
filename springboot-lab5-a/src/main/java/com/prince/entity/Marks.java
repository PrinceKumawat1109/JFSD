package com.prince.entity;

public class Marks 
{
	private int student_id;
	private double cgpa;
	public int getStudent_id() {
		return student_id;
	}
	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}
	public double getCgpa() {
		return cgpa;
	}
	public void setCgpa(double cgpa) {
		this.cgpa = cgpa;
	}
	@Override
	public String toString() {
		return "Marks [student_id=" + student_id + ", cgpa=" + cgpa + "]";
	}
}
