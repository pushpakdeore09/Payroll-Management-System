package com.payrollBackend.controller;

import com.payrollBackend.model.Employee;
import com.payrollBackend.repository.EmployeeRepository;
import com.payrollBackend.service.EmployeeService;
import org.hibernate.dialect.H2Dialect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;


    @GetMapping(value = "/employees")
    public ResponseEntity<List<Employee>> findAllEmployees() {
        List<Employee> employees = employeeService.findAllEmployees();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @PostMapping(value = "/addEmployee")
    public ResponseEntity<String> createEmployee(@RequestBody Employee employee) {
    	System.out.println("Department Details: "+employee.getDepartment());
        return employeeService.addEmployee(employee);
    }

    @DeleteMapping(value = "/employee/{employeeId}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Integer employeeId) throws Exception{

        return employeeService.removeEmployee(employeeId);
    }
}
