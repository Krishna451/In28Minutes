package com.infogain.crewManager.InfogainCrewManagerServerGateway.security;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.infogain.crewManager.InfogainCrewManagerServerGateway.auth.MongoUserDetails;
import com.infogain.crewManager.InfogainCrewManagerServerGateway.auth.Role;
import com.infogain.crewManager.InfogainCrewManagerServerGateway.auth.User;
import com.infogain.crewManager.InfogainCrewManagerServerGateway.exception.CustomException;
import com.infogain.crewManager.InfogainCrewManagerServerGateway.repository.UserRepository;

@Service
public class UserService implements UserDetailsService {
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private HttpSession httpSession;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		
		System.out.println(this.getClass()+" before");
		User user = userRepository.findByEmail(email);
		httpSession.setAttribute("user", user);
		
		System.out.println(" ::"+user);
		System.out.println(this.getClass()+" after");
		if (user == null || user.getRole() == null || user.getRole().isEmpty()) {
			throw new CustomException("Invalid username or password.", HttpStatus.UNAUTHORIZED);
		}
		String[] authorities = new String[user.getRole().size()];
		int count = 0;
		for (Role role : user.getRole()) {
			// NOTE: normally we dont need to add "ROLE_" prefix. Spring does automatically
			// for us.
			// Since we are using custom token using JWT we should add ROLE_ prefix
			authorities[count] = "ROLE_" + role.getRole();
			count++;
		}
		MongoUserDetails userDetails = new MongoUserDetails(user.getEmail(), user.getPassword(), user.getActive(),
				user.isLoacked(), user.isExpired(), user.isEnabled(), authorities);
		return userDetails;
	}

}