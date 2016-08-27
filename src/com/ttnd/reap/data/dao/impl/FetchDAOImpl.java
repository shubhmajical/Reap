package com.ttnd.reap.data.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.ttnd.reap.data.dao.IFetchDAO;
import com.ttnd.reap.data.util.HibernateUtils;
import com.ttnd.reap.pojo.EarningKitty;
import com.ttnd.reap.pojo.Employee;
import com.ttnd.reap.pojo.GivingKitty;
import com.ttnd.reap.pojo.KarmaReason;

@Repository
public class FetchDAOImpl implements IFetchDAO {

	@Override
	public Employee FetchEmployees(int employeeId) {

		Session  session = null;
		Transaction transaction = null;
		try {
			SessionFactory sessionFactory = HibernateUtils.getInstance();
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			Criteria criteria = session.createCriteria(Employee.class).add(Restrictions.eq("employeeId", employeeId));
			Employee employee_Detail = new Employee();
			employee_Detail = (Employee) criteria.uniqueResult();
			transaction.commit();
			return employee_Detail;
		} catch (Exception e) {
			transaction.rollback();
			throw e;
		} finally {
			session.close();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> FetchNewerlist(String query) {
		Session  session = null;
		Transaction transaction = null;
		List<Employee> employees = new ArrayList<>();
		try {
			SessionFactory sessionFactory = HibernateUtils.getInstance();
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();

			Criteria criteria = session.createCriteria(Employee.class)
					.add(Restrictions.like("employeeName", "%" + query + "%"));
			employees = criteria.list();
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
		} finally {
			session.close();
		}
		return employees;
	}

	@Override
	public GivingKitty getGivingKitty(Employee employee) {

		Session session = null;
		Transaction transaction = null;
		try {
			SessionFactory sessionFactory = HibernateUtils.getInstance();
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			Criteria criteria = session.createCriteria(GivingKitty.class).add(Restrictions.eq("employee", employee));
			GivingKitty giving_Kitty = new GivingKitty();
			giving_Kitty = (GivingKitty) criteria.uniqueResult();
			transaction.commit();
			return giving_Kitty;
		} catch (Exception e) {
			transaction.rollback();
			throw e;
		} finally {
			session.close();
		}
	}

	@Override
	public EarningKitty getEarningKitty(Employee employee) {

		Session  session = null;
		Transaction transaction = null;
		try {
			SessionFactory sessionFactory = HibernateUtils.getInstance();
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			Criteria criteria = session.createCriteria(EarningKitty.class).add(Restrictions.eq("employee", employee));
			EarningKitty earning_Kitty=new EarningKitty();
			earning_Kitty = (EarningKitty) criteria.uniqueResult();
			transaction.commit();
			return earning_Kitty;
		} catch (Exception e) {
			transaction.rollback();
			return null;
		} finally {
			session.close();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<KarmaReason> getWallOfFame() {
		List<KarmaReason> karma_Reason = null;

		Session  session = null;
		Transaction transaction = null;
		try {
			SessionFactory sessionFactory = HibernateUtils.getInstance();
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			Criteria criteria = session.createCriteria(KarmaReason.class).addOrder(Order.desc("dateTime"));
			karma_Reason = criteria.list();
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
		} finally {
			session.close();
		}
		return karma_Reason;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<KarmaReason> getKarmaOfEmployee(Employee employeeId) {
		List<KarmaReason> karma_Reason = null;
		Session session = null;
		Transaction transaction = null;
		try {
			SessionFactory sessionFactory = HibernateUtils.getInstance();
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			Criteria criteria = session.createCriteria(KarmaReason.class).addOrder(Order.desc("dateTime"));

			Criterion criterion = Restrictions.eq("receiverId", employeeId);
			Criterion criterion2 = Restrictions.eq("senderId", employeeId);

			Disjunction disjunction = Restrictions.disjunction();
			disjunction.add(criterion);
			disjunction.add(criterion2);

			criteria.add(disjunction);

			karma_Reason = criteria.list();
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
		} finally {
			session.close();
		}

		return karma_Reason;
	}
	
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<KarmaReason> getSharedBadges(int employeeId) {
		Session session = null;
		Transaction transaction = null;
		try {
			SessionFactory sessionFactory = HibernateUtils.getInstance();
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			Criteria criteria = session.createCriteria(KarmaReason.class)
					.addOrder(Order.desc("dateTime"))
					.add(Restrictions.eq("senderId", employeeId));
												
			List<KarmaReason> karma_Reason = criteria.list();
			transaction.commit();
			return karma_Reason;
		} catch (Exception e) {
			transaction.rollback();
			return null;
		} finally {
			session.close();
		}
	}

	
	@SuppressWarnings("unchecked")
	@Override
	public List<KarmaReason> getReceivedBadges(int employeeId) {
		Session session = null;
		Transaction transaction = null;
		try {
			SessionFactory sessionFactory = HibernateUtils.getInstance();
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			Criteria criteria = session.createCriteria(KarmaReason.class)
					.addOrder(Order.desc("dateTime"))
					.add(Restrictions.eq("receiverId", employeeId));
												
			List<KarmaReason> karma_Reason = criteria.list();
			transaction.commit();
			return karma_Reason;
		} catch (Exception e) {
			transaction.rollback();
			return null;
		} finally {
			session.close();
		}
	}

	
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<EarningKitty> getNewerBoard() {
		
		Session session = null;
		Transaction transaction = null;
		try {
			SessionFactory sessionFactory = HibernateUtils.getInstance();
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			Criteria criteria = session.createCriteria(EarningKitty.class).addOrder(Order.desc("points"))
					.setMaxResults(5);
			List<EarningKitty> earningKitties = new ArrayList<>();
			earningKitties = criteria.list();
			transaction.commit();
			return earningKitties;
		} catch (Exception e) {
			transaction.rollback();
			return null;
		} finally {
			session.close();
		}
	}

	@Override
	public List<KarmaReason> getSharedKarmaOfEmployee(Employee employee) {
		Session session = null;
		Transaction transaction = null;
		try {
			SessionFactory sessionFactory = HibernateUtils.getInstance();
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			Criteria criteria = session.createCriteria(KarmaReason.class).
					addOrder(Order.desc("dateTime"))
					.add(Restrictions.eq("senderId", employee));
			@SuppressWarnings("unchecked")
			List<KarmaReason> karma_Reason  = criteria.list();
			transaction.commit();
			return karma_Reason;
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
			return null;
		} finally {
			session.close();
		}
	}

	@Override
	public List<KarmaReason> getReceivedKarmaOfEmployee(Employee employee) {
		Session session = null;
		Transaction transaction = null;
		try {
			SessionFactory sessionFactory = HibernateUtils.getInstance();
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			Criteria criteria = session.createCriteria(KarmaReason.class).
					addOrder(Order.desc("dateTime"))
					.add(Restrictions.eq("receiverId", employee));
			@SuppressWarnings("unchecked")
			List<KarmaReason> karma_Reason  = criteria.list();
			transaction.commit();
			return karma_Reason;
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
			return null;
		} finally {
			session.close();
		}
	}

}
