package com.in28minutes.rest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	
	@Autowired
	private MessageSource messagesource;
	
	//@RequestMapping(method=RequestMethod.GET,path = "/HelloWorld")
	@GetMapping(path="/HelloWorld")
	public String getName() {
		return "Hello ! Welcome to my world";	
	}
	
	@GetMapping(path="/Hello-World-Bean")
	public HelloworldBean HellowroldBean() {
		return new HelloworldBean("Hello World");
		

	}

	@GetMapping(path="/Hello-World-Bean/path-variable/{name}")
	public HelloworldBean HellowroldBean(@PathVariable String name) {
		return new HelloworldBean(String.format("Hello world, %s" , name));
}
	
	 @GetMapping("/international")
	//public String getInternationalPage(@RequestHeader(name="Accept-Language", required = false) Locale locale) {
	 //----to simplify the above step
	 public String getInternationalPage() {
	    return messagesource.getMessage("greeting", null, LocaleContextHolder.getLocale());
	}
}