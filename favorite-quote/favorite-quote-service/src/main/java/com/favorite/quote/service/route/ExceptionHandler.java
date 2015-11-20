package com.favorite.quote.service.route;

import java.util.Map;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonParseException;
import com.favorite.quote.api.business.exception.QuoteNotFoundException;

@Component("exceptionHandler")
public class ExceptionHandler {

	protected static final Logger LOGGER = Logger.getLogger(ExceptionHandler.class);

	public void handleException(Exchange exchange) {
		final Exception exception = exchange.getProperty(Exchange.EXCEPTION_CAUGHT, Exception.class);
		final Message message = exchange.getOut();
		//final Map<String, Object> requestHeaders = exchange.getIn().getHeaders();
		if (null != exception) {
			if(exception.getClass() == JsonParseException.class){
				LOGGER.debug(ExceptionUtils.getMessage(exception));
				message.setHeader(Exchange.HTTP_RESPONSE_CODE, HttpStatus.SC_INTERNAL_SERVER_ERROR);
				message.setBody("Invalid JSON format.");
			}
			if(exception.getClass() == QuoteNotFoundException.class){
				LOGGER.debug(ExceptionUtils.getMessage(exception));
				message.setHeader(Exchange.HTTP_RESPONSE_CODE, HttpStatus.SC_NOT_FOUND);
				message.setBody("Resource Not Found.");
			}
		}
		else{
			message.setHeader(Exchange.HTTP_RESPONSE_CODE, HttpStatus.SC_INTERNAL_SERVER_ERROR);
			message.setBody(ExceptionUtils.getMessage(exception));
		}
	}
	
	@SuppressWarnings("unused")
	private void printHeader(Map<String, Object> headers){
		for(Map.Entry<String, Object> header :headers.entrySet()){
			System.out.println(header.getKey()+": "+header.getValue());
		}
	}
}

