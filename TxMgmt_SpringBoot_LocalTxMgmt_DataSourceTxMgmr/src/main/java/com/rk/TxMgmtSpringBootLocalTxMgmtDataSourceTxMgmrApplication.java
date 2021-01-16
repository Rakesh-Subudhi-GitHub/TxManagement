package com.rk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.rk.service.BankService;

@SpringBootApplication
public class TxMgmtSpringBootLocalTxMgmtDataSourceTxMgmrApplication {

	public static void main(String[] args) {
		//properties
		ApplicationContext ctx=null;
		BankService service=null;
		
		//createIOC container
		ctx=SpringApplication.run(TxMgmtSpringBootLocalTxMgmtDataSourceTxMgmrApplication.class, args);
	
		//get proxy class obj
		service=ctx.getBean("bankService",BankService.class);
		
		//invoke the method
		try {
				if(service.transfermoney(1001, 1000, 100.0f))
				System.out.println("money transfer succesfully");
				else
					System.out.println("money not trasnfered");
		}//try
		catch (Exception e) {
			System.out.println("Problem in money transfer");
			e.printStackTrace();
		}
		
		//close ctx
		((ConfigurableApplicationContext) ctx).close();
		
	}//main

}//class
