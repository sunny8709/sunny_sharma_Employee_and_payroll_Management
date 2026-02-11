package com.employee.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;

public class AttendanceService {
    private static final Logger logger = LoggerFactory.getLogger(AttendanceService.class);
    private HashMap<Long, List<String>> attendanceDatabase;

    public AttendanceService() {
        this.attendanceDatabase = new HashMap<>();
    }

    public void trackAttendance(Long employeeId, String date, boolean present) {
        if (employeeId == null || date == null) {
            logger.error("Invalid attendance data - Employee ID: {}, Date: {}", employeeId, date);
            return;
        }

        String record = date + " - " + (present ? "Present" : "Absent");

        attendanceDatabase.putIfAbsent(employeeId, new ArrayList<>());
        attendanceDatabase.get(employeeId).add(record);

        logger.info("Attendance recorded for Employee ID {}: {}", employeeId, record);
    }

    public List<String> viewAttendance(Long employeeId) {
        if (!attendanceDatabase.containsKey(employeeId)) {
            logger.warn("No attendance records found for Employee ID {}", employeeId);
            return new ArrayList<>();
        }

        return attendanceDatabase.get(employeeId);
    }

    public void generateAttendanceReport(Long employeeId) {
        logger.info("Generating attendance report for Employee ID: {}", employeeId);
        System.out.println("\n========== ATTENDANCE REPORT ==========");
        System.out.println("Employee ID: " + employeeId);

        List<String> records = viewAttendance(employeeId);

        if (records.isEmpty()) {
            System.out.println("No attendance records available.");
        } else {
            System.out.println("Total Records: " + records.size());
            System.out.println("\nAttendance History:");
            for (String record : records) {
                System.out.println("  " + record);
            }
        }

        System.out.println("=======================================");
    }
}
