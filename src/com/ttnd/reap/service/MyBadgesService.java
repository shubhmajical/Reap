package com.ttnd.reap.service;

import java.util.List;

import com.ttnd.reap.dto.EmployeeDTO;
import com.ttnd.reap.dto.KarmaReasonDTO;

public interface MyBadgesService {

	List<KarmaReasonDTO> getAllBadges(EmployeeDTO employeeDTO);

	List<KarmaReasonDTO> getSharedBadges(EmployeeDTO attribute);

	List<KarmaReasonDTO> getReceivedBadges(EmployeeDTO attribute);
}
