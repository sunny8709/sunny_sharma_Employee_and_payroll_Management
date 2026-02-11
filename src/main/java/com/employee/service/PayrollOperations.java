package com.employee.service;

import com.employee.model.Employee;


public interface PayrollOperations {
    
    double calculateSalary(Employee employee);
    
    void generatePayrollReport(Employee employee);
    
    double handleDeductions(Employee employee, double deduction);
}
