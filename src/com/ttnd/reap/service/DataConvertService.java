package com.ttnd.reap.service;

import com.ttnd.reap.dto.EarningKittyDTO;
import com.ttnd.reap.dto.EmployeeDTO;
import com.ttnd.reap.dto.GivingKittyDTO;
import com.ttnd.reap.dto.KarmaReasonDTO;
import com.ttnd.reap.pojo.EarningKitty;
import com.ttnd.reap.pojo.Employee;
import com.ttnd.reap.pojo.GivingKitty;
import com.ttnd.reap.pojo.KarmaReason;

public interface DataConvertService {

	EarningKittyDTO convertToEarningKittyDto(EarningKitty earningKitty);

	EmployeeDTO convertToEmployeeDto(Employee employee);

	GivingKittyDTO convertTOGivingKittyDto(GivingKitty givingKitty);

	EarningKitty convertToEarningKitty(EarningKittyDTO earningKittyDTO);

	Employee convertToEmployee(EmployeeDTO employeeDTO);

	GivingKitty convertTOGivingKitty(GivingKittyDTO givingKittyDTO);

	KarmaReasonDTO convertToKarmaReasonDTO(KarmaReason karmaReason);

	KarmaReason convertToKarmaReason(KarmaReasonDTO karmaReasonDTO);
	

}
