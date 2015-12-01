package com.favorite.quote.service.route;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class FevoriteQuoteServiceFilter implements Filter {
	
	private static final Logger  LOGGER = Logger.getLogger(FevoriteQuoteServiceFilter.class);
   
    public FevoriteQuoteServiceFilter() {    }
	
	public void destroy() { LOGGER.info("FevoriteQuoteServiceFilter is finally destroyed.. !");	}

	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
		HttpServletResponse response = (HttpServletResponse) res;
	    response.setHeader("Access-Control-Allow-Origin", "*");
	    response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
	    response.setHeader("Access-Control-Max-Age", "3600");
	    response.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
		chain.doFilter(req, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
		LOGGER.info("FevoriteQuoteServiceFilter is initilized.. !");
	}

}
