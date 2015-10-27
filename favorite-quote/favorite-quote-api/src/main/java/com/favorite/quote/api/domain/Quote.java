package com.favorite.quote.api.domain;

import java.io.Serializable;

public class Quote implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String quote;
	private Author author;
	
	public Quote() {	}
	
	public Quote(Long id) {
		super();
		this.id = id;
	}
	
	
	public Quote(Long id, String quote, Author author) {
		super();
		this.id = id;
		this.quote = quote;
		this.author = author;
	}


	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getQuote() {
		return quote;
	}
	public void setQuote(String quote) {
		this.quote = quote;
	}
	public Author getAuthor() {
		return author;
	}
	public void setAuthor(Author author) {
		this.author = author;
	}
	
	

}
