package com.payrollBackend.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "payrollmonth")
public class PayrollMonth implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer payrollMonthId;

    @Column(name = "month_name", nullable = false)
    private String monthName;

    @Column(name = "start_date", nullable = false)
    private String startDate;

    @Column(name = "end_date", nullable = false)
    private String endDate;

    @OneToMany(mappedBy = "payrollMonth")
    private List<Payroll> payrolls;

    public PayrollMonth() {
    }

    public PayrollMonth(Integer payrollMonthId, String monthName, String startDate, String endDate, List<Payroll> payrolls) {
        this.payrollMonthId = payrollMonthId;
        this.monthName = monthName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.payrolls = payrolls;
    }

    public Integer getPayrollMonthId() {
        return payrollMonthId;
    }

    public void setPayrollMonthId(Integer payrollMonthId) {
        this.payrollMonthId = payrollMonthId;
    }

    public String getMonthName() {
        return monthName;
    }

    public void setMonthName(String monthName) {
        this.monthName = monthName;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public List<Payroll> getPayrolls() {
        return payrolls;
    }

    public void setPayrolls(List<Payroll> payrolls) {
        this.payrolls = payrolls;
    }
}

