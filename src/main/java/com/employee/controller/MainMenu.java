package com.employee.controller;

import com.employee.model.Employee;
import com.employee.model.FullTimeEmployee;
import com.employee.model.PartTimeEmployee;
import com.employee.model.ContractEmployee;
import com.employee.service.EmployeeService;
import com.employee.service.PayrollService;
import com.employee.service.AttendanceService;
import java.util.List;
import java.util.Scanner;


public class MainMenu {
    private final EmployeeService employeeService;
    private final PayrollService payrollService;
    private final AttendanceService attendanceService;
    private final Scanner scanner;

    public MainMenu() {
        this.employeeService = new EmployeeService();
        this.payrollService = new PayrollService();
        this.attendanceService = new AttendanceService();
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        boolean running = true;

        while (running) {
            displayMenu();
            int choice = getUserChoice();

            switch (choice) {
                case 1:
                    employeeManagementMenu();
                    break;
                case 2:
                    attendanceTrackingMenu();
                    break;
                case 3:
                    payrollProcessingMenu();
                    break;
                case 4:
                    System.out.println("\n✓ Logging out... Goodbye!");
                    running = false;
                    break;
                default:
                    System.out.println("\n✗ Invalid choice. Please try again.");
            }
        }
    }

    private void displayMenu() {
        System.out.println("\n╔════════════════════════════════════════╗");
        System.out.println("║        EMPLOYEE MANAGEMENT SYSTEM      ║");
        System.out.println("╚════════════════════════════════════════╝");
        System.out.println("  1. Employee Management");
        System.out.println("  2. Attendance Tracking");
        System.out.println("  3. Payroll Processing");
        System.out.println("  4. Logout");
        System.out.print("\nEnter your choice: ");
    }

    private int getUserChoice() {
        try {
            return scanner.nextInt();
        } catch (Exception e) {
            scanner.nextLine();
            return -1;
        }
    }

    private void employeeManagementMenu() {
        System.out.println("\n--- Employee Management ---");
        System.out.println("  1. Add Employee");
        System.out.println("  2. View Employee");
        System.out.println("  3. View All Employees");
        System.out.println("  4. Update Employee");
        System.out.println("  5. Delete Employee");
        System.out.println("  6. Back to Main Menu");
        System.out.print("\nEnter your choice: ");

        int choice = getUserChoice();

        switch (choice) {
            case 1:
                addEmployeeMenu();
                break;
            case 2:
                viewEmployeeMenu();
                break;
            case 3:
                viewAllEmployeesMenu();
                break;
            case 4:
                updateEmployeeMenu();
                break;
            case 5:
                deleteEmployeeMenu();
                break;
            case 6:
                return;
            default:
                System.out.println("\n✗ Invalid choice.");
        }
    }

    private void addEmployeeMenu() {
        System.out.println("\n--- Add Employee ---");
        System.out.println("  1. Add Full-Time Employee");
        System.out.println("  2. Add Part-Time Employee");
        System.out.println("  3. Add Contract Employee");
        System.out.print("\nEnter employee type: ");

        int type = getUserChoice();
        scanner.nextLine();

        System.out.print("Enter Employee ID: ");
        Long id = scanner.nextLong();
        scanner.nextLine();

        System.out.print("Enter Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Department: ");
        String department = scanner.nextLine();

        System.out.print("Enter Salary: ");
        double salary = scanner.nextDouble();
        scanner.nextLine();

        Employee employee = null;

        switch (type) {
            case 1:
                System.out.print("Enter Benefits: ");
                String benefits = scanner.nextLine();
                employee = new FullTimeEmployee(id, name, department, salary, benefits);
                break;
            case 2:
                System.out.print("Enter Hours Worked per Week: ");
                int hours = scanner.nextInt();
                scanner.nextLine();
                employee = new PartTimeEmployee(id, name, department, salary, hours);
                break;
            case 3:
                System.out.print("Enter Contract Duration (months): ");
                int duration = scanner.nextInt();
                scanner.nextLine();
                employee = new ContractEmployee(id, name, department, salary, duration);
                break;
            default:
                System.out.println("\n✗ Invalid employee type.");
                return;
        }

        employeeService.addEmployee(employee);
    }

    private void viewEmployeeMenu() {
        System.out.print("\nEnter Employee ID: ");
        Long id = getUserChoice() + 0L;
        scanner.nextLine();

        Employee employee = employeeService.viewEmployee(id);
        if (employee != null) {
            employee.displayDetails();
        }
    }

