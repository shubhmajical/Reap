package com.ttnd.reap.services.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;

import org.springframework.stereotype.Service;

import com.ttnd.reap.dto.EarningKittyDTO;
import com.ttnd.reap.dto.EmployeeDTO;
import com.ttnd.reap.dto.GivingKittyDTO;
import com.ttnd.reap.dto.KarmaReasonDTO;
import com.ttnd.reap.pojo.EarningKitty;
import com.ttnd.reap.pojo.Employee;
import com.ttnd.reap.pojo.GivingKitty;
import com.ttnd.reap.pojo.KarmaReason;
import com.ttnd.reap.service.DataConvertService;

@Service
public class DataConvertServiceImpl implements DataConvertService{

	@Override
	public EarningKittyDTO convertToEarningKittyDto(EarningKitty earningKitty){
		
		EarningKittyDTO earningKittyDto=new EarningKittyDTO();
		earningKittyDto.setBronze(earningKitty.getBronze());
		earningKittyDto.setGold(earningKitty.getGold());
		earningKittyDto.setSilver(earningKitty.getSilver());
		earningKittyDto.setPoints(earningKitty.getPoints());
		earningKittyDto.setEmployeeDto(convertToEmployeeDto(earningKitty.getEmployee()));
		
		return earningKittyDto;
	}
	
	@Override
	public EmployeeDTO convertToEmployeeDto(Employee employee){
			
	//		try{
				
				EmployeeDTO employeeDto=new EmployeeDTO();

			employeeDto.setEmployeeId(employee.getEmployeeId());
			employeeDto.setEmployeeEmailId(employee.getEmployeeEmailId());
			employeeDto.setEmployeeName(employee.getEmployeeName());
			employeeDto.setMobileNumber(employee.getMobileNumber());
			employeeDto.setPractice(employee.getPractice());
			employeeDto.setRole(employee.getRole());
			employeeDto.setServiceLine(employee.getServiceLine());
			employeeDto.setPassword(employee.getPassword());
			employeeDto.setImagePath(employee.getImageFile());

			/*Path path = Paths.get(employee.getImageFile());
			byte[] imgArr = Files.readAllBytes(path);

			employeeDto.setProfilePic(new Base64().encodeToString(imgArr));

			*/			
			return employeeDto;
			/*
			}catch(IOException e){
				e.printStackTrace();
				return null;
			}*/
		}
	
	@Override
	public GivingKittyDTO convertTOGivingKittyDto(GivingKitty givingKitty){
		
		GivingKittyDTO givingKittyDTO =new GivingKittyDTO();
		givingKittyDTO.setBronze(givingKitty.getBronze());
		givingKittyDTO.setEmployeeId(givingKitty.getEmployeeId());
		givingKittyDTO.setGold(givingKitty.getGold());
		givingKittyDTO.setSilver(givingKitty.getSilver());
		givingKittyDTO.setEmployeeDTO(convertToEmployeeDto(givingKitty.getEmployee()));
		
		return givingKittyDTO;
	}

	@Override
	public EarningKitty convertToEarningKitty(EarningKittyDTO earningKittyDTO){
		
		EarningKitty earningKitty=new EarningKitty();
		earningKitty.setBronze(earningKittyDTO.getBronze());
		earningKitty.setGold(earningKittyDTO.getGold());
		earningKitty.setSilver(earningKittyDTO.getSilver());
		earningKitty.setPoints(earningKittyDTO.getPoints());
		earningKitty.setEmployee(convertToEmployee(earningKittyDTO.getEmployeeDto()));
		
		return earningKitty;
	}
	
	@Override
	public Employee convertToEmployee(EmployeeDTO employeeDTO){
			
			Employee employee=new Employee();
			employee.setEmployeeId(employeeDTO.getEmployeeId());
			employee.setEmployeeEmailId(employeeDTO.getEmployeeEmailId());
			employee.setEmployeeName(employeeDTO.getEmployeeName());
			employee.setMobileNumber(employeeDTO.getMobileNumber());
			employee.setPractice(employeeDTO.getPractice());
			employee.setRole(employeeDTO.getRole());
			employee.setServiceLine(employeeDTO.getServiceLine());
			employee.setPassword(employeeDTO.getPassword());
			employee.setImageFile(employeeDTO.getImagePath());
			
			return employee;
		}
	
	
	@Override
	public GivingKitty convertTOGivingKitty(GivingKittyDTO givingKittyDTO){
		
		GivingKitty givingKitty =new GivingKitty();
		givingKitty.setBronze(givingKittyDTO.getBronze());
		givingKitty.setEmployeeId(givingKittyDTO.getEmployeeId());
		givingKitty.setGold(givingKittyDTO.getGold());
		givingKitty.setSilver(givingKittyDTO.getSilver());
		givingKitty.setEmployee(convertToEmployee(givingKittyDTO.getEmployeeDTO()));
		
		return givingKitty;
	}

	@Override
	public KarmaReasonDTO convertToKarmaReasonDTO(KarmaReason karmaReason){
		KarmaReasonDTO karmaReasonDTO=new KarmaReasonDTO();
		karmaReasonDTO.setBadgeReceived(karmaReason.getBadgeReceived());
		karmaReasonDTO.setDateTime(karmaReason.getDateTime());
		karmaReasonDTO.setId(karmaReason.getId());
		karmaReasonDTO.setKarma(karmaReason.getKarma());
		karmaReasonDTO.setReceiverId(convertToEmployeeDto(karmaReason.getReceiverId()));
		karmaReasonDTO.setRevokedReason(karmaReason.getRevokedReason());
		karmaReasonDTO.setStatus(karmaReason.isStatus());
		karmaReasonDTO.setSenderId(convertToEmployeeDto(karmaReason.getSenderId()));
		karmaReasonDTO.setReason(karmaReason.getReason());
		
		return karmaReasonDTO;	
	}
	
	@Override
	public KarmaReason convertToKarmaReason(KarmaReasonDTO karmaReasonDTO){
		KarmaReason karmaReason=new KarmaReason();
		karmaReason.setDateTime(new Date());
		karmaReason.setBadgeReceived(karmaReasonDTO.getBadgeReceived());
		karmaReason.setKarma(karmaReasonDTO.getKarma());
		karmaReason.setReason(karmaReasonDTO.getReason());
		karmaReason.setReceiverId(convertToEmployee(karmaReasonDTO.getReceiverId()));
		karmaReason.setSenderId(convertToEmployee(karmaReasonDTO.getSenderId()));
		karmaReason.setStatus(true);
		
		return karmaReason;
		
	}
}
