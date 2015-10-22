package com.favorite.quote.api.domain.tets;

import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.junit.Test;

import com.favorite.quote.api.domain.Author;


public class AuthorTest {
	
	@Test
	public void testGetFullName(){
		Author author = new Author();
		author.setFirstName("Binay");
		author.setMiddleName("Kumar");
		author.setLastName(null);
		System.err.println(author.getFullName());
		Assert.assertTrue(StringUtils.isNotBlank(author.getFullName()));
	}

}
