package com.favorite.quote.api.business;

import java.util.ArrayList;
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
	
	private final List<Quote> quotes;
	
	@Autowired
	public QuoteFileServiceImpl(@Qualifier("quoteFileDataRepository") QuoteFileDataRepository quoteFileDataRepository) {
		quotes = quoteFileDataRepository.getAllQuotes();
	}

	@Override
	public Collection<Quote> findAllQuotes() {
		if(CollectionUtils.isNotEmpty(quotes)){
			return  quotes;
		}
		return CollectionUtils.emptyCollection();
	}

	@Override
	public Quote findQuoteById(final Long id) {
		Quote quote = null;
		List<Quote> quoteList = new ArrayList<Quote>(quotes);
		if(CollectionUtils.isNotEmpty(quoteList)){
			quote = CollectionUtils.find(quoteList, new Predicate<Quote>() {

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
		List<Quote> quoteList = new ArrayList<Quote>(quotes);
		if(quoteAuthor != null){
			CollectionUtils.filter(quoteList, new QuoteAuthorPredicate(quoteAuthor));
			return quoteList;
		}else{
			throw new QuoteNotFoundException("Invalid author "+quoteAuthor);
		}
	}

	
	@Override
	public Collection<Quote> filterQuotesByAuthor(Author quoteAuthor) {
		List<Quote> quoteList = new ArrayList<Quote>(quotes);
		if(quoteAuthor != null){
			CollectionUtils.filter(quoteList, new QuoteAuthorFilterPredicate(quoteAuthor));
			return quoteList;
		}else{
			throw new QuoteNotFoundException("Invalid author "+quoteAuthor);
		}
	}
}
