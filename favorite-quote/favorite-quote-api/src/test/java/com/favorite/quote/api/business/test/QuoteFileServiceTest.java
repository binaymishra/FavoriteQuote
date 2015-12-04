package com.favorite.quote.api.business.test;

import java.util.List;
import java.util.Set;

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
import com.favorite.quote.api.config.AppConfig;
import com.favorite.quote.api.domain.Author;
import com.favorite.quote.api.domain.Quote;


/**
 * @author Binay Mishra
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={AppConfig.class})
public class QuoteFileServiceTest {

    private static final Logger LOG = Logger.getLogger(QuoteFileServiceTest.class);

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

    private Author author;

    @Autowired
    @Qualifier("quoteFileService")
    private QuoteService quoteFileService;

    @Before
    public void setUp() throws Exception {
        author = new Author();
    }

    @After
    public void tearDown() throws Exception {
        author = null;
    }

    @Test
    public void testFilterQuotesByAuthorFirstName(){
        LOG.info("Running testFilterQuotesByAuthorFirstName()...");
        author.setFirstName("Oscar");
        final List<Quote> quotes = (List<Quote>) quoteFileService.filterQuotesByAuthor(author);
        Assert.assertTrue(quotes.size() == 4);
    }

    @Test
    public void testFilterQuotesByAuthorLastName(){
        LOG.info("Running testFilterQuotesByAuthorFirstLastName()...");
        author.setLastName("Hugo");
        final List<Quote> quotes = (List<Quote>) quoteFileService.filterQuotesByAuthor(author);
        Assert.assertTrue(quotes.size() == 1);
    }

    @Test
    public void testFilterQuotesByAuthorMiddleName(){
        LOG.info("Running testFilterQuotesByAuthorMiddleName()...");
        author.setMiddleName("Makepeace");
        final List<Quote> quotes = (List<Quote>) quoteFileService.filterQuotesByAuthor(author);
        Assert.assertTrue(quotes.size() == 1);
    }

    /**
     * @author Binay Mishra
     */
    @Test
    public void testFindAllAuthors(){
        LOG.info("Running testFindAllAuthors()...");
        final Set<Author> authors = (Set<Author>) quoteFileService.findAllAuthors();
        Assert.assertFalse(authors.isEmpty());
    }

    @Test
    public void testFindAllQuotes(){
        LOG.info("Running testFindAllQuotes()...");
        final int size = quoteFileService.findAllQuotes().size();
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

    @Test
    public void testFindQuotesByAuthor(){
        LOG.info("Running testFindQuotesByAuthor()...");
        author.setFirstName("Peter");
        author.setLastName("Ustinov");
        final List<Quote> quotes = (List<Quote>) quoteFileService.findQuotesByAuthor(author);
        Assert.assertTrue(quotes.size() == 1);
    }
}
