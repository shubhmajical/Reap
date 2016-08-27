package com.ttnd.reap.service;

import com.ttnd.reap.dto.EmployeeDTO;
import com.ttnd.reap.dto.LoginDTO;

public interface UserService {

	boolean registerUser(EmployeeDTO employeeDto);

	EmployeeDTO authenticateUser(LoginDTO loginCredentials);
}
