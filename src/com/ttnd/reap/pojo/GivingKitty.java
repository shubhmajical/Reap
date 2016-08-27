package com.ttnd.reap.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity(name = "givingkitty")
public class GivingKitty {

	@Id
	@GeneratedValue
	@Column(name = "givingkittyId")
	private int employeeId;

	@Column(name = "gold")
	private int gold;

	@Column(name = "silver")
	private int silver;

	@Column(name = "bronze")
	private int bronze;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "employeeId")
	private Employee employee;

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int id) {
		this.employeeId = id;
	}

	public int getGold() {
		return gold;
	}

	public void setGold(int gold) {
		this.gold = gold;
	}

	public int getSilver() {
		return silver;
	}

	public void setSilver(int silver) {
		this.silver = silver;
	}

	public int getBronze() {
		return bronze;
	}

	public void setBronze(int bronze) {
		this.bronze = bronze;
	}

}
