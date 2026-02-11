package com.employee.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoginService {
    private static final Logger logger = LoggerFactory.getLogger(LoginService.class);
    private AuthService authService;

    public LoginService() {
        this.authService = new AuthService();
    }

    public boolean login(String username, String password) {
        logger.info("User login attempt: {}", username);

        boolean isAuthenticated = authService.validateCredentials(username, password);

        if (isAuthenticated) {
            logger.info("Login successful for user: {}", username);
            return true;
        } else {
            logger.warn("Login failed for user: {} - Invalid credentials", username);
            return false;
        }
    }
}
