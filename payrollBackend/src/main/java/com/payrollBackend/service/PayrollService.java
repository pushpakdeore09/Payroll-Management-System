package com.payrollBackend.service;

import com.payrollBackend.dto.PayrollDTO;
import com.payrollBackend.model.Employee;
import com.payrollBackend.model.Payroll;
import com.payrollBackend.model.PayrollMonth;
import com.payrollBackend.repository.PayrollRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PayrollService {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private PayrollMonthService payrollMonthService;

    @Autowired
    private PayrollRepository payrollRepository;

    public ResponseEntity<String> createPayroll(PayrollDTO payrollDTO) throws Exception {
        Payroll oldPayroll = payrollRepository.findByPayrollName(payrollDTO.getPayrollName());
        if(oldPayroll != null){
            return new ResponseEntity<>("Payroll already exists", HttpStatus.CONFLICT);
        }
        Employee employee = employeeService.findByEmployeeId(payrollDTO.getEmployeeId());
        PayrollMonth payrollMonth = payrollMonthService.findPayrollMonth(payrollDTO.getMonthName(), payrollDTO.getYear());
        if(employee == null){
            return new ResponseEntity<>("Employee not found", HttpStatus.BAD_REQUEST);
        }
        if(payrollMonth == null){
            return new ResponseEntity<>("Payroll month not found", HttpStatus.BAD_REQUEST);
        }
        Payroll payroll = new Payroll();
        payroll.setPayrollMonth(payrollMonth);
        payroll.setEmployee(employee);
        payroll.setPayrollName(payrollDTO.getPayrollName());
        payrollRepository.save(payroll);
        return new ResponseEntity<>("Payroll created Successfully", HttpStatus.CREATED);
    }

    public ResponseEntity<?> findPayrollByName(String payrollName){
        Payroll payroll = payrollRepository.findByPayrollName(payrollName);
        if (payroll != null && payroll.getPayrollName().equalsIgnoreCase(payrollName)) {
            PayrollDTO payrollDTO = new PayrollDTO();
            payrollDTO.setPayrollName(payroll.getPayrollName());
            payrollDTO.setEmployeeId(payroll.getEmployee().getEmployeeId());
            payrollDTO.setMonthName(payroll.getPayrollMonth().getMonthName());
            payrollDTO.setYear(payroll.getPayrollMonth().getYear());

            return new ResponseEntity<>(payrollDTO, HttpStatus.OK);
        }
        return new ResponseEntity<>("Payroll not found", HttpStatus.BAD_REQUEST);
    }

}
