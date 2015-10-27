package com.favorite.quote.api.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.favorite.quote.api.domain.Author;
import com.favorite.quote.api.domain.Quote;


@Repository("quoteRepository")
public class QuoteRepositoryImpl implements QuoteRepository {
	
	private static final Logger LOG = Logger.getLogger(QuoteRepository.class);
	
	private JdbcTemplate template;
	
	private SimpleJdbcInsert insertQuote;
	
	private SimpleJdbcInsert insertAuthor;
	
	@Autowired
	public QuoteRepositoryImpl(DataSource dataSource) {
		this.template = new JdbcTemplate(dataSource);
		this.insertQuote = new SimpleJdbcInsert(dataSource).withTableName("quote");
		this.insertAuthor = new SimpleJdbcInsert(dataSource).withTableName("author");
	}

	@Override
	public Collection<Quote> fetchAllQuotes() {
		return template.query("SELECT q.id, q.quote, a.id, a.firstName, a.middleName, a.lastName FROM quote q, author a WHERE q.author_id = a.id", new RowMapper<Quote>() {

			@Override
			public Quote mapRow(ResultSet rs, int rowNum) throws SQLException {
				Quote quote = new Quote();
				quote.setId(rs.getLong(1));
				quote.setQuote(rs.getString(2));
				Author author = new Author();
				author.setId(rs.getLong(3));
				author.setFirstName(rs.getString(4));
				author.setMiddleName(rs.getString(5));
				author.setLastName(rs.getString(6));
				quote.setAuthor(author);
				return quote;
			}
		});
	}

	@Override
	public int countQuotes() {
		return template.queryForObject("SELECT COUNT(id) FROM quote", Integer.class);
	}

	@Override
	public long getMaxQuoteId() {
		return template.queryForObject("SELECT MAX(id) FROM quote", Long.class);
	}

	@Override
	@Transactional
	public void insertAuthor(Author author) {
		Map<String, Object> parameters = new HashMap<String, Object>(4);
		parameters.put("id", author.getId());
		parameters.put("firstName", author.getFirstName());
		parameters.put("middleName", author.getMiddleName());
		parameters.put("lastName", author.getLastName());
		int row = insertAuthor.execute(parameters);
		LOG.info(row + " inserted into Table author.");
	}

	@Override
	@Transactional
	public void insertQuote(Quote quote) {
		Map<String, Object> parameters = new HashMap<String, Object>(3);
		parameters.put("id", quote.getId());
		parameters.put("quote", quote.getQuote());
		parameters.put("author_id", quote.getAuthor().getId());
		int row = insertQuote.execute(parameters);
		LOG.info(row + " inserted into Table quote.");
	}

	@Override
	public Collection<Quote> fetchQuoteById(final Long id) {
		Object[] param = {id};
		return template.query("SELECT q.id, q.quote, a.id, a.firstName, a.middleName, a.lastName FROM quote q, author a WHERE q.author_id = a.id WHERE q.id = ?", new RowMapper<Quote>() {

			@Override
			public Quote mapRow(ResultSet rs, int rowNum) throws SQLException {
				Quote quote = new Quote();
				quote.setId(rs.getLong(1));
				quote.setQuote(rs.getString(2));
				Author author = new Author();
				author.setId(rs.getLong(3));
				author.setFirstName(rs.getString(4));
				author.setMiddleName(rs.getString(5));
				author.setLastName(rs.getString(6));
				quote.setAuthor(author);
				return quote;
			}
		}, param);
	}

	@Override
	public Collection<Author> fetchAuthorById(final Long id) {
		Object[] param = {id};
		return template.query("SELECT id, firstName, middleName, lastName FROM author WHERE id = ?", new RowMapper<Author>() {

			@Override
			public Author mapRow(ResultSet rs, int rowNum) throws SQLException {
				Author author = new Author();
				author.setId(rs.getLong("id"));
				author.setFirstName(rs.getString("firstName"));
				author.setMiddleName(rs.getString("middleName"));
				author.setLastName(rs.getString("lastName"));
				return author;
			}
		}, param);
	}

}
