package com.payrollBackend.controller;

import com.payrollBackend.model.Employee;
import com.payrollBackend.repository.EmployeeRepository;
import com.payrollBackend.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private EmployeeRepository employeeRepository;

    @PostMapping(value = "/addEmployee")
    public ResponseEntity<String> createEmployee(@RequestBody Employee employee) {
        return employeeService.addEmployee(employee);
    }

    @DeleteMapping(value = "/employee/{employeeId}")
    public ResponseEntity<String> deleteEmployee(@RequestParam Integer employeeId) {


        return null;
    }
}
