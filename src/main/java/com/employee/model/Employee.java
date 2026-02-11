package com.employee.model;


public class Employee {
    private Long employeeId;
    private String name;
    private String department;
    private double salary;
    private String attendanceDetails;

    public Employee() {
    }

    public Employee(Long employeeId, String name, String department, double salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.department = department;
        this.salary = salary;
        this.attendanceDetails = "No attendance recorded";
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getAttendanceDetails() {
        return attendanceDetails;
    }

    public void setAttendanceDetails(String attendanceDetails) {
        this.attendanceDetails = attendanceDetails;
    }

    public void displayDetails() {
        System.out.println("\n--- Employee Details ---");
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Name: " + name);
        System.out.println("Department: " + department);
        System.out.println("Salary: $" + salary);
        System.out.println("Attendance: " + attendanceDetails);
    }
}
