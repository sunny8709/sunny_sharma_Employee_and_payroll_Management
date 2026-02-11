package com.employee.repository;

import com.employee.model.Employee;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;


public class EmployeeRepository {
    private HashMap<Long, Employee> employeeDatabase;

    public EmployeeRepository() {
        this.employeeDatabase = new HashMap<>();
    }

    public void save(Employee employee) {
        employeeDatabase.put(employee.getEmployeeId(), employee);
    }

    public Employee findById(Long id) {
        return employeeDatabase.get(id);
    }

    public List<Employee> findAll() {
        return new ArrayList<>(employeeDatabase.values());
    }

    public void update(Long id, Employee employee) {
        if (employeeDatabase.containsKey(id)) {
            employeeDatabase.put(id, employee);
        }
    }

    public void delete(Long id) {
        employeeDatabase.remove(id);
    }

    public boolean exists(Long id) {
        return employeeDatabase.containsKey(id);
    }
}
