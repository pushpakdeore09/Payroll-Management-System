package com.payrollBackend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "department")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer deptId;

    @Column(name = "dept_name")
    private String deptName;

    @Column(name = "emp_count")
    private Integer employeeCount;

    @OneToMany(mappedBy = "department")
    @JsonIgnore
    private List<Employee> employees;

    public Department() {
    }

    public Department(Integer deptId, String deptName, Integer employeeCount, List<Employee> employees) {
        this.deptId = deptId;
        this.deptName = deptName;
        this.employeeCount = employeeCount;
        this.employees = employees;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public Integer getEmployeeCount() {
        return employeeCount;
    }

    public void setEmployeeCount(Integer employeeCount) {
        this.employeeCount = employeeCount;
    }
}
