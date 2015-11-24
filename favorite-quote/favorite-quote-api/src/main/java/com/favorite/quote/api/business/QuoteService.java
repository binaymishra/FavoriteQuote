package com.favorite.quote.api.business;


import java.util.Collection;

import com.favorite.quote.api.domain.Author;
import com.favorite.quote.api.domain.Quote;

/**
 * This is standard interface, through which all the services are exposed.
 * 
 * @author Binay Mishra
 *
 */
public interface QuoteService {
	
	/**
	 * This method returns all the Quotes from the repository.
	 * 
	 * @return
	 */
	public Collection<Quote> findAllQuotes();
	
	/**
	 * This method returns unique quote using the unique quote id.
	 * 
	 * @param id
	 * @return
	 */
	public Quote findQuoteById(Long id);
	
	/**
	 * This method returns collection of quote according to the given author.
	 * 
	 * @param author
	 * @return
	 */
	public Collection<Quote> findQuotesByAuthor(Author author);

	
	/**
	 * This method filters out the quotes via author's firstName, middleName and lastName
	 * 
	 * @param quoteAuthor
	 * @return
	 */
	public Collection<Quote> filterQuotesByAuthor(Author quoteAuthor);
	
}
