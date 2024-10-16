package com.payrollBackend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;


@Entity
@Table(name = "payroll")
public class Payroll {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer payrollId;

    @Column(name = "payroll_name")
    private String payrollName;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    @JsonIgnore
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonIgnore
    @JoinColumn(name = "payrollmonth_id", nullable = false)
    private PayrollMonth payrollMonth;


    public Payroll() {
    }

    public Payroll(Employee employee, Integer payrollId, PayrollMonth payrollMonth, String payrollName) {
        this.employee = employee;
        this.payrollId = payrollId;
        this.payrollMonth = payrollMonth;
        this.payrollName = payrollName;
    }


    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
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

}
