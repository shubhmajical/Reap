package com.ttnd.reap.dto;

import java.util.ArrayList;
import java.util.List;

public class BindDTO {

	private EmployeeDTO employee;
	private GivingKittyDTO givingKitty;
	private EarningKittyDTO earningKitty;
	private List<KarmaReasonDTO> wallOfthefamedtao=new ArrayList<>();
	private List<EarningKittyDTO> newerBoard=new ArrayList<>();
	
	public List<KarmaReasonDTO> getWallOfthefamedtao() {
		return wallOfthefamedtao;
	}
	public void setWallOfthefamedtao(List<KarmaReasonDTO> wallOfthefamedtao) {
		this.wallOfthefamedtao = wallOfthefamedtao;
	}
	public List<EarningKittyDTO> getNewerBoard() {
		return newerBoard;
	}
	public void setNewerBoard(List<EarningKittyDTO> newerBoard) {
		this.newerBoard = newerBoard;
	}
	public EmployeeDTO getEmployee() {
		return employee;
	}
	public void setEmployee(EmployeeDTO employee) {
		this.employee = employee;
	}
	public GivingKittyDTO getGivingKitty() {
		return givingKitty;
	}
	public void setGivingKitty(GivingKittyDTO givingKitty) {
		this.givingKitty = givingKitty;
	}
	public EarningKittyDTO getEarningKitty() {
		return earningKitty;
	}
	public void setEarningKitty(EarningKittyDTO earningKitty) {
		this.earningKitty = earningKitty;
	}
		
}
