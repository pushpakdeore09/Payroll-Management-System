package com.payrollBackend.model;

import jakarta.persistence.*;


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

    public Payroll() {
    }

    public Payroll(Employee employee, Double netSalary, Integer payrollId, PayrollMonth payrollMonth, String payrollName) {
        this.employee = employee;
        this.netSalary = netSalary;
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

}
