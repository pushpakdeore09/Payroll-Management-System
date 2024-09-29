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

    @Column(name = "tax")
    private Double tax;

    @Column(name = "provident_fund")
    private Double providentFund;

    @Column(name = "eobi")
    private Double eobi;

    @Column(name = "gratuity")
    private Double gratuity;

    @Column(name = "bonus")
    private Double bonus;

    @Column(name = "total_deductions")
    private Double totalDeductions;

    @Column(name = "net_salary")
    private Double netSalary;

    @Column(name = "final_salary")
    private Double finalSalary;

    @ManyToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "employeeId")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "payrollmonth_id", referencedColumnName = "payrollmonthId")
    private PayrollMonth payrollmonth;

    public Payroll() {
    }

    public Payroll(Integer payrollId, String payrollName, Double tax, Double providentFund, Double eobi, Double gratuity, Double bonus, Double totalDeductions, Double netSalary, Double finalSalary, Employee employee, PayrollMonth payrollmonth) {
        this.payrollId = payrollId;
        this.payrollName = payrollName;
        this.tax = tax;
        this.providentFund = providentFund;
        this.eobi = eobi;
        this.gratuity = gratuity;
        this.bonus = bonus;
        this.totalDeductions = totalDeductions;
        this.netSalary = netSalary;
        this.finalSalary = finalSalary;
        this.employee = employee;
        this.payrollmonth = payrollmonth;
    }

    public Integer getPayrollId() {
        return payrollId;
    }

    public void setPayrollId(Integer payrollId) {
        this.payrollId = payrollId;
    }

    public String getPayrollName() {
        return payrollName;
    }

    public void setPayrollName(String payrollName) {
        this.payrollName = payrollName;
    }

    public Double getTax() {
        return tax;
    }

    public void setTax(Double tax) {
        this.tax = tax;
    }

    public Double getProvidentFund() {
        return providentFund;
    }

    public void setProvidentFund(Double providentFund) {
        this.providentFund = providentFund;
    }

    public Double getEobi() {
        return eobi;
    }

    public void setEobi(Double eobi) {
        this.eobi = eobi;
    }

    public Double getGratuity() {
        return gratuity;
    }

    public void setGratuity(Double gratuity) {
        this.gratuity = gratuity;
    }

    public Double getBonus() {
        return bonus;
    }

    public void setBonus(Double bonus) {
        this.bonus = bonus;
    }

    public Double getTotalDeductions() {
        return totalDeductions;
    }

    public void setTotalDeductions(Double totalDeductions) {
        this.totalDeductions = totalDeductions;
    }

    public Double getNetSalary() {
        return netSalary;
    }

    public void setNetSalary(Double netSalary) {
        this.netSalary = netSalary;
    }

    public Double getFinalSalary() {
        return finalSalary;
    }

    public void setFinalSalary(Double finalSalary) {
        this.finalSalary = finalSalary;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public PayrollMonth getPayrollMonth() {
        return payrollmonth;
    }

    public void setPayrollMonth(PayrollMonth payrollMonth) {
        this.payrollmonth = payrollMonth;
    }
}
