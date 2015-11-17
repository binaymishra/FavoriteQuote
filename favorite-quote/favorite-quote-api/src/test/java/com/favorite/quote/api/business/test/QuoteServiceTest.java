package com.favorite.quote.api.business.test;

import java.util.Collection;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.favorite.quote.api.business.QuoteService;
import com.favorite.quote.api.business.exception.QuoteNotFoundException;
import com.favorite.quote.api.config.AppConfig;
import com.favorite.quote.api.domain.Author;
import com.favorite.quote.api.domain.Quote;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={AppConfig.class})
public class QuoteServiceTest {
	
	private static final Logger LOG = Logger.getLogger(QuoteServiceTest.class);
	
	@Autowired
	@Qualifier("quoteService")
	private QuoteService quoteService;
	
	private Author author;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		author = new Author();
	}

	@After
	public void tearDown() throws Exception {
		 author = null;
	}

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
	@Test(expected=QuoteNotFoundException.class)
	public void testFindQuoteByIdNotFound(){
		LOG.info("Running testFindQuoteByIdNotFound()...");
		Quote quote = null;
		quote = quoteService.findQuoteById(100L);
		Assert.assertNull(quote);
		
	}
	
	@Test
	public void testFindQuotesByAuthorFound(){
		LOG.info("Running testFindQuotesByAuthor()...");
		author = new Author();
		author.setId(1L);
		author.setFirstName("Oscar");
		author.setMiddleName("None");
		author.setLastName("Wilde");
		Collection<Quote> quoteList = quoteService.findQuotesByAuthor(author);
		Assert.assertTrue(quoteList.size() == 4);
	}
	@Test
	public void testFindQuotesByAuthorNotFound(){
		LOG.info("Running testFindQuotesByAuthor()...");
		author = new Author();
		author.setId(100L);
		author.setFirstName("Adolf");
		author.setMiddleName("None");
		author.setLastName("Hitler");
		Collection<Quote> quoteList = quoteService.findQuotesByAuthor(author);
		Assert.assertTrue(quoteList.isEmpty());
	}
	@Test
	public void testFindQuotesByAuthorFirstName(){
		LOG.info("Running testFindQuotesByAuthor()...");
		author = new Author();
		author.setId(100L);
		author.setFirstName("Oscar");
		author.setMiddleName("None");
		author.setLastName(null);
		Collection<Quote> quoteList = quoteService.findQuotesByAuthor(author);
		Assert.assertTrue(quoteList.size() == 4);
	}
	@Test
	public void testFindQuotesByAuthorLastName(){
		LOG.info("Running testFindQuotesByAuthor()...");
		author = new Author();
		author.setId(100L);
		author.setFirstName(null);
		author.setMiddleName("None");
		author.setLastName("Wilde");
		Collection<Quote> quoteList = quoteService.findQuotesByAuthor(author);
		Assert.assertTrue(quoteList.size() == 4);
	}
	
	@Test
	public void testFindQuotesByAuthorMiddleName(){
		LOG.info("Running testFindQuotesByAuthorMiddleName()...");
		author = new Author();
		author.setId(null);
		author.setFirstName(null);
		author.setMiddleName(null);
		author.setLastName(null);
		Collection<Quote> quoteList = quoteService.findQuotesByAuthor(author);
		Assert.assertTrue(quoteList.size() == 6);
	}
	
	@Test(expected=QuoteNotFoundException.class)
	public void testFindQuotesByInvalidAuthor(){
		LOG.info("Running testFindQuotesByAuthor()...");
		quoteService.findQuotesByAuthor(null);
	}
	
}
