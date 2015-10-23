package com.favorite.quote.api.business;

import java.util.Collection;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;

import com.favorite.quote.api.domain.Quote;


@Service("quoteService")
public class QuoteServiceImpl implements QuoteService {

	@Override
	public Collection<Quote> findAllQuotes() {
		Collection<Quote> quoteList = CollectionUtils.emptyCollection();
		return quoteList;
	}

}
