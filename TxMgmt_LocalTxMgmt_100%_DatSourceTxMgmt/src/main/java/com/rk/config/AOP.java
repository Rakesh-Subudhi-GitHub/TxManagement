package com.rk.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class AOP {

	@Autowired
	private DataSource ds;
	
	//cfgs txMgmr
	@Bean(name="dsTxMgmr")
	public DataSourceTransactionManager createTxmr()
	{
		return new DataSourceTransactionManager(ds);
	}
	
}
