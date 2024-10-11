package com.payrollBackend.controller;

import com.payrollBackend.model.PayrollMonth;
import com.payrollBackend.service.PayrollMonthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class PayrollMonthController {

    @Autowired
    private PayrollMonthService payrollMonthService;

    @PostMapping(value = "/addPayrollMonth")
    public ResponseEntity<?> addPayrollMonth(@RequestBody PayrollMonth payrollMonth){
        return payrollMonthService.addPayrollMonth(payrollMonth);
    }

    @GetMapping(value = "/payrollMonth/{monthName}/{year}")
    public ResponseEntity<?> searchPayrollMonth(@PathVariable String monthName, @PathVariable Integer year){
        return payrollMonthService.getPayrollMonths(monthName, year);
    }
}
