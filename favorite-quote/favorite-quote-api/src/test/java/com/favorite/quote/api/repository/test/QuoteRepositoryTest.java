package com.favorite.quote.api.repository.test;

import javax.sql.DataSource;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.test.jdbc.JdbcTestUtils;

public class QuoteRepositoryTest {
	
	private static DataSource dataSource;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
		dataSource = builder.setType(EmbeddedDatabaseType.HSQL).addScript("schema.sql").addScript("data.sql").build();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		dataSource.getConnection().close();
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		Assert.assertNotNull(dataSource);
		int row = JdbcTestUtils.countRowsInTable(new JdbcTemplate(dataSource), "author");
		System.err.println(row);
	}

}
