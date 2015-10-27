package com.favorite.quote.api.business;

import java.util.Collection;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.favorite.quote.api.business.exception.QuoteNotFoundException;
import com.favorite.quote.api.domain.Quote;
import com.favorite.quote.api.repository.QuoteRepository;


@Service("quoteService")
public class QuoteServiceImpl implements QuoteService {
	
	@Autowired
	@Qualifier("quoteRepository")
	private QuoteRepository quoteRepository;

	@Override
	public Collection<Quote> findAllQuotes() {
		Collection<Quote> quoteList = CollectionUtils.emptyCollection();
		if(CollectionUtils.isNotEmpty(quoteRepository.fetchAllQuotes())){
			quoteList = quoteRepository.fetchAllQuotes(); 
		}
		return quoteList;
	}

	@Override
	public Quote findQuoteById(Long id) {
		Collection<Quote> quoteList = CollectionUtils.emptyCollection();
		quoteList = quoteRepository.fetchQuoteById(id);
		if(CollectionUtils.isNotEmpty(quoteList)){
			List<Quote> quotes = (List<Quote>) quoteList;
			return quotes.get(0);
		}else{
			throw new QuoteNotFoundException("Quote not found for id = "+id);
		}
	}

}
