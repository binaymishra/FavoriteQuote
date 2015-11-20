package com.favorite.quote.api.repository.test;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.favorite.quote.api.config.AppConfig;
import com.favorite.quote.api.domain.Quote;
import com.favorite.quote.api.repository.QuoteFileDataRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={AppConfig.class})
public class QuoteFileDataRepositoryTest {
	
	@Autowired
	@Qualifier("quoteFileDataRepository")
	private QuoteFileDataRepository quoteFileDataRepository;
	
	@Test
	public void testGetAllQuotes(){
		List<Quote> quotes = quoteFileDataRepository.getAllQuotes();
		Assert.assertFalse(quotes.isEmpty());
	}

}
