package com.ttnd.reap.data.dao;

import java.util.List;

import com.ttnd.reap.pojo.EarningKitty;
import com.ttnd.reap.pojo.Employee;
import com.ttnd.reap.pojo.GivingKitty;
import com.ttnd.reap.pojo.KarmaReason;

public interface IFetchDAO {

	Employee FetchEmployees(int employeeId);

	GivingKitty getGivingKitty(Employee employee);

	EarningKitty getEarningKitty(Employee employee);

	List<KarmaReason> getWallOfFame();

	List<Employee> FetchNewerlist(String query);

	List<EarningKitty> getNewerBoard();

	List<KarmaReason> getSharedBadges(int employeeId);

	List<KarmaReason> getReceivedBadges(int employeeId);

	List<KarmaReason> getKarmaOfEmployee(Employee employeeId);

	List<KarmaReason> getSharedKarmaOfEmployee(Employee employee);

	List<KarmaReason> getReceivedKarmaOfEmployee(Employee employee);
}
