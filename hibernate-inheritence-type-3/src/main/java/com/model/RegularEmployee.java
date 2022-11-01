package com.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.*;

@Entity
@Table(name="regular")
@PrimaryKeyJoinColumn(name="id")
public class RegularEmployee extends Employee{
	private double salary;
	private double bonus;
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public double getBonus() {
		return bonus;
	}
	public void setBonus(double bonus) {
		this.bonus = bonus;
	}

}
