package com.rk.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("bankDAO")
public class BankDAOImpl implements BankDAO {

	//sql
	private static final String WithDraw_Query="UPDATE BANK_ACCOUNT SET BALANCE=BALANCE-? WHERE ACNO=? ";
	private static final String Deposite_Query="UPDATE BANK_ACCOUNT SET BALANCE=BALANCE+? WHERE ACNO=? ";

	@Autowired
	private JdbcTemplate jt;
	
	@Override
	public int withdraw(long acno, float amount) {
		int count=jt.update(WithDraw_Query,
															amount ,
																	acno);
		return count;
	}

	@Override
	public int deposite(long acno, float amount) {
		int count=jt.update(Deposite_Query,
															amount ,
																	acno);
		return count;
	
	}

}
