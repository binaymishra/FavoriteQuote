package com.favorite.quote.api.business;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

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
		// TODO Auto-generated method stub
		return quoteFileDataRepository.getAllQuotes();
	}

	@Override
	public Quote findQuoteById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Quote> findQuotesByAuthor(Author author) {
		// TODO Auto-generated method stub
		return null;
	}

}
