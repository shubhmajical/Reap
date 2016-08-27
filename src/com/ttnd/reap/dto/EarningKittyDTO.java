package com.ttnd.reap.dto;

public class EarningKittyDTO {

	
	private int employeeId;
	private int gold;
	private int silver;
	private int bronze;
	private int points;
	
	private EmployeeDTO employeeDto;
	
	
	public EmployeeDTO getEmployeeDto() {
		return employeeDto;
	}

	public void setEmployeeDto(EmployeeDTO employeeDto) {
		this.employeeDto = employeeDto;
	}


	public int getPoints() {
		return points;
	}


	public void setPoints(int points) {
		this.points = points;
	}

 


	public int getEmployeeId() {
		return employeeId;
	}


	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}


	public int getGold() {
		return gold;
	}
	public void setGold(int gold){
		this.gold=gold;
	}
	
	public int getSilver() {
		return silver;
	}
	public void setSilver(int silver){
		this.silver=silver;
	}
	
	public int getBronze() {
		return bronze;
	}
	public void setBronze(int bronze){
		this.bronze=bronze;
	}

}

