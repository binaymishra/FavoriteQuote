package com.favorite.quote.api.repository;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.favorite.quote.api.config.DataLoader;
import com.favorite.quote.api.domain.Author;
import com.favorite.quote.api.domain.Quote;

/**
 * Quote data repository.
 * 
 * @author Binay Mishra
 *
 */
@Component("quoteFileDataRepository")
public class QuoteFileDataRepository {
	
	@Autowired
	private DataLoader dataLoader;
	
	/**
	 * This method returns list of quotes object by reading file that contains the quotes data.
	 * 
	 * @return
	 */
	public List<Quote> getAllQuotes(){
		List<Quote> quotes = new ArrayList<Quote>();
		for(String quoteString :dataLoader.loadQuotes()){
			quotes.add(createQuote(StringUtils.split(quoteString, "|")));
		}
		return quotes;
		
	}

	/**
	 * Splits the data string uisng '|' to identify the Quote Id, Quote String and Author information.
	 * @param split
	 * @return
	 */
	private Quote createQuote(String[] split) {
		Quote quote = new Quote();
		quote.setId(Long.parseLong(StringUtils.trim(split[0])));
		quote.setQuote(StringUtils.trim(split[1]));
		Author author  = createAuthor(StringUtils.trim(split[2]));
		quote.setAuthor(author);
		return quote;
	}

	/**
	 * Splits data string using space and populates the author data like First Name, Middle Name and Last Name. 
	 * 
	 * @param authorNameString
	 * @return
	 */
	private Author createAuthor(String authorNameString) {
		String[] authorNameParts = StringUtils.split(authorNameString);
		Author author = new Author();
		if(authorNameParts.length == 4){
			//id, firstName, middleName, lastName
			for(int i=0; i<authorNameParts.length; i++){
				author.setId(Long.parseLong(StringUtils.trim(authorNameParts[0])));
				author.setFirstName(StringUtils.trim(authorNameParts[1]));
				author.setMiddleName(StringUtils.trim(authorNameParts[2]));
				author.setLastName(StringUtils.trim(authorNameParts[3]));
			}
		}else if(authorNameParts.length == 3){
			//firstName, middleName, lastName
			for(int i=0; i<authorNameParts.length; i++){
				author.setFirstName(StringUtils.trim(authorNameParts[0]));
				author.setMiddleName(StringUtils.trim(authorNameParts[1]));
				author.setLastName(StringUtils.trim(authorNameParts[2]));
			}
		}else if(authorNameParts.length == 2){
			//firstName, lastName
			for(int i=0; i<authorNameParts.length; i++){
				author.setFirstName(StringUtils.trim(authorNameParts[0]));
				author.setLastName(StringUtils.trim(authorNameParts[1]));
			}
		}
		return author;
	}

}
