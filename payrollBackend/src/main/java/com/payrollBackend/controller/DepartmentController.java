package com.payrollBackend.controller;

import com.payrollBackend.model.Department;
import com.payrollBackend.repository.DepartmentRepository;
import com.payrollBackend.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private DepartmentRepository departmentRepository;

    @PostMapping(value = "/department")
    public ResponseEntity<String> addDepartment(@RequestBody Department department){
        return departmentService.createDepartment(department);
    }

    @DeleteMapping(value = "/department/{deptId}")
    public ResponseEntity<String> removeDepartment(@RequestParam Integer deptId){
        return departmentService.deleteDepartment(deptId);
    }
}
