package com.favorite.quote.api.business.aspects;

import org.apache.log4j.Logger;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.google.common.base.Stopwatch;


/**
 * Logging Aspect class for QuoteFileService class.
 * 
 * @author Binay Mishra
 *
 */
@Aspect
@Component
public class QuoteFileServiceLoggingAspect {
	
	private static Logger LOGGER = Logger.getLogger(QuoteFileServiceLoggingAspect.class);
	
	private Stopwatch stopwatch = Stopwatch.createUnstarted(); 
	
	/**
	 * This method aspect is invoked before method  QuoteFileService.findAllQuotes() call.
	 */
	@Before("execution(* com.favorite.quote.api.business.QuoteFileServiceImpl.findAllQuotes())")
	public void beforefindAllQuotes(){
		LOGGER.info("Method: findAllQuotes() start.");
		stopwatch.start();
	}

	/**
	 * This method aspect is invoked after return of method QuoteFileService.findAllQuotes() call.
	 */
	@AfterReturning("execution(* com.favorite.quote.api.business.QuoteFileServiceImpl.findAllQuotes(..))")
	public void afterReturningfindAllQuotes(){
		LOGGER.info("Method: findAllQuotes() returned. Time elapsed "+stopwatch.stop()+".");
	}
	
	/**
	 * This method aspect is invoked before method  QuoteFileService.findQuoteById() call.
	 */
	@Before("execution(* com.favorite.quote.api.business.QuoteFileServiceImpl.findQuoteById(..))")
	public void beforefindQuoteById(){
		LOGGER.info("Method: findQuoteById() start.");
		stopwatch.start();
	}
	
	/**
	 * This method aspect is invoked after return of method QuoteFileService.findQuoteById() call.
	 */
	@AfterReturning("execution(* com.favorite.quote.api.business.QuoteFileServiceImpl.findQuoteById(..))")
	public void afterReturningfindQuoteById(){
		LOGGER.info("Method: findQuoteById() returned. Time elapsed "+stopwatch.stop()+".");
	}
	
	/**
	 * This method aspect is invoked before method  QuoteFileService.findQuotesByAuthor() call.
	 */
	@Before("execution(* com.favorite.quote.api.business.QuoteFileServiceImpl.findQuotesByAuthor(..))")
	public void beforefindQuotesByAuthor(){
		LOGGER.info("Method: findQuotesByAuthor() start.");
		stopwatch.start();
	}
	
	/**
	 * This method aspect is invoked after return of method QuoteFileService.findQuotesByAuthor() call.
	 */
	@AfterReturning("execution(* com.favorite.quote.api.business.QuoteFileServiceImpl.findQuotesByAuthor())")
	public void afterReturningQuotesByAuthor(){
		LOGGER.info("Method: findQuotesByAuthor() returned. Time elapsed "+stopwatch.stop()+".");
	}
}
