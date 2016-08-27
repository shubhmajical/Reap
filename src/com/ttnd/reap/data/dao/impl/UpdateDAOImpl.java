package com.ttnd.reap.data.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.ttnd.reap.data.dao.IUpdateDAO;
import com.ttnd.reap.data.util.HibernateUtils;
import com.ttnd.reap.pojo.EarningKitty;
import com.ttnd.reap.pojo.Employee;
import com.ttnd.reap.pojo.GivingKitty;
import com.ttnd.reap.pojo.KarmaReason;

@Repository
public class UpdateDAOImpl implements IUpdateDAO {

	@Override
	public boolean updateEmployee(Employee employee) {
		Session session = null;
		Transaction transaction = null;
		try {
			SessionFactory sessionFactory = HibernateUtils.getInstance();
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.update(employee);
			transaction.commit();
			return true;
		} catch (Exception e) {
			transaction.rollback();
			return false;
		} finally {
			session.close();
		}
	}

	@Override
	public boolean updateEarningKitty(EarningKitty earningKitty) {

		Session session = null;
		Transaction transaction = null;
		try {
			SessionFactory sessionFactory = HibernateUtils.getInstance();
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.update(earningKitty);
			transaction.commit();
			return true;
		} catch (Exception e) {
			transaction.rollback();
			return false;
		} finally {
			session.close();
		}
	}

	@Override
	public boolean updateGivingKitty(GivingKitty givingKitty) {

		Session session = null;
		Transaction transaction = null;
		try {
			SessionFactory sessionFactory = HibernateUtils.getInstance();
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.update(givingKitty);
			transaction.commit();
			return true;
		} catch (Exception e) {
			transaction.rollback();
			return false;
		} finally {
			session.close();
		}
	}

	@Override
	public boolean updateKarmaReason(KarmaReason karmaReason) {
		Session session = null;
		Transaction transaction = null;
		try {
			SessionFactory sessionFactory = HibernateUtils.getInstance();
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.update(karmaReason);
			transaction.commit();
			return true;
		} catch (Exception e) {
			transaction.rollback();
			return false;
		} finally {
			session.close();
		}
	}

}
