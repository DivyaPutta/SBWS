package com.gana.ecom;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;


@Configuration
public class BeanConfig {

	@Bean
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource =new DriverManagerDataSource();
		dataSource.setUrl("jdbc:mysql://localhost:3306/userdb");
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setPassword("root@123");
		dataSource.setUsername("root");
	    return dataSource;
	}

}

