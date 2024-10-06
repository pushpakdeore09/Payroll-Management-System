package com.payrollBackend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "deductions")
public class Deductions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer deductionId;

    @Column(name = "deduction_name")
    private String deductionName;

    @Column(name = "deduction_percent")
    private Double deductionPercentage;

    @ManyToOne
    @JoinColumn(name = "payroll_id", referencedColumnName = "payrollId")
    private Payroll payroll;

    public Deductions() {
    }

    public Deductions(Integer deductionId, String deductionName, Double deductionPercentage, Payroll payroll) {
        this.deductionId = deductionId;
        this.deductionName = deductionName;
        this.deductionPercentage = deductionPercentage;
        this.payroll = payroll;
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

    public Payroll getPayroll() {
        return payroll;
    }

    public void setPayroll(Payroll payroll) {
        this.payroll = payroll;
    }
}
