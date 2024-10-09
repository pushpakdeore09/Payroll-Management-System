package com.payrollBackend.service;

import com.payrollBackend.model.PayrollMonth;
import com.payrollBackend.repository.PayrollMonthRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class PayrollMonthService {

    private PayrollMonthRepository payrollMonthRepository;

    public ResponseEntity<?> addPayrollMonth(PayrollMonth payrollMonth){
        Optional<PayrollMonth> oldPayrollMonth = payrollMonthRepository.findById(payrollMonth.getPayrollMonthId());
        PayrollMonth existingPayrollMonth = oldPayrollMonth.get();
        if (Objects.equals(existingPayrollMonth.getYear(), payrollMonth.getYear()) &&
                Objects.equals(existingPayrollMonth.getStartDate(), payrollMonth.getStartDate()) &&
                Objects.equals(existingPayrollMonth.getEndDate(), payrollMonth.getEndDate())) {

            return new ResponseEntity<>("Payroll Month already exists", HttpStatus.BAD_REQUEST);
        }

        PayrollMonth newPayrollMonth = new PayrollMonth();
        newPayrollMonth.setMonthName(payrollMonth.getMonthName());
        newPayrollMonth.setStartDate(payrollMonth.getStartDate());
        newPayrollMonth.setEndDate(payrollMonth.getEndDate());
        newPayrollMonth.setYear(payrollMonth.getYear());
        payrollMonthRepository.save(newPayrollMonth);

        return new ResponseEntity<>("Payroll Month Saved", HttpStatus.OK);
    }
}
