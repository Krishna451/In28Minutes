package com.in28minutes.rest.user;


import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class Useresource {
	
	@Autowired
	private UserServiceDao services;

	
	@GetMapping("/users")
	public List<User> retrieveallusers(){
		return services.findall();
	}
	
	
	 /* @GetMapping("/users/{id}") 
	  public Resource<User> specificUser(@PathVariable
	  int id){ User user= services.findone(id);
	  
	  if(user==null) throw new UserNotFoundException("id-" +id);
	  
	  Resource<User> resource=new Resource<User>(user);
	  
	  ControllerLinkBuilder linkto=linkTo(methodOn(this.getClass(),
	  retrieveallusers()));
	  
	  resource.add(linkto.withRel("all-users"));
	  
	  return resource;
	  
	  }*/
	 
	
	@GetMapping("/users/{id}")
	public User specificUser(@PathVariable int id){
		User user= services.findone(id);
		
		if(user==null) 
			throw new UserNotFoundException("id-" +id);
		return user;	
	
	}
	
	@PostMapping("/users")
	public ResponseEntity<Object> createuser(@Valid @RequestBody User user) {
		User createduser=services.save(user);
		
		
		  URI location= ServletUriComponentsBuilder .fromCurrentRequest()
		  .path("/{id}") .buildAndExpand(createduser.getId()).toUri();
		  
		  return ResponseEntity.created(location).build();
		 
		
	}
	
	@RequestMapping(value = "/users/{id}",method=RequestMethod.DELETE)
	public void DeleteUser(@PathVariable int id) {
		
		User user=services.deletebyId(id);
		if(user==null) 
			throw new UserNotFoundException("id-" +id);
	
	}
	
	
	}




