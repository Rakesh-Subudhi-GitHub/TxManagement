package com.rk.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class DepositeDAOImpl implements IDepositeDAO {

private static final String depositeMoney="UPDATE DT_TX_ACCOUNT_BANK SET BAL=BAL+? WHERE ACNO=?";
	
	@Autowired
	private JdbcTemplate jt;
	
	@Override
	public int deposite(long acno, double amount) {
		int count=0;
		
		count=jt.update(depositeMoney ,
															amount ,
																		acno);
		return count;
	
	}//method

}//class
