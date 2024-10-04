package com.payrollBackend.repository;

import com.payrollBackend.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    Employee findByEmail(String email);

    Integer countByDepartment_DeptId(Integer deptId);
}
