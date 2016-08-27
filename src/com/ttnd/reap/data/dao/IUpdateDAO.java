package com.ttnd.reap.data.dao;

import com.ttnd.reap.pojo.EarningKitty;
import com.ttnd.reap.pojo.Employee;
import com.ttnd.reap.pojo.GivingKitty;
import com.ttnd.reap.pojo.KarmaReason;

public interface IUpdateDAO {

	boolean updateEarningKitty(EarningKitty earningKitty);

	boolean updateGivingKitty(GivingKitty givingKitty);
	
	boolean updateEmployee(Employee employee);

	boolean updateKarmaReason(KarmaReason karmaReason);
}
