package com.ttnd.reap.dto;

public class ChangeUserRoleDto {

	private int selectnewer;

	private String changeRole;

	private EmployeeDTO newer;

	public EmployeeDTO getNewer() {
		return newer;
	}

	public void setNewer(EmployeeDTO newer) {
		this.newer = newer;
	}

	public int getSelectnewer() {
		return selectnewer;
	}

	public void setSelectnewer(int selectnewer) {
		this.selectnewer = selectnewer;
	}

	public String getChangeRole() {
		return changeRole;
	}

	public void setChangeRole(String changeRole) {
		this.changeRole = changeRole;
	}

}
