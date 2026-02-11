package com.employee.model;


public class PartTimeEmployee extends Employee {
    private int hoursWorked;

    public PartTimeEmployee() {
        super();
    }

    public PartTimeEmployee(Long employeeId, String name, String department, double salary, int hoursWorked) {
        super(employeeId, name, department, salary);
        this.hoursWorked = hoursWorked;
    }

    public int getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(int hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    @Override
    public void displayDetails() {
        System.out.println("\n--- Part-Time Employee Details ---");
        System.out.println("Employee ID: " + getEmployeeId());
        System.out.println("Name: " + getName());
        System.out.println("Department: " + getDepartment());
        System.out.println("Salary: $" + getSalary());
        System.out.println("Hours Worked: " + hoursWorked + " hours/week");
        System.out.println("Attendance: " + getAttendanceDetails());
        System.out.println("Employment Type: Part-Time");
    }
}
