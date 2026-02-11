package com.employee.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AuthService {
    private static final Logger logger = LoggerFactory.getLogger(AuthService.class);
    private static final String VALID_USERNAME = "admin";
    private static final String VALID_PASSWORD = "admin123";

    public boolean validateCredentials(String username, String password) {
        try {
            if (username == null || password == null) {
                throw new IllegalArgumentException("Username and password cannot be null");
            }
            return VALID_USERNAME.equals(username) && VALID_PASSWORD.equals(password);
        } catch (Exception e) {
            logger.error("Authentication exception: {}", e.getMessage(), e);
            return false;
        }
    }

    public boolean verifyAuthorization(String username) {
        return VALID_USERNAME.equals(username);
    }
}
