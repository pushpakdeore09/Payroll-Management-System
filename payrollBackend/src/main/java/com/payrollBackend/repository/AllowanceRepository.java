package com.payrollBackend.repository;

import com.payrollBackend.model.Allowances;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AllowanceRepository extends JpaRepository<Allowances, Integer> {
    Allowances findByAllowanceName(String allowanceName);
    List<Allowances> findByEmployee_EmployeeId(Integer employeeId);


}
