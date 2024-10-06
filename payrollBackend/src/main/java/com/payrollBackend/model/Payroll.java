package com.payrollBackend.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "payroll")
public class Payroll {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer payrollId;

    @Column(name = "payroll_name")
    private String payrollName;

    @Column(name = "employee_id", nullable = false)
    private Employee employee;

    @Column(name = "payrollmonth_id", nullable = false)
    private PayrollMonth payrollMonth;

    @Column(name = "net_salary")
    private Double netSalary;

    @OneToMany(mappedBy = "payroll", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Allowances> allowances;

    @OneToMany(mappedBy = "payroll", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Deductions> deductions;

    @OneToMany(mappedBy = "payroll", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Tax> taxes;

    public Payroll() {
    }

    public Payroll(List<Allowances> allowances, List<Deductions> deductions, Employee employee, Double netSalary, Integer payrollId, PayrollMonth payrollMonth, String payrollName, List<Tax> taxes) {
        this.allowances = allowances;
        this.deductions = deductions;
        this.employee = employee;
        this.netSalary = netSalary;
        this.payrollId = payrollId;
        this.payrollMonth = payrollMonth;
        this.payrollName = payrollName;
        this.taxes = taxes;
    }

    public List<Allowances> getAllowances() {
        return allowances;
    }

    public void setAllowances(List<Allowances> allowances) {
        this.allowances = allowances;
    }

    public List<Deductions> getDeductions() {
        return deductions;
    }

    public void setDeductions(List<Deductions> deductions) {
        this.deductions = deductions;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Double getNetSalary() {
        return netSalary;
    }

    public void setNetSalary(Double netSalary) {
        this.netSalary = netSalary;
    }

    public Integer getPayrollId() {
        return payrollId;
    }

    public void setPayrollId(Integer payrollId) {
        this.payrollId = payrollId;
    }

    public PayrollMonth getPayrollMonth() {
        return payrollMonth;
    }

    public void setPayrollMonth(PayrollMonth payrollMonth) {
        this.payrollMonth = payrollMonth;
    }

    public String getPayrollName() {
        return payrollName;
    }

    public void setPayrollName(String payrollName) {
        this.payrollName = payrollName;
    }

    public List<Tax> getTaxes() {
        return taxes;
    }

    public void setTaxes(List<Tax> taxes) {
        this.taxes = taxes;
    }
}
