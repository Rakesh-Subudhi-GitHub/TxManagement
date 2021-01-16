package com.rk.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.rk.service.IBankService;

public class DtxMgMtTest {

	public static void main(String[] args) {
		
		//properties
		ApplicationContext ctx=null;
		IBankService proxy=null;
		
		//Create IOC container
		ctx=new ClassPathXmlApplicationContext("com/rk/cfgs/applicationContext.xml");
		
		//get proxy object
		proxy=ctx.getBean("bankService", IBankService.class);
		
		//invoke the method
		try {
			
			System.out.println(proxy.transferMoney(1000,9000,100));
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("money trsafer not completed");
		}
		
		//close ctx
		((AbstractApplicationContext) ctx).close();
		
	}//main
}//class
