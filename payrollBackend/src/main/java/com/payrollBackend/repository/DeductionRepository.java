package com.payrollBackend.repository;

import com.payrollBackend.model.Deductions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeductionRepository extends JpaRepository<Deductions, Integer> {
    Deductions findByDeductionName(String deductionName);
    List<Deductions> findByEmployee_EmployeeId(Integer employeeId);
}
