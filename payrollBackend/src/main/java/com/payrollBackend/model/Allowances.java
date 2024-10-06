package com.payrollBackend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "allowances")
public class Allowances {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer allowanceId;

    @Column(name = "allowance_name")
    private String allowancesName;

    @Column(name = "allowance_percent")
    private Double allowancePercentage;

    @ManyToOne
    @JoinColumn(name = "payroll_id", referencedColumnName = "payrollId")
    private Payroll payroll;

    public Allowances() {
    }

    public Allowances(Integer allowanceId, Double allowancePercentage, String allowancesName, Payroll payroll) {
        this.allowanceId = allowanceId;
        this.allowancePercentage = allowancePercentage;
        this.allowancesName = allowancesName;
        this.payroll = payroll;
    }

    public Integer getAllowanceId() {
        return allowanceId;
    }

    public void setAllowanceId(Integer allowanceId) {
        this.allowanceId = allowanceId;
    }

    public Double getAllowancePercentage() {
        return allowancePercentage;
    }

    public void setAllowancePercentage(Double allowancePercentage) {
        this.allowancePercentage = allowancePercentage;
    }

    public String getAllowancesName() {
        return allowancesName;
    }

    public void setAllowancesName(String allowancesName) {
        this.allowancesName = allowancesName;
    }

    public Payroll getPayroll() {
        return payroll;
    }

    public void setPayroll(Payroll payroll) {
        this.payroll = payroll;
    }
}
