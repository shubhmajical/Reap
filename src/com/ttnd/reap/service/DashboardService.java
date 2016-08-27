package com.ttnd.reap.service;

import java.util.List;

import com.ttnd.reap.dto.BindDTO;
import com.ttnd.reap.dto.ChangeUserRoleDto;
import com.ttnd.reap.dto.EarningKittyDTO;
import com.ttnd.reap.dto.EmployeeDTO;
import com.ttnd.reap.dto.GivingKittyDTO;
import com.ttnd.reap.dto.KarmaReasonDTO;
import com.ttnd.reap.pojo.Employee;

public interface DashboardService {

	List<EarningKittyDTO> getNewerBoard();

	List<EmployeeDTO> searchNewer(String query,EmployeeDTO employeeDTO);

	GivingKittyDTO getEmployeeGivingKitty(Employee employee);

	EarningKittyDTO getEmployeeEarningKitty(Employee employee);

	BindDTO binddata(EmployeeDTO employee);

	EmployeeDTO fetchEmployees(int employeeId);

	boolean sendKarma(KarmaReasonDTO karmaReasonDTO);

	List<KarmaReasonDTO> getWallOfTheFame();

	boolean changeUserRole(ChangeUserRoleDto changeUserRole);

	boolean revokeKarma(String karmaReason);
}
