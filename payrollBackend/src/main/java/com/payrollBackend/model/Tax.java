package com.payrollBackend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tax")
public class Tax {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer taxId;

    @Column(name = "tax_name", nullable = false)
    private String taxName;

    @Column(name = "tax_percent", nullable = false)
    private Double taxPercentage;

    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;

    public Tax() {
    }

    public Tax(Integer taxId, String taxName, Double taxPercentage, Employee employee) {
        this.taxId = taxId;
        this.taxName = taxName;
        this.taxPercentage = taxPercentage;
        this.employee = employee;
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

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
