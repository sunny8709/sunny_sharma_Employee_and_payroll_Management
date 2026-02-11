package com.employee.service;

import com.employee.model.Employee;
import com.employee.repository.EmployeeRepository;
import java.util.List;


public class EmployeeService {
    private EmployeeRepository employeeRepository;

    public EmployeeService() {
        this.employeeRepository = new EmployeeRepository();
    }

    public void addEmployee(Employee employee) {
        if (employee == null || employee.getEmployeeId() == null) {
            System.out.println("✗ Error: Invalid employee data");
            return;
        }

        if (employeeRepository.exists(employee.getEmployeeId())) {
            System.out.println("✗ Error: Employee with ID " + employee.getEmployeeId() + " already exists");
            return;
        }

        employeeRepository.save(employee);
        System.out.println("✓ Employee added successfully!");
    }

    public Employee viewEmployee(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId);
        if (employee == null) {
            System.out.println("✗ Error: Employee with ID " + employeeId + " not found");
        }
        return employee;
    }

    public List<Employee> viewAllEmployees() {
        return employeeRepository.findAll();
    }

    public void updateEmployee(Long employeeId, Employee updatedEmployee) {
        if (!employeeRepository.exists(employeeId)) {
            System.out.println("✗ Error: Employee with ID " + employeeId + " not found");
            return;
        }

        updatedEmployee.setEmployeeId(employeeId);
        employeeRepository.update(employeeId, updatedEmployee);
        System.out.println("✓ Employee updated successfully!");
    }

    public void deleteEmployee(Long employeeId) {
        if (!employeeRepository.exists(employeeId)) {
            System.out.println("✗ Error: Employee with ID " + employeeId + " not found");
            return;
        }

        employeeRepository.delete(employeeId);
        System.out.println("✓ Employee deleted successfully!");
    }
}
