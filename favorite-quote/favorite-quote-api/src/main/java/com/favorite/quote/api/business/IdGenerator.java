package com.favorite.quote.api.business;


public interface IdGenerator {
	
	public static final String MAX_AUTHOR_ID 	= "SELECT MAX(id) FROM author";
	public static final String MAX_QUOTE_ID 	= "SELECT MAX(id) FROM quote";
	
	public String getGeneratedId();
	
	
}
