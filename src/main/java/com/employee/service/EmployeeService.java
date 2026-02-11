package com.employee.service;

import com.employee.model.Employee;
import com.employee.repository.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;

public class EmployeeService {
    private static final Logger logger = LoggerFactory.getLogger(EmployeeService.class);
    private EmployeeRepository employeeRepository;

    public EmployeeService() {
        this.employeeRepository = new EmployeeRepository();
    }

    public void addEmployee(Employee employee) {
        if (employee == null || employee.getEmployeeId() == null) {
            logger.error("Invalid employee data");
            return;
        }

        if (employeeRepository.exists(employee.getEmployeeId())) {
            logger.error("Employee with ID {} already exists", employee.getEmployeeId());
            return;
        }

        employeeRepository.save(employee);
        logger.info("Employee added successfully: {}", employee.getName());
    }

    public Employee viewEmployee(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId);
        if (employee == null) {
            logger.error("Employee with ID {} not found", employeeId);
        }
        return employee;
    }

    public List<Employee> viewAllEmployees() {
        return employeeRepository.findAll();
    }

    public void updateEmployee(Long employeeId, Employee updatedEmployee) {
        if (!employeeRepository.exists(employeeId)) {
            logger.error("Employee with ID {} not found", employeeId);
            return;
        }

        updatedEmployee.setEmployeeId(employeeId);
        employeeRepository.update(employeeId, updatedEmployee);
        logger.info("Employee updated successfully: ID {}", employeeId);
    }

    public void deleteEmployee(Long employeeId) {
        if (!employeeRepository.exists(employeeId)) {
            logger.error("Employee with ID {} not found", employeeId);
            return;
        }

        employeeRepository.delete(employeeId);
        logger.info("Employee deleted successfully: ID {}", employeeId);
    }
}
