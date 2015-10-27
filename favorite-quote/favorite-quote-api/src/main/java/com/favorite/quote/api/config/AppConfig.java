package com.favorite.quote.api.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;



@Configuration
@ComponentScan("com.favorite.quote.api")
public class AppConfig {
	
	@Autowired
	private DataSource dataSource; 
	
	@Bean
	public DataSource dataSource() {
		return new EmbeddedDatabaseBuilder()
					.setType(EmbeddedDatabaseType.HSQL)
					.addScript("schema.sql")
					.addScript("data.sql")
					.build();
	}
	@Bean
	public DataSourceTransactionManager getDataSourceTransactionManager() throws Exception{
		DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
		transactionManager.setDataSource(dataSource);
		return transactionManager;
	}
}
