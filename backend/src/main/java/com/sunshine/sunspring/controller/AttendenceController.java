package com.sunshine.sunspring.controller;

import java.time.LocalDate;
import java.util.*;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sunshine.sunspring.model.*;
import com.sunshine.sunspring.repository.*;

@RestController
@RequestMapping("api/attendence")
@CrossOrigin(origins = "*")
public class AttendenceController {

    private final EmployeeRepository er;
    private final AttendenceRepository ar;

    public AttendenceController(EmployeeRepository er, AttendenceRepository ar) {
        this.er = er;
        this.ar = ar;
    }

    // ✅ POST /api/attendence/mark?employeeId=EMP001
    @PostMapping("/mark")
    public ResponseEntity<Map<String, String>> markAttendance(@RequestParam("employeeId") String employeeId) {
        Map<String, String> response = new HashMap<>();

        Optional<Employee> optionalEmp = er.findByEmployeeId(employeeId);
        if (optionalEmp.isEmpty()) {
            response.put("message", "❌ Employee ID not found: " + employeeId);
            return ResponseEntity.status(404).body(response);
        }

        Employee employee = optionalEmp.get();
        boolean alreadyMarked = ar.existsByEmployeeAndDate(employee, LocalDate.now());

        if (alreadyMarked) {
            response.put("message", "⚠️ Attendance already marked today for ID: " + employeeId);
            return ResponseEntity.status(409).body(response);
        }

        Attendence attendance = new Attendence();
        attendance.setEmployee(employee);
        attendance.setDate(LocalDate.now());
        ar.save(attendance);

        response.put("message", "✅ Attendance marked for employee ID: " + employeeId);
        return ResponseEntity.ok(response);
    }

    // ✅ GET /api/attendence/all
    @GetMapping("/all")
    public ResponseEntity<List<Attendence>> getAllAttendence() {
        return ResponseEntity.ok(ar.findAll());
    }
}
