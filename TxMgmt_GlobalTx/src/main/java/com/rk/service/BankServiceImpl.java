package com.rk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.rk.dao.IDepositeDAO;
import com.rk.dao.IWithdrawDAO;

@Repository("bankService")
public class BankServiceImpl implements IBankService {

	@Autowired
	private IWithdrawDAO withdrawDAO;
	@Autowired
	private IDepositeDAO depositeDAO;
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED,readOnly = false)
	public String transferMoney(long scrAcno, long destAcno, double amount) {
		int count1=withdrawDAO.withdraw(scrAcno, amount);
		int count2=depositeDAO.deposite(destAcno, amount);
		
		if(count1==0 ||count2==0)
		  throw new RuntimeException("Problem in money transfer");
		else
			return "Money transfer from "+scrAcno +" to "+destAcno +" and money is "+amount;
	}//method

}//class
