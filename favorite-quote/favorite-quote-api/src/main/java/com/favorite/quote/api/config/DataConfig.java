package com.favorite.quote.api.config;

import javax.sql.DataSource;

interface DataConfig {
	public DataSource dataSource() throws Exception;
}