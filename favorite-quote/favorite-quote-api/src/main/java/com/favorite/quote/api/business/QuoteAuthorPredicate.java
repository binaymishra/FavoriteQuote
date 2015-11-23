package com.favorite.quote.api.business;

import org.apache.commons.collections4.Predicate;
import com.favorite.quote.api.domain.Author;
import com.favorite.quote.api.domain.Quote;

public class QuoteAuthorPredicate implements Predicate<Quote> {
	
	private final Author author;
	
	public QuoteAuthorPredicate(Author author){
		this.author = author;
	}

	@Override
	public boolean evaluate(Quote quote) {
		Author quoteAuthor = quote.getAuthor();
		if(quoteAuthor.equals(author)){
			return true;
		}
		return false;
	}

}
