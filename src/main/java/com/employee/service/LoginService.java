package com.employee.service;


public class LoginService {
    private AuthService authService;

    public LoginService() {
        this.authService = new AuthService();
    }

    public boolean login(String username, String password) {
        System.out.println("\n--- User Login ---");
        System.out.println("Authenticating user: " + username);

        boolean isAuthenticated = authService.validateCredentials(username, password);

        if (isAuthenticated) {
            System.out.println("✓ Login successful!");
            return true;
        } else {
            System.out.println("✗ Login failed! Invalid credentials.");
            return false;
        }
    }
}
