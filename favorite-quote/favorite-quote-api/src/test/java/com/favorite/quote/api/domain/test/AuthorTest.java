package com.favorite.quote.api.domain.test;

import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.junit.Test;

import com.favorite.quote.api.domain.Author;


public class AuthorTest {
	
	@Test
	public void testGetFullName(){
		Author author = new Author();
		author.setId(0L);
		author.setFirstName("Binay");
		author.setMiddleName("Kumar");
		author.setLastName("Mishra");
		Assert.assertTrue(StringUtils.isNotBlank(author.getFullName()));
	}

	@Test
	public void testAuthorEquality(){
		Author binay = new Author();
		binay.setId(0L);
		binay.setFirstName("Binay");
		binay.setMiddleName("Kumar");
		binay.setLastName("Mishra");
		
		Author vinay = new Author();
		vinay.setId(0L);
		vinay.setFirstName("Binay");
		vinay.setMiddleName("Kumar");
		vinay.setLastName("Mishra");
		
		Assert.assertTrue(binay.equals(vinay));
	}
	
	@Test
	public void testAuthorNotEquality(){
		Author binay = new Author();
		binay.setId(0L);
		binay.setFirstName("Binay");
		binay.setMiddleName("Kumar");
		binay.setLastName("Mishra");
		
		Author vinay = new Author();
		vinay.setId(0L);
		vinay.setFirstName("Vinay");
		vinay.setMiddleName("Kumar");
		vinay.setLastName("Mishra");
		
		Assert.assertFalse(binay.equals(vinay));
	}
	
	
}
