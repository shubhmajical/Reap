package com.ttnd.reap.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.springframework.stereotype.Component;

@Component
@Entity(name = "employeedetail")
public class Employee {

	@Id @GeneratedValue
	@Column(name = "employeeId")
	private int employeeId;
	
	@Column(name = "employeeName")
	private String employeeName;
	
	@Column(name = "employeeEmailId")
	private String employeeEmailId;
	
	@Column(name = "password")
	private String password;

	@Column(name = "mobileNumber")
	private String mobileNumber;

	@Column(name = "serviceLane")
	private String serviceLine;
	@Column(name = "practice")
	private String practice;

	@Column(name = "role")
	private String role;

	@Column(name = "imageFile")
	private String imageFile;

	@OneToOne(mappedBy = "employee")
	private EarningKitty earningKitty;

	@OneToOne(mappedBy = "employee")
	private GivingKitty givingKitty;
	
		public GivingKitty getGivingKitty() {
		return givingKitty;
	}

	public void setGivingKitty(GivingKitty givingKitty) {
		this.givingKitty = givingKitty;
	}

	public EarningKitty getEarningKitty() {
		return earningKitty;
	}

	public void setEarningKitty(EarningKitty earningKitty) {
		this.earningKitty = earningKitty;
	}

	public String getImageFile() {
		return imageFile;
	}

	public void setImageFile(String imageFile) {
		this.imageFile = imageFile;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String name) {
		this.employeeName = name;
	}

	public String getEmployeeEmailId() {
		return employeeEmailId;
	}

	public void setEmployeeEmailId(String emailId) {
		this.employeeEmailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String pass) {
		this.password = pass;
	}

	public String getServiceLine() {
		return serviceLine;
	}

	public void setServiceLine(String service_Line) {
		this.serviceLine = service_Line;
	}

	public String getPractice() {
		return practice;
	}

	public void setPractice(String practice) {
		this.practice = practice;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}