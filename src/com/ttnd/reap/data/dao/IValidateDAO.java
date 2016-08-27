package com.ttnd.reap.data.dao;

import com.ttnd.reap.dto.LoginDTO;
import com.ttnd.reap.pojo.Employee;

public interface IValidateDAO {

	public Employee ValidateUser(LoginDTO loginCredentials);
}
