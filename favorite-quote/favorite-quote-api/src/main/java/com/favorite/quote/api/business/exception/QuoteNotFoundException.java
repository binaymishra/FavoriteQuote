package com.favorite.quote.api.business.exception;

public class QuoteNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public QuoteNotFoundException(String message) {
		super(message);
	}

	public QuoteNotFoundException(Throwable throwable) {
		super(throwable);
	}
	public QuoteNotFoundException(Throwable throwable,String message) {
		super(message, throwable);
	}
}
