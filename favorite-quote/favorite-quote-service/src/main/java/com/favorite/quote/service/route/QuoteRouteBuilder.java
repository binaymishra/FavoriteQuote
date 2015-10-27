package com.favorite.quote.service.route;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.stereotype.Component;

import com.favorite.quote.api.business.exception.QuoteNotFoundException;
import com.favorite.quote.api.domain.Quote;

@Component
public class QuoteRouteBuilder extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		
		onException(QuoteNotFoundException.class).handled(true)
		.beanRef("exceptionHandler","handleQuoteNotFoundException")
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
			.to("bean:quoteService?method=findAllQuotes")
		
			.get("/{id}")
			.outTypeList(Quote.class)
			.to("bean:quoteService?method=findQuoteById(${header.id})");

	}

}
