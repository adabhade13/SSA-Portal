package com.ssa.generator;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Random;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class SSNGenerator implements IdentifierGenerator {

	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
		// TODO Auto-generated method stub
		String firstDigits = "987";
		String middleDigits ="65";
		String lastDigits = null;
		Long ssn =null;
		try {
			Connection connection =session.connection();
			Statement statement = connection.createStatement();
			
			String sql = "SELECT ssn_id_seq.NEXTVAL FROM dual";
			
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				int uniqueDigits = rs.getInt(1); 
			    lastDigits = String.valueOf(uniqueDigits);
			}
			
		}catch (Exception e) {
			e.getMessage();
		}
		
			ssn = Long.parseLong(firstDigits +middleDigits + lastDigits);
				//ssn = 987654003;
				return ssn;
	}

}
