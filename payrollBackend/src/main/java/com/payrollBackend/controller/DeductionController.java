package com.payrollBackend.controller;

import com.payrollBackend.dto.DeductionDTO;
import com.payrollBackend.service.DeductionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class DeductionController {

    @Autowired
    private DeductionService deductionService;

    @PostMapping(value = "/addDeduction")
    public ResponseEntity<?> addDeduction(@RequestBody DeductionDTO deductionDTO){
        return deductionService.addDeduction(deductionDTO);
    }
}
