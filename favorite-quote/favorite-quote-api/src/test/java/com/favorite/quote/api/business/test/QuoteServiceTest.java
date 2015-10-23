package com.favorite.quote.api.business.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.favorite.quote.api.business.QuoteService;
import com.favorite.quote.api.config.AppConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={AppConfig.class})
public class QuoteServiceTest {
	
	@Autowired
	@Qualifier("quoteService")
	private QuoteService quoteService;

	
	@Test
	public void testFindAllQuotes(){
		quoteService.findAllQuotes();
	}

}
