package com.favorite.quote.api.business.test;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.favorite.quote.api.business.QuoteService;
import com.favorite.quote.api.config.AppConfig;
import com.favorite.quote.api.domain.Author;
import com.favorite.quote.api.domain.Quote;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={AppConfig.class})
public class QuoteFileServiceTest {
	
	private static final Logger LOG = Logger.getLogger(QuoteFileServiceTest.class);
	
	@Autowired
	@Qualifier("quoteFileService")
	private QuoteService quoteFileService;
	
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
		int size = quoteFileService.findAllQuotes().size();
		Assert.assertTrue(size > 0);
	}
	
	@Test
	public void testFindQuoteByIdFound(){
		LOG.info("Running testFindQuoteByIdFound()...");
		Quote quote = null;
		quote = quoteFileService.findQuoteById(1L);
		Assert.assertNotNull(quote);
			
	}
	@Test
	public void testFindQuoteByIdNotFound(){
		LOG.info("Running testFindQuoteByIdNotFound()...");
		Quote quote = null;
		quote = quoteFileService.findQuoteById(100L);
		Assert.assertNull(quote);
	}
	@Ignore
	@Test
	public void testFindQuotesByAuthor(){
		LOG.info("Running testFindQuotesByAuthor()...");
		author.setFirstName("Victor");
		author.setMiddleName("Gustav");
		List<Quote> quotes = (List<Quote>) quoteFileService.findQuotesByAuthor(author);
		Assert.assertTrue(quotes.size() == 2);
	}
	@Ignore
	@Test
	public void testFindQuotesByAuthorFirstName(){
		LOG.info("Running testFindQuotesByAuthor()...");
		author.setFirstName("Oscar");
		List<Quote> quotes = (List<Quote>) quoteFileService.findQuotesByAuthor(author);
		Assert.assertTrue(quotes.size() == 2);
	}
	@Ignore
	@Test
	public void testFindQuotesByAuthorMiddleName(){
		LOG.info("Running testFindQuotesByAuthorMiddleName()...");
		author.setMiddleName("Makepeace");
		List<Quote> quotes = (List<Quote>) quoteFileService.findQuotesByAuthor(author);
		Assert.assertTrue(quotes.size() == 1);
	}
	@Ignore
	@Test
	public void testFindQuotesByAuthorLastName(){
		LOG.info("Running testFindQuotesByAuthorLastName()...");
		author.setLastName("Wilde");
		List<Quote> quotes = (List<Quote>) quoteFileService.findQuotesByAuthor(author);
		Assert.assertTrue(quotes.size() == 2);
	}
	
	//Author equality Test.
	@Test
	@Ignore
	public void testAuthorForEquality(){
		author.setFirstName("Binay");
		author.setMiddleName(null);
		author.setLastName("Mishra");
		
		//System.err.println(author.hashCode());
		
		Author binay = new Author();
		binay.setFirstName("Binay");
		binay.setMiddleName(null);
		binay.setLastName("Mishra");
		
		//System.err.println(binay.hashCode());
		
		//System.out.println(author.equals(binay));
		
		Assert.assertSame(author, binay);
	}
}
