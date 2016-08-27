package com.ttnd.reap.data.dao;

import com.ttnd.reap.pojo.EarningKitty;
import com.ttnd.reap.pojo.Employee;
import com.ttnd.reap.pojo.GivingKitty;
import com.ttnd.reap.pojo.KarmaReason;

public interface IInsertDAO {

	boolean RegisterUser(Employee emp);

	boolean EnterRecognization(KarmaReason karma_Reason);

	boolean CreateGivingKitty(GivingKitty givingKitty);

	boolean CreateEarningKitty(EarningKitty earningKitty);
}
