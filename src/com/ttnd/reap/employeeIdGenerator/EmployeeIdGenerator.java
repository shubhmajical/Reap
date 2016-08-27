package com.ttnd.reap.employeeIdGenerator;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.id.IdentifierGenerator;

public class EmployeeIdGenerator implements IdentifierGenerator {

	public Serializable generate(SessionImplementor session, Object object)
			throws HibernateException {

		String prefix = "TTND";
		Connection connection = session.connection();
		try {

			PreparedStatement ps = connection
					.prepareStatement("SELECT MAX(employeeId) as id from employeedetail");

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {

//				if (rs.getInt(1) == 0) {
					int id = rs.getInt(1) + 1001;
					String code = prefix + new Integer(id).toString();
					System.out.println("Generated Id: " + code);
					return code;
				} /*else {
					String value = rs.getString("id");
					int id = Integer.parseInt(value.replaceAll("[^0-9 ]", ""));
					++id;
					String code = prefix + new Integer(id).toString();
					System.out.println("Generated Stock Code: " + code);
					return code;
//				}
*/			
		

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
