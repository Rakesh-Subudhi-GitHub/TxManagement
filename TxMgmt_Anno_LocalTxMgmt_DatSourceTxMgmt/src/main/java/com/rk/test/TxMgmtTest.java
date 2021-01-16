package com.rk.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.rk.service.BankService;
import com.rk.service.BankServiceImpl;

public class TxMgmtTest {

	public static void main(String[] args) {
		
		//properties
		ApplicationContext ctx=null;
		
		BankService service=null;
		
		//create IOC container
		ctx=new ClassPathXmlApplicationContext("com/rk/cfgs/applicationContext.xml");
		
		//cfgs service class 
		service=ctx.getBean("bankService",BankServiceImpl.class);
		
		//invoke the method
		try {
			if(service.transfermoney(1000,1001,200))
				System.out.println("money transfer succesfully");
			else
				System.out.println("bank account problem");
		}//try
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("internal db problem");
		}
		
		//close ctx
		((AbstractApplicationContext) ctx).close();
		
	}//main
}//class
