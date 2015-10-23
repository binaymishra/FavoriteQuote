package com.favorite.quote.api.business;


import java.util.Collection;

import com.favorite.quote.api.domain.Quote;

public interface QuoteService {
	public Collection<Quote> findAllQuotes();
}
