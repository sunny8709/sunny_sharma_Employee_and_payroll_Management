# Employee Management & Payroll System

A pure Java console-based application demonstrating Object-Oriented Programming principles.

## Project Overview

This system manages employee records, attendance tracking, and payroll processing using only **Java OOP concepts** and **Maven** - no frameworks.

## OOP Concepts Demonstrated

### 1. Encapsulation
- **Employee** class uses private fields with public getters/setters
- Data hiding using access modifiers

### 2. Inheritance
- **Employee** (Base Class)
  - FullTimeEmployee
  - PartTimeEmployee
  - ContractEmployee

### 3. Polymorphism
- Method overriding: `displayDetails()` method in each employee subclass
- Different behavior for each employee type

### 4. Abstraction
- **PayrollOperations** interface
- Implemented by **PayrollService** class

## Project Structure

```
src/main/java/com/employee/
├── App.java                          # Main entry point
├── controller/
│   └── MainMenu.java                 # Dashboard & navigation
├── service/
│   ├── LoginService.java             # User login
│   ├── AuthService.java              # Credential validation
│   ├── EmployeeService.java          # CRUD operations
│   ├── PayrollService.java           # Payroll processing
│   ├── AttendanceService.java        # Attendance tracking
│   └── PayrollOperations.java        # Interface (abstraction)
├── model/
│   ├── Employee.java                 # Base class
│   ├── FullTimeEmployee.java         # Inheritance
│   ├── PartTimeEmployee.java         # Inheritance
│   └── ContractEmployee.java         # Inheritance
└── repository/
    └── EmployeeRepository.java       # In-memory data storage
```

## System Workflow

1. **User Login** → Enter credentials
2. **Credential Validation** → AuthService validates
3. **Dashboard** → MainMenu displays options
4. **Operations:**
   - Employee Management (Add, View, Update, Delete)
   - Attendance Tracking
   - Payroll Processing

## How to Run

### Prerequisites
- Java 17 or higher
- Maven (optional - can compile with javac)

## Default Login Credentials

- **Username:** admin
- **Password:** admin123

## Features

### Employee Management
- Add employees (Full-Time, Part-Time, Contract)
- View employee details
- Update employee information
- Delete employee records

### Attendance Tracking
- Mark attendance (Present/Absent)
- View attendance logs
- Generate attendance reports

### Payroll Processing
- Calculate employee salary
- Generate payroll reports
- Apply deductions and allowances

## Technologies Used

- **Language:** Pure Java 17
- **Build Tool:** Maven
- **Data Storage:** In-memory (HashMap)
- **Architecture:** Layered (Controller, Service, Repository, Model)

