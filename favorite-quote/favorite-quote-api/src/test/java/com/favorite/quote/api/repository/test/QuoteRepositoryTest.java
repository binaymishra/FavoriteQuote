package com.favorite.quote.api.repository.test;

import java.util.Collection;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.jdbc.JdbcTestUtils;
import org.springframework.transaction.annotation.Transactional;

import com.favorite.quote.api.business.CounterIdGenerator;
import com.favorite.quote.api.config.AppConfig;
import com.favorite.quote.api.domain.Author;
import com.favorite.quote.api.domain.Quote;
import com.favorite.quote.api.repository.QuoteRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={AppConfig.class})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class QuoteRepositoryTest {
	
	private static final Logger LOG = Logger.getLogger(QuoteRepositoryTest.class); 
	
	@Autowired
	private QuoteRepository quoteRepository;

	@Autowired
	private DataSource dataSource;
	
	
	@Test
	public void test() {
		LOG.info("Running test().....");
		int authorRows = JdbcTestUtils.countRowsInTable(new JdbcTemplate(dataSource), "author");
		int quoteRows = JdbcTestUtils.countRowsInTable(new JdbcTemplate(dataSource), "quote");
		LOG.info("Table: author contains "+authorRows+" number of rows.");
		LOG.info("Table: quote contains "+quoteRows+" number of rows.");
		Assert.assertNotNull(dataSource);
		Assert.assertNotNull(quoteRepository);
	}
	@Test
	public void testCountQuotes(){
		int count = quoteRepository.countQuotes();
		LOG.info(String.format("Running test for countQuotes() and %d rows found.", count));
		Assert.assertTrue(count > 0);
	}
	@Test
	public void testGetMaxQuoteId(){
		long maxId = quoteRepository.getMaxQuoteId();
		LOG.info(String.format("Running test for getMaxQuoteId() and max id is %d.", maxId));
		Assert.assertTrue(maxId > 0);
	}
	@Test
	public void testFetchAllQuotes(){
		Collection<Quote> quotes = quoteRepository.fetchAllQuotes();
		LOG.info(String.format("Running test for fetchAllQuotes() and %d number of rows found.", quotes.size()));
		Assert.assertTrue(quotes.size() > 0);
	}
	
	@Test
	@Transactional
	public void testInsertAuthor(){
		CounterIdGenerator authorId = new CounterIdGenerator(this.quoteRepository.getMaxAuthorId());
		long id = Long.parseLong(authorId.getGeneratedId());
		Author author =  new Author(id, "Vinay", null, "Mishra");
		LOG.info(String.format("Running test insertAuthor() with generated author id %d.",id));
		quoteRepository.insertAuthor(author);
	}
	
	@Test
	@Transactional
	public void testInsertQuote(){
		Author author =  new Author(3L);
		CounterIdGenerator quoteId = new CounterIdGenerator(this.quoteRepository.getMaxQuoteId());
		long id = Long.parseLong(quoteId.getGeneratedId());
		Quote quote = new Quote(id, "Music is the shorthand of emotion", author);
		LOG.info(String.format("Running test for insertQuote() with generated author id %d.",id));
		quoteRepository.insertQuote(quote);
	}
	
	@Test
	public void testFetchQuoteById(){
		LOG.info("Running testFetchQuoteById().....");
		Collection<Quote> quotes = quoteRepository.fetchQuoteById(1L);
		Assert.assertNotNull(quotes);
		Assert.assertTrue(quotes.size() > 0);
	}
	@Test
	public void testFetchQuoteByIdNotFound(){
		LOG.info("Running testFetchQuoteByIdNotFound().....");
		Collection<Quote> quotes = quoteRepository.fetchQuoteById(100L);
		Assert.assertFalse(quotes.size() > 0);
	}
	@Test
	public void testFetchAuthorById(){
		LOG.info("Running testFetchAuthorById().....");
		Collection<Author> authors = quoteRepository.fetchAuthorById(1L);
		Assert.assertNotNull(authors);
		Assert.assertTrue(authors.size() > 0);
		
	}
}
