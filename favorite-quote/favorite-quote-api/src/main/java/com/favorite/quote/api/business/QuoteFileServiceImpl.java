package com.favorite.quote.api.business;

import java.util.Collection;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.favorite.quote.api.business.exception.QuoteNotFoundException;
import com.favorite.quote.api.domain.Author;
import com.favorite.quote.api.domain.Quote;
import com.favorite.quote.api.repository.QuoteFileDataRepository;

@Service("quoteFileService")
public class QuoteFileServiceImpl implements QuoteService {
	
	@Autowired
	@Qualifier("quoteFileDataRepository")
	private QuoteFileDataRepository quoteFileDataRepository;

	@Override
	public Collection<Quote> findAllQuotes() {
		List<Quote> quotes = quoteFileDataRepository.getAllQuotes();
		if(CollectionUtils.isNotEmpty(quotes)){
			return quotes;
		}
		return CollectionUtils.emptyCollection();
	}

	@Override
	public Quote findQuoteById(final Long id) {
		Quote quote = null;
		List<Quote> quotes = quoteFileDataRepository.getAllQuotes();
		if(CollectionUtils.isNotEmpty(quotes)){
			quote = CollectionUtils.find(quotes, new Predicate<Quote>() {

				@Override
				public boolean evaluate(Quote quote) {
					long quoteId = quote.getId().longValue();
					return id == quoteId ? Boolean.TRUE : Boolean.FALSE;
				}
			});
			return quote;
		}else{
			throw new QuoteNotFoundException("Quote not found for id "+id);
		}
	}

	@Override
	public Collection<Quote> findQuotesByAuthor(Author quoteAuthor) {
		if(quoteAuthor != null){
			Collection<Quote> quoteList = CollectionUtils.emptyCollection();
			quoteList = quoteFileDataRepository.getAllQuotes(); 
			CollectionUtils.filter(quoteList, new QuotePredicate(quoteAuthor));
			return quoteList;
		}else{
			throw new QuoteNotFoundException("Invalid author "+quoteAuthor);
		}}

}
