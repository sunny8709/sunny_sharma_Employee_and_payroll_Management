package com.employee.service;


public class AuthService {
    private static final String VALID_USERNAME = "admin";
    private static final String VALID_PASSWORD = "admin123";

    public boolean validateCredentials(String username, String password) {
        try {
            if (username == null || password == null) {
                throw new IllegalArgumentException("Username and password cannot be null");
            }
            return VALID_USERNAME.equals(username) && VALID_PASSWORD.equals(password);
        } catch (Exception e) {
            System.out.println("Authentication Exception: " + e.getMessage());
            return false;
        }
    }

    public boolean verifyAuthorization(String username) {
        return VALID_USERNAME.equals(username);
    }
}
