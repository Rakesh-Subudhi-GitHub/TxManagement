package com.rk.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("withdrawDAO")
public class WithdrawDAOImpl implements IWithdrawDAO{

	private static final String withdrawMoney="UPDATE DT_TX_ACCOUNT_BANK SET BAL=BAL-? WHERE ACNO=?";
	
	@Autowired
	private JdbcTemplate jt;
	
	@Override
	public int withdraw(long acno, double amount) {
		
		int count=0;
		
		count=jt.update(withdrawMoney ,
															amount ,
																		acno);
		return count;
	}

}
