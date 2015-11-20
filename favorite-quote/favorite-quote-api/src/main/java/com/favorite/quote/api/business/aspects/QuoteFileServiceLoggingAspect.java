package com.favorite.quote.api.business.aspects;

import org.apache.log4j.Logger;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.google.common.base.Stopwatch;


@Aspect
@Component
public class QuoteFileServiceLoggingAspect {
	
	private static Logger LOGGER = Logger.getLogger(QuoteFileServiceLoggingAspect.class);
	
	private Stopwatch stopwatch = Stopwatch.createUnstarted(); 
	
	@Before("execution(* com.favorite.quote.api.business.QuoteFileServiceImpl.findAllQuotes())")
	public void beforefindAllQuotes(){
		stopwatch.start();
		LOGGER.info("Executing..beforefindAllQuotes()");
	}

	@AfterReturning("execution(* com.favorite.quote.api.business.QuoteFileServiceImpl.findAllQuotes())")
	public void afterReturningfindAllQuotes(){
		System.err.println(stopwatch.stop());
		LOGGER.info("Executing..afterReturningfindAllQuotes()");
	}
}
