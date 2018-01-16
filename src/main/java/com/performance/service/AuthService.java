package com.performance.service;

public interface AuthService {
	
	public String validateAuth(String authStr);
	
	public String safeLogout();
}
