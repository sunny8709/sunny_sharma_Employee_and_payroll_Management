package com.employee.model;


public class ContractEmployee extends Employee {
    private int contractDuration;

    public ContractEmployee() {
        super();
    }

    public ContractEmployee(Long employeeId, String name, String department, double salary, int contractDuration) {
        super(employeeId, name, department, salary);
        this.contractDuration = contractDuration;
    }

    public int getContractDuration() {
        return contractDuration;
    }

    public void setContractDuration(int contractDuration) {
        this.contractDuration = contractDuration;
    }

    @Override
    public void displayDetails() {
        System.out.println("\n--- Contract Employee Details ---");
        System.out.println("Employee ID: " + getEmployeeId());
        System.out.println("Name: " + getName());
        System.out.println("Department: " + getDepartment());
        System.out.println("Salary: $" + getSalary());
        System.out.println("Contract Duration: " + contractDuration + " months");
        System.out.println("Attendance: " + getAttendanceDetails());
        System.out.println("Employment Type: Contract");
    }
}
