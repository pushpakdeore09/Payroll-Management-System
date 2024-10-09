package com.payrollBackend.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;
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
    private Date startDate;

    @Column(name = "end_date", nullable = false)
    private Date endDate;

    @Column(name = "year", nullable = false)
    private Integer year;

    @OneToMany(mappedBy = "payrollMonth")
    private List<Payroll> payrolls;

    public PayrollMonth() {
    }

    public PayrollMonth(Integer payrollMonthId, String monthName, Date startDate, Date endDate, Integer year, List<Payroll> payrolls) {
        this.payrollMonthId = payrollMonthId;
        this.monthName = monthName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.year = year;
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

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public List<Payroll> getPayrolls() {
        return payrolls;
    }

    public void setPayrolls(List<Payroll> payrolls) {
        this.payrolls = payrolls;
    }
}

