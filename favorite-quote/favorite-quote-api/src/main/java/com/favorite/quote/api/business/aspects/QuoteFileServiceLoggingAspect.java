package com.favorite.quote.api.business.aspects;

import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.favorite.quote.api.domain.Author;
import com.favorite.quote.api.domain.Quote;


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
	
	private long startTime;
	
	/**
	 * This method aspect is invoked before method  QuoteFileService.findAllQuotes() call.
	 */
	@Before("execution(* com.favorite.quote.api.business.QuoteFileServiceImpl.findAllQuotes())")
	public void beforefindAllQuotes(){
		startTime = System.currentTimeMillis();
		LOGGER.info("Method: findAllQuotes() started.");
		
	}

	/**
	 * This method aspect is invoked after return of method QuoteFileService.findAllQuotes() call.
	 */
	@AfterReturning(pointcut="execution(* com.favorite.quote.api.business.QuoteFileServiceImpl.findAllQuotes(..))", returning = "quotes")
	public void afterReturningfindAllQuotes(JoinPoint joinPoint, List<Quote> quotes){
		long endTime  = System.currentTimeMillis();
		LOGGER.info("Method: findAllQuotes() returned "+quotes.size()+" result. Time elapsed "+(endTime - startTime)+" ms.");
	}
	
	/**
	 * This method aspect is invoked before method  QuoteFileService.findQuoteById() call.
	 */
	@Before("execution(* com.favorite.quote.api.business.QuoteFileServiceImpl.findQuoteById(..))")
	public void beforefindQuoteById(){
		startTime = System.currentTimeMillis();
		LOGGER.info("Method: findQuoteById() started.");
	}
	
	/**
	 * This method aspect is invoked after return of method QuoteFileService.findQuoteById() call.
	 */
	@AfterReturning("execution(* com.favorite.quote.api.business.QuoteFileServiceImpl.findQuoteById(..))")
	public void afterReturningfindQuoteById(){
		long endTime  = System.currentTimeMillis();
		LOGGER.info("Method: findQuoteById() returned. Time elapsed "+(endTime - startTime)+" ms.");
	}
	
	/**
	 * This method aspect is invoked before method  QuoteFileService.findQuotesByAuthor() call.
	 */
	@Before("execution(* com.favorite.quote.api.business.QuoteFileServiceImpl.findQuotesByAuthor(..))")
	public void beforefindQuotesByAuthor(){
		startTime = System.currentTimeMillis();
		LOGGER.info("Method: findQuotesByAuthor() started.");
		
	}
	
	/**
	 * This method aspect is invoked after return of method QuoteFileService.findQuotesByAuthor() call.
	 */
	@AfterReturning(pointcut="execution(* com.favorite.quote.api.business.QuoteFileServiceImpl.findQuotesByAuthor(..))", returning="quotes")
	public void afterReturningQuotesByAuthor(JoinPoint joinPoint, List<Quote> quotes){
		long endTime  = System.currentTimeMillis();
		LOGGER.info("Method: findQuotesByAuthor() returned "+quotes.size()+" result. Time elapsed "+(endTime - startTime)+" ms.");
	}
	
	/**
	 * This method aspect is invoked before method  QuoteFileService.filterQuotesByAuthor() call.
	 */
	@Before("execution(* com.favorite.quote.api.business.QuoteFileServiceImpl.filterQuotesByAuthor(..))")
	public void beforeFilterQuotesByAuthor(){
		startTime = System.currentTimeMillis();
		LOGGER.info("Method: findQuotesByAuthor() started.");
		
	}
	
	/**
	 * This method aspect is invoked after return of method QuoteFileService.filterQuotesByAuthor() call.
	 */
	@AfterReturning(pointcut="execution(* com.favorite.quote.api.business.QuoteFileServiceImpl.filterQuotesByAuthor(..))", returning="quotes")
	public void afterReturningFilterQuotesByAuthor(JoinPoint joinPoint, List<Quote> quotes){
		long endTime  = System.currentTimeMillis();
		LOGGER.info("Method: findQuotesByAuthor() returned "+quotes.size()+" result. Time elapsed "+(endTime - startTime)+" ms.");
	}
	
	/**
	 * This method aspect is invoked before method  QuoteFileService.filterQuotesByAuthor() call.
	 */
	@Before("execution(* com.favorite.quote.api.business.QuoteFileServiceImpl.findAllAuthors())")
	public void beforeFindAllAuthors(){
		startTime = System.currentTimeMillis();
		LOGGER.info("Method: findAllAuthors() started.");
		
	}
	
	/**
	 * This method aspect is invoked after return of method QuoteFileService.filterQuotesByAuthor() call.
	 */
	@AfterReturning(pointcut="execution(* com.favorite.quote.api.business.QuoteFileServiceImpl.findAllAuthors())", returning="authors")
	public void afterReturningFindAllAuthors(JoinPoint joinPoint, Set<Author> authors){
		long endTime  = System.currentTimeMillis();
		LOGGER.info("Method: findAllAuthors() returned "+authors.size()+" result. Time elapsed "+(endTime - startTime)+" ms.");
	}
}
