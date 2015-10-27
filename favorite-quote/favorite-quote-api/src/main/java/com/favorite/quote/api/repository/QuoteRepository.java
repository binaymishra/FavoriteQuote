package com.favorite.quote.api.repository;

import java.util.Collection;

import com.favorite.quote.api.domain.Author;
import com.favorite.quote.api.domain.Quote;

public interface QuoteRepository {
	public int countQuotes();
	public long getMaxQuoteId();
	public Collection<Quote> fetchAllQuotes();
	public Collection<Quote> fetchQuoteById(final Long id);
	public Collection<Author> fetchAuthorById(final Long id);
	public void insertAuthor(final Author author);
	public void insertQuote(final Quote quote);
}
