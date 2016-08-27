package com.ttnd.reap.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ttnd.reap.data.dao.IFetchDAO;
import com.ttnd.reap.dto.EmployeeDTO;
import com.ttnd.reap.dto.KarmaReasonDTO;
import com.ttnd.reap.pojo.Employee;
import com.ttnd.reap.pojo.KarmaReason;
import com.ttnd.reap.service.DataConvertService;
import com.ttnd.reap.service.MyBadgesService;

@Service
public  class MyBadgesServiceImpl implements MyBadgesService {

	@Autowired 
	private DataConvertService dataConvertService;
	
	@Autowired
	private IFetchDAO fetchBadgeData;
	
	@Override
	public List<KarmaReasonDTO> getAllBadges(EmployeeDTO employeeDTO){
		Employee employee=dataConvertService.convertToEmployee(employeeDTO);
		List<KarmaReason> list=fetchBadgeData.getKarmaOfEmployee(employee);
		List<KarmaReasonDTO> DtoList=new ArrayList<>(); 
		for(int count=0;count<list.size();count++){
			DtoList.add(dataConvertService.convertToKarmaReasonDTO(list.get(count)));
		}
		return DtoList;
	}

	@Override
	public List<KarmaReasonDTO> getSharedBadges(EmployeeDTO employeeDTO) {
		Employee employee=dataConvertService.convertToEmployee(employeeDTO);
		List<KarmaReason> list=fetchBadgeData.getSharedKarmaOfEmployee(employee);
		List<KarmaReasonDTO> DtoList=new ArrayList<>(); 
		for(int count=0;count<list.size();count++){
			DtoList.add(dataConvertService.convertToKarmaReasonDTO(list.get(count)));
		}
		return DtoList;
	
	}

	@Override
	public List<KarmaReasonDTO> getReceivedBadges(EmployeeDTO employeeDTO) {
		Employee employee=dataConvertService.convertToEmployee(employeeDTO);
		List<KarmaReason> list=fetchBadgeData.getReceivedKarmaOfEmployee(employee);
		List<KarmaReasonDTO> DtoList=new ArrayList<>(); 
		for(int count=0;count<list.size();count++){
			DtoList.add(dataConvertService.convertToKarmaReasonDTO(list.get(count)));
		}
		return DtoList;
	
	}



}
