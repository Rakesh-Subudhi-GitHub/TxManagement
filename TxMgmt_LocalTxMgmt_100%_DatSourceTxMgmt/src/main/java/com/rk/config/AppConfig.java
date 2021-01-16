package com.rk.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(value = {Persistence.class,Service.class,AOP.class})
public class AppConfig {

}
