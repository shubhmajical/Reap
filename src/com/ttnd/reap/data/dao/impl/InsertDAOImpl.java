package com.ttnd.reap.data.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.ttnd.reap.data.dao.IInsertDAO;
import com.ttnd.reap.data.util.HibernateUtils;
import com.ttnd.reap.pojo.EarningKitty;
import com.ttnd.reap.pojo.Employee;
import com.ttnd.reap.pojo.GivingKitty;
import com.ttnd.reap.pojo.KarmaReason;

@Repository
public class InsertDAOImpl implements IInsertDAO {

	private static Session session = null;
	private static Transaction transaction = null;

	@Override
	public boolean RegisterUser(Employee emp) {

		boolean status = true;
		session = null;
		transaction = null;
		try {
			SessionFactory sessionFactory = HibernateUtils.getInstance();
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.save(emp);
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
		} finally {
			session.close();
			status = false;
		}
		return status;
	}

	@Override
	public boolean EnterRecognization(KarmaReason karma_Reason) {

		session = null;
		transaction = null;
		try {
			SessionFactory sessionFactory = HibernateUtils.getInstance();
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.save(karma_Reason);
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
	public boolean CreateGivingKitty(GivingKitty givingKitty) {
		boolean status = true;
		session = null;
		transaction = null;
		try {
			SessionFactory sessionFactory = HibernateUtils.getInstance();
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.save(givingKitty);
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			status = false;
		} finally {
			session.close();
		}
		return status;
	}

	@Override
	public boolean CreateEarningKitty(EarningKitty earningKitty) {
		boolean status = true;
		session = null;
		transaction = null;
		try {
			SessionFactory sessionFactory = HibernateUtils.getInstance();
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.save(earningKitty);
			System.out.println("dcsdf");
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			status = false;
		} finally {
			session.close();
		}
		return status;
	}

}
