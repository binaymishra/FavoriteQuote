package com.favorite.quote.api.business;


import java.util.Collection;

import com.favorite.quote.api.domain.Author;
import com.favorite.quote.api.domain.Quote;

public interface QuoteService {
	public Collection<Quote> findAllQuotes();
	public Quote findQuoteById(Long id);
	public Collection<Quote> findQuotesByAuthor(Author author);
	
}
