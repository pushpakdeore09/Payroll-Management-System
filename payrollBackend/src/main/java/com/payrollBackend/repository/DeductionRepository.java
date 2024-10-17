package com.payrollBackend.repository;

import com.payrollBackend.model.Deductions;
import com.payrollBackend.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DeductionRepository extends JpaRepository<Deductions, Integer> {
    Deductions findByDeductionName(String deductionName);
    List<Deductions> findByEmployee_EmployeeId(Integer employeeId);
    List<Deductions> findByEmployee(Employee employee);
    Optional<Deductions> findByDeductionNameAndEmployeeEmployeeId(String deductionName, Integer employeeId);
}
