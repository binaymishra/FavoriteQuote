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

}
