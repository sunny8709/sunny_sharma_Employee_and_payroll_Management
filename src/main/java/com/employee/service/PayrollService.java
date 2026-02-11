package com.employee.service;

import com.employee.model.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PayrollService implements PayrollOperations {
    private static final Logger logger = LoggerFactory.getLogger(PayrollService.class);

    @Override
    public double calculateSalary(Employee employee) {
        if (employee == null) {
            logger.error("Cannot calculate salary: Employee not found");
            return 0.0;
        }

        double baseSalary = employee.getSalary();
        logger.debug("Salary calculation - Employee: {}, Base Salary: ${}", employee.getName(), baseSalary);

        return baseSalary;
    }

    @Override
    public void generatePayrollReport(Employee employee) {
        if (employee == null) {
            logger.error("Cannot generate payroll report: Employee not found");
            return;
        }

        logger.info("Generating payroll report for Employee ID: {}, Name: {}", employee.getEmployeeId(),
                employee.getName());
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
            logger.error("Cannot handle deductions: Employee not found");
            return 0.0;
        }

        double baseSalary = employee.getSalary();
        double netSalary = baseSalary - deduction;

        logger.debug("Deduction processing - Employee: {}, Base: ${}, Deduction: ${}, Net: ${}",
                employee.getName(), baseSalary, deduction, netSalary);

        return netSalary;
    }
}
