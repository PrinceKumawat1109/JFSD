package com.model;

import jakarta.persistence.*;

@Entity
@Table (name="contract")
@PrimaryKeyJoinColumn(name="id")
public class ContractEmployee extends Employee{
	private double payperhour;
	private String contractduration;
	public double getPayperhour() {
		return payperhour;
	}
	public void setPayperhour(double payperhour) {
		this.payperhour = payperhour;
	}
	public String getContractduration() {
		return contractduration;
	}
	public void setContractduration(String contractduration) {
		this.contractduration = contractduration;
	}

}
