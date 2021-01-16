package com.rk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.rk.dao.BankDAO;

@Service("bankService")
public class BankServiceImpl implements BankService {

	@Autowired
	private BankDAO dao;
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED,
														readOnly =false ,
																timeout = 10 ,
																		transactionManager= "transactionManager")
	public boolean transfermoney(long srcAcno, long DepoAcno, float amount) {
		
		int count1=dao.withdraw(srcAcno, amount);
		int count2=dao.deposite(DepoAcno, amount);
		
		boolean flag=false;
		
		if(count1==0 || count2==0)
					throw new RuntimeException("db problm so money not transfer::: ");
		
		else
			flag=true;
		
			return flag;

	}//method

}
