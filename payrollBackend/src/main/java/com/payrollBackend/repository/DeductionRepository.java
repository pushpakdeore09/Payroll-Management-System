package com.payrollBackend.repository;

import com.payrollBackend.model.Deductions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeductionRepository extends JpaRepository<Deductions, Integer> {
    Deductions findByDeductionName(String deductionName);
}
