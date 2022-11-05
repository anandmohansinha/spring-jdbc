package com.spring.jdbc;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
@ComponentScan(basePackages = {"com.spring.jdbc"})
public class AppConfig {

	@Bean(name="dataSource")
	public DataSource getDataSource() {
		BasicDataSource bds = new BasicDataSource();
		bds.setDriverClassName("com.mysql.jdbc.Driver");
		bds.setUrl("jdbc:mysql://localhost:3306/springbootl?characterEncoding=utf8");
		bds.setUsername("root");
		bds.setPassword("test");
		bds.setMaxActive(5);
		return bds;
	}
	
	@Bean(name="jtemp")
	public JdbcTemplate getJdbcTemplate(DataSource dataSource) {
		JdbcTemplate jtemp = new JdbcTemplate(dataSource);
		return jtemp;
	}

}
