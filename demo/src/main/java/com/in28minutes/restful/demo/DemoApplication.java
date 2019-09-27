package com.in28minutes.restful.demo;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

@SpringBootApplication
@ComponentScan(basePackages = {"com.in28minutes.rest.controllers","com.in28minutes.rest.user","com.in28minutes.rest.exception","com.in28minutes.restful.demo","com.in28minutes.rest.filtering"})
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	@Bean
	public AcceptHeaderLocaleResolver localeResolver() {
		/* SessionLocaleResolver localeResolver = new SessionLocaleResolver(); */
		AcceptHeaderLocaleResolver localeResolver=new AcceptHeaderLocaleResolver();
	    localeResolver.setDefaultLocale(Locale.US);
	    return localeResolver;
	}
	
	/*
	 * @Bean public ResourceBundleMessageSource messageSource() {
	 * ResourceBundleMessageSource messageSource=new ResourceBundleMessageSource();
	 * messageSource.setBasename("messages"); return messageSource;
	 * 
	 * }
	 * 
	 * instead of creating new bean to add the spring boot property in properties file. 
	 */
}
