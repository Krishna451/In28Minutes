package com.in28minutes.rest.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserServiceDao {
	
	
	private static List<User> users=new ArrayList<>();
	
	static {

	users.add(new User(1,"Bhargav", new Date()));
	users.add(new User(2, "krishna", new Date()));

	}

	private int userscount=2;
	
	public List<User> findall(){
		return users;
		
	}
	
	public User save(User user) {
		
		if(user.getId() == 0) {
			user.setId(++userscount);
		}
		return user;
			
	}
	
	public User findone(int id) {
		
		for(User user: users) {
			if(user.getId()==id) {
				return user;
			}
		}
		return null;
		
	}
	
public User deletebyId(int id) {
		
	Iterator<User> iterator=users.iterator();
	
	while(iterator.hasNext()) {
		
		User user=iterator.next();
		 
			if(user.getId()==id) {
				iterator.remove();
				return user;
			}
	}
		return null;
		
	}
}

