package com.favorite.quote.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;




@Configuration
@ComponentScan("com.favorite.quote.api")
public class AppConfig {
	
	
	@Bean(initMethod="loadQuotes")
	public DataLoader loadQuoteData(){
		DataLoader dataLoader = new DataLoader();
		dataLoader.setFilePath("classpath:quotes.data");
		return dataLoader;
	}
}
