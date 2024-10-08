package com.payrollBackend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "allowances")
public class Allowances {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer allowanceId;

    @Column(name = "allowance_name", nullable = false)
    private String allowanceName;

    @Column(name = "allowance_percent", nullable = false)
    private Double allowancePercentage;

    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;

    public Allowances() {
    }

    public Allowances(Integer allowanceId, Double allowancePercentage, String allowanceName, Employee employee) {
        this.allowanceId = allowanceId;
        this.allowancePercentage = allowancePercentage;
        this.allowanceName = allowanceName;
        this.employee = employee;
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

    public String getAllowanceName() {
        return allowanceName;
    }

    public void setAllowanceName(String allowancesName) {
        this.allowanceName = allowancesName;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
