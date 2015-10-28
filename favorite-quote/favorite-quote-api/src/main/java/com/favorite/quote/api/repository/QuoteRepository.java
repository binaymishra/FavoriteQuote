package com.favorite.quote.api.repository;

import java.util.Collection;

import com.favorite.quote.api.domain.Author;
import com.favorite.quote.api.domain.Quote;

public interface QuoteRepository {
	
	public int countQuotes();
	
	public int countAuthors();
	
	public long getMaxQuoteId();
	
	public long getMaxAuthorId();
	
	public Collection<Quote> fetchAllQuotes();
	public Collection<Quote> fetchQuoteById(final Long id);
	public Collection<Quote> fetchQuoteByAuthorId(final Long authorId);
	
	public Collection<Author> fetchAuthorById(final Long id);
	
	public void insertAuthor(final Author author);
	
	public void insertQuote(final Quote quote);
}
