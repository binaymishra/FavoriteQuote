package com.favorite.quote.service;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.apache.camel.component.servlet.CamelHttpTransportServlet;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

import com.favorite.quote.api.config.AppConfig;



public class ApplicationInitializer implements WebApplicationInitializer{

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext();
		  applicationContext.register(ServiceConfig.class, AppConfig.class);
		  servletContext.addListener(new ContextLoaderListener(applicationContext));

		  ServletRegistration.Dynamic camelServlet = servletContext.addServlet("CamelServlet", new CamelHttpTransportServlet());
		  camelServlet.setLoadOnStartup(1);
		  camelServlet.addMapping("/*");
		
	}

}
