package com.payrollBackend.controller;

import com.payrollBackend.model.Employee;
import com.payrollBackend.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;


    @GetMapping(value = "/employees")
    public ResponseEntity<List<Employee>> findAllEmployees() {
        List<Employee> employees = employeeService.findAllEmployees();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @PostMapping(value = "/addEmployee")
    public ResponseEntity<Map<String, Object>> createEmployee(@RequestBody Employee employee) {
        return employeeService.addEmployee(employee);
    }

    @DeleteMapping(value = "/employee/{employeeId}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Integer employeeId) throws Exception{
        return employeeService.removeEmployee(employeeId);
    }

    @GetMapping(value = "/employee/{employeeId}")
    public ResponseEntity<?> searchEmployee(@PathVariable Integer employeeId) throws Exception {
        return employeeService.findEmployee(employeeId);
    }

    @PutMapping(value = "/employee")
    public ResponseEntity<?> updateEmployee(@RequestBody Employee employee) throws Exception {
        return employeeService.editEmployeeDetails(employee);
    }
}
