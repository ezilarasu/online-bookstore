package com.ezil.onlinebookstore.configuration;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Configuration
@Component

public class DataBaseConfiguration {
//	@Bean
//	@Primary
//	@ConfigurationProperties(prefix ="spring.datasource")
//	public DataSource getDataSource() {
//		return DataSourceBuilder.create().url("jdbc:mysql://localhost:3306/test?useSSL=false").username("root").password("admin@123")
//		.driverClassName("com.mysql.cj.jdbc.Driver").build();
//	}
}
