package com.favorite.quote.service;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;



public class ApplicationInitializer implements WebApplicationInitializer{

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext();
		  applicationContext.scan("com.favorite.quote");;
		  applicationContext.getEnvironment().setActiveProfiles("production", "devlopement");
		  servletContext.addListener(new ContextLoaderListener(applicationContext));

		  ServletRegistration.Dynamic camelServlet = servletContext.addServlet("CamelServlet", new FavoriteQuoteServlet());
		  camelServlet.setLoadOnStartup(1);
		  camelServlet.addMapping("/*");
		
	}

}