    private void viewAllEmployeesMenu() {
        List<Employee> employees = employeeService.viewAllEmployees();

        if (employees.isEmpty()) {
            System.out.println("\n✗ No employees found.");
        } else {
            System.out.println("\n--- All Employees ---");
            for (Employee emp : employees) {
                emp.displayDetails();
            }
        }
    }

    private void updateEmployeeMenu() {
        System.out.print("\nEnter Employee ID to update: ");
        Long id = getUserChoice() + 0L;
        scanner.nextLine();

        Employee existing = employeeService.viewEmployee(id);
        if (existing == null) {
            return;
        }

        System.out.print("Enter New Name (or press Enter to keep current): ");
        String name = scanner.nextLine();
        if (!name.isEmpty()) {
            existing.setName(name);
        }

        System.out.print("Enter New Department (or press Enter to keep current): ");
        String department = scanner.nextLine();
        if (!department.isEmpty()) {
            existing.setDepartment(department);
        }

        System.out.print("Enter New Salary (or 0 to keep current): ");
        double salary = scanner.nextDouble();
        scanner.nextLine();
        if (salary > 0) {
            existing.setSalary(salary);
        }

        employeeService.updateEmployee(id, existing);
    }

    private void deleteEmployeeMenu() {
        System.out.print("\nEnter Employee ID to delete: ");
        Long id = getUserChoice() + 0L;
        scanner.nextLine();

        employeeService.deleteEmployee(id);
    }

    private void attendanceTrackingMenu() {
        System.out.println("\n--- Attendance Tracking ---");
        System.out.println("  1. Mark Attendance");
        System.out.println("  2. View Attendance");
        System.out.println("  3. Generate Attendance Report");
        System.out.println("  4. Back to Main Menu");
        System.out.print("\nEnter your choice: ");

        int choice = getUserChoice();
        scanner.nextLine();

        switch (choice) {
            case 1:
                System.out.print("Enter Employee ID: ");
                Long id1 = scanner.nextLong();
                scanner.nextLine();
                System.out.print("Enter Date (YYYY-MM-DD): ");
                String date = scanner.nextLine();
                System.out.print("Present? (true/false): ");
                boolean present = scanner.nextBoolean();
                scanner.nextLine();
                attendanceService.trackAttendance(id1, date, present);
                break;
            case 2:
                System.out.print("Enter Employee ID: ");
                Long id2 = scanner.nextLong();
                scanner.nextLine();
                List<String> records = attendanceService.viewAttendance(id2);
                System.out.println("\nAttendance Records:");
                for (String record : records) {
                    System.out.println("  " + record);
                }
                break;
            case 3:
                System.out.print("Enter Employee ID: ");
                Long id3 = scanner.nextLong();
                scanner.nextLine();
                attendanceService.generateAttendanceReport(id3);
                break;
            case 4:
                return;
            default:
                System.out.println("\n✗ Invalid choice.");
        }
    }

    private void payrollProcessingMenu() {
        System.out.println("\n--- Payroll Processing ---");
        System.out.println("  1. Calculate Salary");
        System.out.println("  2. Generate Payroll Report");
        System.out.println("  3. Apply Deductions");
        System.out.println("  4. Back to Main Menu");
        System.out.print("\nEnter your choice: ");

        int choice = getUserChoice();
        scanner.nextLine();

        switch (choice) {
            case 1:
                System.out.print("Enter Employee ID: ");
                Long id1 = scanner.nextLong();
                scanner.nextLine();
                Employee emp1 = employeeService.viewEmployee(id1);
                if (emp1 != null) {
                    payrollService.calculateSalary(emp1);
                }
                break;
            case 2:
                System.out.print("Enter Employee ID: ");
                Long id2 = scanner.nextLong();
                scanner.nextLine();
                Employee emp2 = employeeService.viewEmployee(id2);
                if (emp2 != null) {
                    payrollService.generatePayrollReport(emp2);
                }
                break;
            case 3:
                System.out.print("Enter Employee ID: ");
                Long id3 = scanner.nextLong();
                scanner.nextLine();
                Employee emp3 = employeeService.viewEmployee(id3);
                if (emp3 != null) {
                    System.out.print("Enter Deduction Amount: ");
                    double deduction = scanner.nextDouble();
                    scanner.nextLine();
                    payrollService.handleDeductions(emp3, deduction);
                }
                break;
            case 4:
                return;
            default:
                System.out.println("\n✗ Invalid choice.");
        }
    }
}
