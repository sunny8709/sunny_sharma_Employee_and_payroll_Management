package com.employee.model;


public class FullTimeEmployee extends Employee {
    private String benefits;

    public FullTimeEmployee() {
        super();
    }

    public FullTimeEmployee(Long employeeId, String name, String department, double salary, String benefits) {
        super(employeeId, name, department, salary);
        this.benefits = benefits;
    }

    public String getBenefits() {
        return benefits;
    }

    public void setBenefits(String benefits) {
        this.benefits = benefits;
    }

    @Override
    public void displayDetails() {
        System.out.println("\n--- Full-Time Employee Details ---");
        System.out.println("Employee ID: " + getEmployeeId());
        System.out.println("Name: " + getName());
        System.out.println("Department: " + getDepartment());
        System.out.println("Salary: $" + getSalary());
        System.out.println("Benefits: " + benefits);
        System.out.println("Attendance: " + getAttendanceDetails());
        System.out.println("Employment Type: Full-Time");
    }
}
