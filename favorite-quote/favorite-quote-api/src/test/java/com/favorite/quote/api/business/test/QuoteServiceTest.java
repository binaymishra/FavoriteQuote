package com.favorite.quote.api.business.test;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.favorite.quote.api.business.QuoteService;
import com.favorite.quote.api.config.AppConfig;
import com.favorite.quote.api.domain.Quote;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={AppConfig.class})
@ActiveProfiles("devlopement")
public class QuoteServiceTest {
	
	private static final Logger LOG = Logger.getLogger(QuoteServiceTest.class);
	
	@Autowired
	@Qualifier("quoteService")
	private QuoteService quoteService;

	
	@Test
	public void testFindAllQuotes(){
		LOG.info("Running testFindAllQuotes()...");
		int size = quoteService.findAllQuotes().size();
		Assert.assertTrue(size > 0);
	}
	
	@Test
	public void testFindQuoteByIdFound(){
		LOG.info("Running testFindQuoteByIdFound()...");
		Quote quote = null;
		quote = quoteService.findQuoteById(1L);
		Assert.assertNotNull(quote);
		
	}
	@Test(expected=RuntimeException.class)
	public void testFindQuoteByIdNotFound(){
		LOG.info("Running testFindQuoteByIdNotFound()...");
		Quote quote = null;
		quote = quoteService.findQuoteById(100L);
		Assert.assertNull(quote);
		
	}
}
