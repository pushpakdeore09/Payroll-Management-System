package com.payrollBackend.repository;

import com.payrollBackend.model.Allowances;
import com.payrollBackend.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AllowanceRepository extends JpaRepository<Allowances, Integer> {
    Allowances findByAllowanceName(String allowanceName);
    List<Allowances> findByEmployee_EmployeeId(Integer employeeId);
    List<Allowances> findByEmployee(Employee employee);
    Optional<Allowances> findByAllowanceNameAndEmployeeEmployeeId(String allowanceName, Integer employeeId);
}
