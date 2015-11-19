package com.favorite.quote.api.business.test;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.favorite.quote.api.config.AppConfig;
import com.favorite.quote.api.config.DataLoader;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={AppConfig.class})
public class DataLoaderTest {
	
	@Autowired
	private DataLoader dataLoader;
	
	@Test
	public void testDataLoader(){
		List<String> quotes = dataLoader.loadQuotes();
		Assert.assertFalse( quotes.size() <= 0);
	}

}
