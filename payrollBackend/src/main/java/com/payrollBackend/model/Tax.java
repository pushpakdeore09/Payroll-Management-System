package com.payrollBackend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tax")
public class Tax {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer taxId;

    @Column(name = "tax_name")
    private String taxName;

    @Column(name = "tax_percent")
    private Double taxPercentage;

    @ManyToOne
    @JoinColumn(name = "payroll_id", referencedColumnName = "payrollId")
    private Payroll payroll;

    public Tax() {
    }

    public Tax(Payroll payroll, Integer taxId, String taxName, Double taxPercentage) {
        this.payroll = payroll;
        this.taxId = taxId;
        this.taxName = taxName;
        this.taxPercentage = taxPercentage;
    }

    public Payroll getPayroll() {
        return payroll;
    }

    public void setPayroll(Payroll payroll) {
        this.payroll = payroll;
    }

    public Integer getTaxId() {
        return taxId;
    }

    public void setTaxId(Integer taxId) {
        this.taxId = taxId;
    }

    public String getTaxName() {
        return taxName;
    }

    public void setTaxName(String taxName) {
        this.taxName = taxName;
    }

    public Double getTaxPercentage() {
        return taxPercentage;
    }

    public void setTaxPercentage(Double taxPercentage) {
        this.taxPercentage = taxPercentage;
    }
}
