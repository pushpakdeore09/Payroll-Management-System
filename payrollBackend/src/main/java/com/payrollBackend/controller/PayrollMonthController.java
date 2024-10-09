package com.payrollBackend.controller;

import com.payrollBackend.model.PayrollMonth;
import com.payrollBackend.service.PayrollMonthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class PayrollMonthController {

    @Autowired
    private PayrollMonthService payrollMonthService;

    @PostMapping(value = "/addPayrollMonth")
    public ResponseEntity<?> addPayrollMonth(@RequestBody PayrollMonth payrollMonth){
        return payrollMonthService.addPayrollMonth(payrollMonth);
    }
}
