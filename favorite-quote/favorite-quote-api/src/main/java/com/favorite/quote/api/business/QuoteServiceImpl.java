package com.favorite.quote.api.business;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.Predicate;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.favorite.quote.api.business.exception.QuoteNotFoundException;
import com.favorite.quote.api.domain.Author;
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

	@Override
	public Collection<Quote> findQuotesByAuthor(final Author author) {
		if(author != null){
			Collection<Quote> quoteList = CollectionUtils.emptyCollection();
			quoteList = quoteRepository.fetchAllQuotes(); 
			List<Quote> quotes = new ArrayList<Quote>(quoteList) ;
				
			CollectionUtils.filter(quotes, new Predicate<Quote>() {

				@Override
				public boolean evaluate(Quote quote) {
					Author quoteAuthor = quote.getAuthor();
					long quoteAuthorId = quoteAuthor.getId();
					long authorId = author.getId() == null? 0 : author.getId();
					if( authorId == quoteAuthorId){
						return true;
					}else if(StringUtils.equals(author.getFirstName(), quote.getAuthor().getFirstName())){
						return true;
					}else if(StringUtils.equals(author.getLastName(), quote.getAuthor().getLastName())){
						return true;
					}
					return false;
				}
			});
			return quotes;
		}else{
			throw new QuoteNotFoundException("Invalid author "+author);
		}
		
	}

}
