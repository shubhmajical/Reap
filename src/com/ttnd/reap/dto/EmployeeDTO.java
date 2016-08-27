package com.ttnd.reap.dto;

import org.springframework.web.multipart.MultipartFile;

public class EmployeeDTO {

	private int employeeId;
	private String employeeName;
	private String employeeEmailId;
	private String password;
	private String mobileNumber;
	private String serviceLine;
	private String practice;
	private String role;
	private String imagePath;
	private MultipartFile profilePicture;
	private String profilePic;

	public String getProfilePic() {
		return profilePic;
	}

	public void setProfilePic(String profilePic) {
		this.profilePic = profilePic;
	}	
	
	public MultipartFile getProfilePicture() {
		return profilePicture;
	}

	public void setProfilePicture(MultipartFile profilePicture) {
		this.profilePicture = profilePicture;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
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
