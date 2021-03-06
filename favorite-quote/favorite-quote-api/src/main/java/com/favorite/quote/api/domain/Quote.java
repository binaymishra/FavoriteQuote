package com.favorite.quote.api.domain;

import java.io.Serializable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * Quote domain Object
 * 
 * @author Binay Mishra
 *
 */
@JsonInclude(value=Include.NON_NULL)
public class Quote implements Serializable{


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
	
	
	@Override
	public String toString() {
		ToStringBuilder builder = new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE);
		builder.append("id", this.id);
		builder.append("quote", this.quote);
		builder.append("author", this.author);
		return builder.toString();
	}
	
	@Override
	public int hashCode() {
		 return new HashCodeBuilder()
	        .append(this.id)
	        .toHashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		 if(obj instanceof Quote){
			 final Quote other = (Quote) obj;
			 return new EqualsBuilder()
	            .append(this.id, other.id)
	            .isEquals();
		 }else{
			 return false;
		 }
	}
	
	
}
