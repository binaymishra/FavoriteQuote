package com.favorite.quote.service.route;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.favorite.quote.api.business.exception.QuoteNotFoundException;

@Component("exceptionHandler")
public class ExceptionHandler {

	protected static final Logger LOGGER = Logger.getLogger(ExceptionHandler.class);

	public void handleQuoteNotFoundException(Exchange exchange) {
		QuoteNotFoundException exception = exchange.getProperty(Exchange.EXCEPTION_CAUGHT, QuoteNotFoundException.class);
		final Message message = exchange.getOut();
		if (null != exception) {
			LOGGER.debug(exception);
			message.setHeader(Exchange.HTTP_RESPONSE_CODE, HttpStatus.SC_NOT_FOUND);
		}
	}
}