package com.payrollBackend.repository;

import com.payrollBackend.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {
    public Department findByDeptName(String deptName);
}
