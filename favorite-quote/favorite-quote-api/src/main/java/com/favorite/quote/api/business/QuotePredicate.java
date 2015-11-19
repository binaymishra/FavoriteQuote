package com.favorite.quote.api.business;

import org.apache.commons.collections4.Predicate;
import com.favorite.quote.api.domain.Author;
import com.favorite.quote.api.domain.Quote;

public class QuotePredicate implements Predicate<Quote> {
	
	private final Author author;
	
	public QuotePredicate(Author author){
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



/*if(author.getFirstName() != null 
&& quoteAuthor.getFirstName() != null
&& StringUtils.equals(author.getFirstName(), quoteAuthor.getFirstName())){
return true;
}else if(author.getMiddleName() != null 
&& quoteAuthor.getMiddleName() != null
&& StringUtils.equals(author.getMiddleName(), quoteAuthor.getMiddleName())){
return true;
}else if(author.getLastName() != null 
&&  quoteAuthor.getLastName() != null 
&& StringUtils.equals(author.getLastName(), quoteAuthor.getLastName())){
return true;
}*/