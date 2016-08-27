package com.ttnd.reap.data.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Conjunction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.ttnd.reap.data.dao.IValidateDAO;
import com.ttnd.reap.data.util.HibernateUtils;
import com.ttnd.reap.dto.LoginDTO;
import com.ttnd.reap.pojo.Employee;

@Repository
public class ValidateDAOImpl implements IValidateDAO{

	private static Session session = null;
	private static Transaction transaction = null;

	
	@Override
	public Employee ValidateUser(LoginDTO loginCredentials){
		
		Employee employee_Detail=null;
			
			
			session = null;
			transaction = null;
			try {
				SessionFactory sessionFactory = HibernateUtils.getInstance();
				session = sessionFactory.openSession();
				transaction = session.beginTransaction();
				Criteria criteria = session.createCriteria(Employee.class);
				Criterion criterion=Restrictions.eq("employeeEmailId",loginCredentials.getEmail());
				Criterion criterion2=Restrictions.eq("password", loginCredentials.getPassword());
				
				Conjunction conjunction=Restrictions.conjunction();
							conjunction.add(criterion);
							conjunction.add(criterion2);
				criteria.add(conjunction);
				 employee_Detail=(Employee) criteria.uniqueResult(); 
					transaction.commit();
			} catch (Exception e) {
				transaction.rollback();
				System.out.println("exception occured");
			} finally {
				session.close();
			}
			return employee_Detail;
	
	}
}
