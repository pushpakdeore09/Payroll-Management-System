package com.payrollBackend.repository;

import com.payrollBackend.dto.PayrollDTO;
import com.payrollBackend.model.Payroll;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PayrollRepository extends JpaRepository<Payroll, Integer> {
    Payroll findByPayrollName(String payrollName);
}
