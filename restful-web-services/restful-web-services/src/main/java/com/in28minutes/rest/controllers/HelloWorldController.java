package com.in28minutes.rest.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	
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

}