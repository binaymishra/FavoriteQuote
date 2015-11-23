package com.favorite.quote.api.config;

import java.util.Arrays;

import org.springframework.cache.Cache;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;




/**
 * @author Binay Mishra
 *
 *Spring Java Configuration file.
 *
 */
@Configuration
@EnableCaching
@EnableAspectJAutoProxy
@ComponentScan({"com.favorite.quote.api"})
public class AppConfig {
	
	
	@Bean(initMethod="loadQuotes")
	public DataLoader loadQuoteData(){
		DataLoader dataLoader = new DataLoader();
		dataLoader.setFilePath("classpath:quotes.data");
		return dataLoader;
	}
	
	@Bean
	public SimpleCacheManager concurrentMapBasedCache(){
		SimpleCacheManager cacheManager = new SimpleCacheManager();
		Cache cache = new ConcurrentMapCache("quoteCache");
		cacheManager.setCaches(Arrays.asList(cache));
		return cacheManager;
	}
}
