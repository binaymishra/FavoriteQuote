package com.favorite.quote.api.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;



@Configuration
@ComponentScan("com.favorite.quote.api")
public class AppConfig {
	
	@Autowired
	DataConfig dataConfig;
	
	@Bean
	public DataSource getDataSource() throws Exception {
		return dataConfig.dataSource();
	}

	@Bean
	public DataSourceTransactionManager getDataSourceTransactionManager() throws Exception{
		DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
		transactionManager.setDataSource(dataConfig.dataSource());
		return transactionManager;
	}
}
