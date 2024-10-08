package com.payrollBackend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "deductions")
public class Deductions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer deductionId;

    @Column(name = "deduction_name", nullable = false)
    private String deductionName;

    @Column(name = "deduction_percent", nullable = false)
    private Double deductionPercentage;

    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;

    public Deductions() {
    }

    public Deductions(Integer deductionId, String deductionName, Double deductionPercentage, Employee employee) {
        this.deductionId = deductionId;
        this.deductionName = deductionName;
        this.deductionPercentage = deductionPercentage;
        this.employee = employee;
    }

    public Integer getDeductionId() {
        return deductionId;
    }

    public void setDeductionId(Integer deductionId) {
        this.deductionId = deductionId;
    }

    public String getDeductionName() {
        return deductionName;
    }

    public void setDeductionName(String deductionName) {
        this.deductionName = deductionName;
    }

    public Double getDeductionPercentage() {
        return deductionPercentage;
    }

    public void setDeductionPercentage(Double deductionPercentage) {
        this.deductionPercentage = deductionPercentage;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
