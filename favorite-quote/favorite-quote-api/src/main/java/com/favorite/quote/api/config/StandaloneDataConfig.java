package com.favorite.quote.api.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import com.favorite.quote.api.business.annotations.Devlopement;

@Configuration
@Devlopement
public class StandaloneDataConfig implements DataConfig{

	@Override
	public DataSource dataSource() {
		return new EmbeddedDatabaseBuilder()
					.setType(EmbeddedDatabaseType.HSQL)
					.addScript("schema.sql")
					.addScript("data.sql")
					.build();
	}
	
}