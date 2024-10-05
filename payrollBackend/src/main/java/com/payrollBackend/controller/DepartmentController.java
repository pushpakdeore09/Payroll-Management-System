package com.payrollBackend.controller;

import com.payrollBackend.model.Department;
import com.payrollBackend.repository.DepartmentRepository;
import com.payrollBackend.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private DepartmentRepository departmentRepository;

    @GetMapping(value = "/departments")
    public ResponseEntity<List<Department>> findAllDepartment(){
        List<Department> departments =departmentService.findAllDepartment();
        return new ResponseEntity<>(departments, HttpStatus.OK);
    }


    @PostMapping(value = "/department")
    public ResponseEntity<String> addDepartment(@RequestBody Department department){
        return departmentService.createDepartment(department);
    }

    @DeleteMapping(value = "/department/{deptId}")
    public ResponseEntity<String> removeDepartment(@PathVariable Integer deptId) throws Exception{
        return departmentService.deleteDepartment(deptId);
    }

    @GetMapping(value = "/department/{deptName}")
    public ResponseEntity<?> findDeptByName(@PathVariable String deptName){
        return departmentService.findDepartmentByName(deptName);
    }
}
