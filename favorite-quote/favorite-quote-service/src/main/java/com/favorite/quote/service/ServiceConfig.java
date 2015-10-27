package com.favorite.quote.service;

import org.apache.camel.spring.javaconfig.CamelConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.favorite.quote.service.route")
public class ServiceConfig extends CamelConfiguration{

}
