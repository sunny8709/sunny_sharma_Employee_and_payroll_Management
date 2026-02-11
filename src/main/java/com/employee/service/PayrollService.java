package com.employee.service;

import com.employee.model.Employee;


public class PayrollService implements PayrollOperations {

    @Override
    public double calculateSalary(Employee employee) {
        if (employee == null) {
            System.out.println("✗ Error: Employee not found");
            return 0.0;
        }

        double baseSalary = employee.getSalary();
        System.out.println("\n--- Salary Calculation ---");
        System.out.println("Employee: " + employee.getName());
        System.out.println("Base Salary: $" + baseSalary);

        return baseSalary;
    }

    @Override
    public void generatePayrollReport(Employee employee) {
        if (employee == null) {
            System.out.println("✗ Error: Employee not found");
            return;
        }

        System.out.println("\n========== PAYROLL REPORT ==========");
        System.out.println("Employee ID: " + employee.getEmployeeId());
        System.out.println("Employee Name: " + employee.getName());
        System.out.println("Department: " + employee.getDepartment());
        System.out.println("Base Salary: $" + employee.getSalary());
        System.out.println("Net Salary: $" + employee.getSalary());
        System.out.println("====================================");
    }

    @Override
    public double handleDeductions(Employee employee, double deduction) {
        if (employee == null) {
            System.out.println("✗ Error: Employee not found");
            return 0.0;
        }

        double baseSalary = employee.getSalary();
        double netSalary = baseSalary - deduction;

        System.out.println("\n--- Deduction Processing ---");
        System.out.println("Employee: " + employee.getName());
        System.out.println("Base Salary: $" + baseSalary);
        System.out.println("Deduction: $" + deduction);
        System.out.println("Net Salary: $" + netSalary);

        return netSalary;
    }
}
