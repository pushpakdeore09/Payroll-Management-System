package com.payrollBackend.controller;

import com.payrollBackend.dto.PayrollDTO;
import com.payrollBackend.service.PayrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class PayrollController {


    @Autowired
    private PayrollService payrollService;

    @PostMapping(value = "/addPayroll")
    public ResponseEntity<String> addPayroll(@RequestBody PayrollDTO payrollDTO) throws Exception {
        return payrollService.createPayroll(payrollDTO);
    }
}
