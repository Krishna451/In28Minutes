package com.infogain.crewManager.InfogainCrewManagerServerGateway.auth;

public class AuthResponse {
	private String accessToken;

	private User user;

	public AuthResponse() {
	}

	
	
	public AuthResponse(String accessToken, User user) {
		super();
		this.accessToken = accessToken;
		this.user = user;
	}



	public String getAccessToken() {
		return accessToken;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
}