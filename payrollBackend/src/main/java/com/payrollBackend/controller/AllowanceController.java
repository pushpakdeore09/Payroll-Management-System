package com.payrollBackend.controller;

import com.payrollBackend.dto.AllowanceDTO;
import com.payrollBackend.model.Allowances;
import com.payrollBackend.service.AllowanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class AllowanceController {

    @Autowired
    private AllowanceService allowanceService;

    @PostMapping(value = "/addAllowance")
    public ResponseEntity<?> addAllowance(@RequestBody AllowanceDTO allowanceDTO){
        return allowanceService.addAllowance(allowanceDTO);
    }

    @GetMapping(value = "/allowances/{employeeId}")
    public ResponseEntity<?> getAllowances(@PathVariable Integer employeeId){
        return allowanceService.getAllowancesByEmployeeId(employeeId);
    }
}
