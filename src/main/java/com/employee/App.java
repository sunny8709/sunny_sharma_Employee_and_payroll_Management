package com.employee;

import com.employee.controller.MainMenu;
import com.employee.service.LoginService;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LoginService loginService = new LoginService();

        System.out.println("\n╔════════════════════════════════════════════════════╗");
        System.out.println("║  EMPLOYEE MANAGEMENT & PAYROLL SYSTEM              ║");
        System.out.println("║  Pure Java Implementation with OOP Principles      ║");
        System.out.println("╚════════════════════════════════════════════════════╝");

        System.out.print("\nUsername: ");
        String username = scanner.nextLine();

        System.out.print("Password: ");
        String password = scanner.nextLine();

        boolean isAuthenticated = loginService.login(username, password);

        if (isAuthenticated) {
            System.out.println("\n✓ Redirecting to Dashboard...\n");

            MainMenu mainMenu = new MainMenu();
            mainMenu.start();
        } else {
            System.out.println("\n✗ Access Denied. Exiting application.");
        }

        scanner.close();
    }
}
