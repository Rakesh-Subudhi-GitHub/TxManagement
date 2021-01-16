package com.rk.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
@ComponentScan(basePackages ="com.rk.dao")
public class Persistence {

	//cfg in data source
	@Bean(name = "hkDs")
	public DataSource createHkDs()
	{
		HikariDataSource hkDs=new HikariDataSource();
		
		hkDs.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		hkDs.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:orcl");
		hkDs.setUsername("rakesh");
		hkDs.setPassword("devibhai");
		hkDs.setMinimumIdle(10);
		hkDs.setMaximumPoolSize(30);
		
		return hkDs;
		
	}//ds
	
	//cfgs JdbcTemplate
	@Bean(name = "template")
	public JdbcTemplate createJt()
	{
		return new JdbcTemplate(createHkDs());
	}
	
}//class
