package com.payrollBackend.controller;

import com.payrollBackend.dto.TaxDTO;
import com.payrollBackend.service.TaxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class TaxController {

    @Autowired
    private TaxService taxService;

    @PostMapping(value = "/addTax")
    public ResponseEntity<?> addTax(@RequestBody TaxDTO taxDTO){
        return taxService.addTax(taxDTO);
    }
	
}
