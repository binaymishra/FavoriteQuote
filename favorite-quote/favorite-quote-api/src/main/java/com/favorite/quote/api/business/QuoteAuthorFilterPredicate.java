package com.favorite.quote.api.business;

import org.apache.commons.collections4.Predicate;
import org.apache.commons.lang3.StringUtils;

import com.favorite.quote.api.domain.Author;
import com.favorite.quote.api.domain.Quote;

public class QuoteAuthorFilterPredicate implements Predicate<Quote> {
	
private final Author author;
	
	public QuoteAuthorFilterPredicate(Author author){
		this.author = author;
	}

	@Override
	public boolean evaluate(Quote quote) {
		Author quoteAuthor = quote.getAuthor();
		if(quoteAuthor.getFirstName() != null && author.getFirstName() != null && StringUtils.equals(quoteAuthor.getFirstName(), author.getFirstName())){
			return true;
		}if(quoteAuthor.getMiddleName() != null && author.getMiddleName() != null && StringUtils.equals(quoteAuthor.getMiddleName(), author.getMiddleName())){
			return true;
		}if(quoteAuthor.getLastName() != null && author.getLastName() != null && StringUtils.equals(quoteAuthor.getLastName(), author.getLastName())){
			return true;
		}
		return false;
	}

}
