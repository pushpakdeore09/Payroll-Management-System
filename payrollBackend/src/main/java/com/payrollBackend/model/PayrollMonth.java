package com.payrollBackend.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "payrollmonth")
public class PayrollMonth {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer payrollmonthId;

    @Column(name = "month_name")
    private String monthName;

    @Column(name = "start_date")
    private String startDate;

    @Column(name = "end_date")
    private String endDate;

    @OneToMany(mappedBy = "payrollmonth")
    private List<Payroll> payrolls;

    public PayrollMonth() {
    }

    public PayrollMonth(Integer payrollmonthId, String monthName, String startDate, String endDate, List<Payroll> payrolls) {
        this.payrollmonthId = payrollmonthId;
        this.monthName = monthName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.payrolls = payrolls;
    }

    public Integer getPayrollMonthId() {
        return payrollmonthId;
    }

    public void setPayrollMonthId(Integer payrollMonthId) {
        this.payrollmonthId = payrollMonthId;
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

