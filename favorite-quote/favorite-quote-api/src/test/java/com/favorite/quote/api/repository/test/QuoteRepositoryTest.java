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
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.jdbc.JdbcTestUtils;
import org.springframework.transaction.annotation.Transactional;

import com.favorite.quote.api.config.AppConfig;
import com.favorite.quote.api.domain.Author;
import com.favorite.quote.api.domain.Quote;
import com.favorite.quote.api.repository.QuoteRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={AppConfig.class})
@ActiveProfiles("devlopement")
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
		LOG.info("Running testCountQuotes().....");
		int count = quoteRepository.countQuotes();
		Assert.assertTrue(count > 0);
	}
	@Test
	public void testGetMaxQuoteId(){
		LOG.info("Running testGetMaxQuoteId().....");
		long maxId = quoteRepository.getMaxQuoteId();
		Assert.assertTrue(maxId > 0);
	}
	@Test
	public void testFetchAllQuotes(){
		LOG.info("Running testFetchAllQuotes().....");
		Collection<Quote> quotes = quoteRepository.fetchAllQuotes();
		Assert.assertTrue(quotes.size() > 0);
	}
	
	@Test
	@Transactional
	public void testInsertAuthor(){
		LOG.info("Running testInsertAuthor().....");
		Author author =  new Author(3L, "Vinay", null, "Mishra");
		quoteRepository.insertAuthor(author);
	}
	
	@Test
	@Transactional
	public void testInsertQuote(){
		LOG.info("Running testInsertQuote().....");
		Author author =  new Author(2L);
		Quote quote = new Quote(3L, "Be kind.", author);
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
