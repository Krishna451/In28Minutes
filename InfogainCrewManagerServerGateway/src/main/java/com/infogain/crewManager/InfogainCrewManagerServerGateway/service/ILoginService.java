package com.infogain.crewManager.InfogainCrewManagerServerGateway.service;

import com.infogain.crewManager.InfogainCrewManagerServerGateway.auth.User;

public interface ILoginService {
    
	String login(String username, String password);
    
    User saveUser(User user);

    boolean logout(String token);

    Boolean isValidToken(String token);

    String createNewToken(String token);
}