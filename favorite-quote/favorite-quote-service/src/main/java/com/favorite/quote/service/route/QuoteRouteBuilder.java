package com.favorite.quote.service.route;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.stereotype.Component;

import com.favorite.quote.api.domain.Author;
import com.favorite.quote.api.domain.Quote;

@Component
public class QuoteRouteBuilder extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		
		onException(Exception.class).handled(true)
		.beanRef("exceptionHandler","handleException")
		.stop();
		
		restConfiguration()
		.component("servlet")
		.bindingMode(RestBindingMode.json)
		.dataFormatProperty("prettyPrint", "true");
		
		rest("quote")
		.description("Quote RESTful Service.")
		.consumes("application/json")
		.produces("application/json")

			.get("")
			.outTypeList(Quote.class)
			.to("bean:quoteFileService?method=findAllQuotes")
		
			.get("/{id}")
			.outTypeList(Quote.class)
			.to("bean:quoteFileService?method=findQuoteById(${header.id})")
		
			.post("/author")
			.type(Author.class)
			.outTypeList(Quote.class)
			.to("bean:quoteFileService?method=findQuotesByAuthor(${body})");

	}

}
